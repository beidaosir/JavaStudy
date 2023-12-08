<template>
  <div class="about">
    <van-row>
      <van-col span="24">
        <!-- ****************搜索框**************** -->
        <van-search
          v-model="query.businessName"
          show-action
          shape="round"
          background="#fde1aa"
          placeholder="请输入搜索关键词"
          @search="onSearch"
        >
        <!-- 搜索框旁边的刷新按钮 -->
        <template #action>
          <div @click="onCancel" style="background-color: white;width: 20px;height: 20px;border-radius: 50% 50%;text-align: center;line-height: 20px;">
            <van-icon name="replay" />
          </div>
        </template>
        </van-search>

        <!-- *********************列表*********************** -->
        <van-list
          v-model:loading="loading"
          :finished="finished"
          finished-text="没有更多了"
          @load="onLoad"
        >
          <!-- ***********列表中显示商家信息的卡片************** -->
          <van-card  v-for="business in listData" :key="business.businessId"
              :price="business.startPrice+'起送'"
              :desc="business.businessExplain"
              :title="business.businessName"
              :thumb="business.businessPic"
            >
              <template #tags>
                <van-tag plain type="primary">营养小吃</van-tag>
                <van-tag plain type="primary">当地美食</van-tag>
              </template>
              <template #footer>
                <van-button size="mini" @click="toFood(business)">去点餐</van-button>
              </template>
          
            </van-card>

        </van-list>
      </van-col>
    </van-row>

    
  </div>
</template>

<script>
export default{
  name:'Business',
  data() {
    return {
      loading: false,  //正在加载
      finished: false, //是否全部查完
      totalRows: 0, //商家总数量
      totalPages: 0, 
      //分页搜索查询条件
      query: {
        currentPage: 1,
        pageNumber: 5,
        businessName: ''
      },
      //展示的商家列表
      listData: []
    }
  },
  methods: {
    //**************跳转到餐品列表组件*************** */
    toFood(business){
      console.log(business)
      //复制商家对象的属性到另一个对象中
      const bs = Object.assign({},business);
      //路由跳转
      this.$router.push({path:'/food',state:{bs}});
    },
    //********************点击刷新按钮********************* */
    onCancel(){
      this.listData = [];
      this.query.currentPage = 1;
      this.query.businessName = ''
      this.onLoad();
    },
    //*****************输入条件回车触发*********************** */
    onSearch(){
      this.listData = [];  //清空集合
      this.query.currentPage = 1;  //重置页码为1
      this.onLoad(); //调用加载方法去查询
    },
    //***************加载商家信息的方法***************** */
    onLoad(){
      this.loading = true;   //正在加载设置为true
      this.finished = false;  //设置未完成
      //发送请求进行查询
      this.$axios({ 
        method: 'post',
        url: '/business/app/page',
        data: this.query
      }).then(res=>{
        //查询得到响应
        this.loading = false;  //设置不在加载状态
        console.log(res.data)

        //响应的ResponseObj的响应码
        if(res.data.code==200){
          //ResponseObj中的PageBean拿出来 将totalRows赋值给data中的totalRows
          this.totalRows = res.data.data.totalRows
          //拿出PageBean中的List 遍历 将拿出的每一个商家对象加入data中用来展示商家的listData中
          res.data.data.data.forEach(business => {
            this.listData.push(business);
          });
          
          console.log(this.listData.length,this.totalRows)

          //判断listData的商家数量和totalRows总数量一致 就停下来
          if(this.listData.length == this.totalRows){
            this.finished = true; //设置为完成
            return;
          }
          //每次查完更新当前页的页码
          this.query.currentPage++;
        }
      })
    }
  },
}
</script>