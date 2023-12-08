<template>
    
    <van-row>
        <van-col :span="24">
            <div>商家名称：{{business.businessName}}</div>
        </van-col>
    </van-row>
    <van-row>
        <van-col :span="24">
            <!-- ***************当前商家的餐品列表******************* -->
            <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
                <van-list
                    v-model:loading="loading"
                    :finished="finished"
                    finished-text="没有更多了"
                    @load="onLoad"
                >
                    <van-card v-for="food in list" :key="food.foodId"
                        :price="food.foodPrice"
                        :title="food.foodName"
                        :thumb="food.foodPic"
                        >
                        <template #tags>
                            <van-tag plain type="primary">点我呀</van-tag>
                            <van-tag plain type="primary">超级好吃</van-tag>
                        </template>
                        <template #footer>
                            <van-button size="mini" @click="insertCart(food)">加入餐车</van-button>
                            <van-button size="mini" @click="foodDetail(food.foodId)">查看详情</van-button>
                        </template>
                    </van-card>
                </van-list>
            </van-pull-refresh>
        </van-col>
    </van-row>
</template>

<script>
import { showConfirmDialog } from 'vant';
export default {
    name: 'Food',
    data() {
        return {
            currentUser: {},
            loading: false,
            finished: false,
            business: {},  //当前的商家对象
            totalRows: 0,
            query: {
                currentPage: 1,
                pageNumber: 5,
                businessId: null
            },
            list:[],
            refreshing: false,
            
        }
    },
    methods: {
        //******************添加购物车*********************** */
        insertCart(food){
            
            if(!this.currentUser.userId){
                showConfirmDialog({
                    title: '提示',
                    message:
                        '您尚未登录，是否去登录页面',
                })
                .then(() => {
                    this.$router.push('/login')
                })
                .catch(() => {
                    // on cancel
                });
                return;
            }

            //添加购物车项
            this.$axios({
                method: 'post',
                url: '/cart/app/'+this.business.bid+'/'+this.currentUser.userId,
                data: {
                    foodId: food.foodId,
                    number: 1,
                }
            }).then(res=>{
                if (res.data.code == 200) {
                   console.log(res);
                   const bu = {businessId: this.business.bid,userId: this.currentUser.userId}
                   this.$router.push({path:'/cart',state: {bu}})
                }
            })
        },
        foodDetail(foodId){
            console.log(foodId);
            this.$router.push('/foodDetail?id='+foodId);
        },
        //*****************查询餐品信息****************** */
        onLoad(){
            this.$axios({
                method: 'post',
                url:'/food/app/page',
                data: this.query
            }).then(res=>{
                this.loading = false;
                if(res.data.code == 200){
                    this.totalRows = res.data.data.totalRows;
                    res.data.data.data.forEach(element => {
                        this.list.push(element);
                    });
                    console.log(this.list);
                    if(this.list.length == this.totalRows){
                        this.finished = true;
                        return;
                    }
                    this.query.currentPage++;
                }
            })
        },
        onRefresh(){
            // 清空列表数据
            this.finished = false;

            // 重新加载数据
            // 将 loading 设置为 true，表示处于加载状态
            this.loading = true;
            onLoad();
        },
    },
    mounted(){
        //获取Business组件传递的数据
        this.business = history.state.bs
        //将商家id放入查询条件中
        this.query.businessId = this.business.bid
        //从本地存储尝试获取user信息
        const user = localStorage.getItem("currentUser");
        if(user){
           this.currentUser = JSON.parse(user);
        }
        console.log('当前登录用户',this.currentUser,this.currentUser.userId);
    }
} 
</script>

<style></style>