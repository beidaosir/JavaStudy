<template>
  <div class="home">

    <!-- 消息循环播放 -->
    <van-row >
      <van-col span="24">
        <van-notice-bar
          left-icon="volume-o"
          scrollable 
          style="height: 25px;"
          background="#feeae8"
          text="无论我们能活多久，都不能缺少美食的陪伴，下单吧，亲。"
        />
      </van-col>
    </van-row>

    <!-- 轮播图 -->
    <van-row>
      <van-col span="24" :style="{padding:'0 5px 5px 5px'}">
        <van-swipe :autoplay="3000" lazy-render>
          <van-swipe-item v-for="image in images" :key="image">
            <img :src="image" style="width: 100%;height: 180px;"/>
          </van-swipe-item>
        </van-swipe>
      </van-col>
    </van-row> 

    <!-- 可操作的选项点击进入下一个页面 -->
    <van-row gutter="10" class="option">
      <van-col span="8">
        <van-image
            @click="toOption('business')"
            width="50%"
            src="https://s1.aigei.com/src/img/png/ee/eec633b20631436e8d9f0e21bad98866.png?e=1735488000&token=P7S2Xpzfz11vAkASLTkfHN7Fw-oOZBecqeJaxypL:Pq2OGfwRL46aRotzUOuSgGZO3Ho="
          />
        <div>美食外卖</div>
      </van-col>
      <van-col span="8">
        <van-image
          width="50%"
          src="https://s1.4sai.com/src/img/png/05/05939bc7aa914d73a8176c0e63b3f7e3.png?imageMogr2/auto-orient/thumbnail/!282x282r/gravity/Center/crop/282x282/quality/85/&e=1735488000&token=1srnZGLKZ0Aqlz6dk7yF4SkiYf4eP-YrEOdM1sob:roy3xGd7tiK4Nl8nnh_yS422pPs="
        />
        <div>超市便利</div>
      </van-col>
      <van-col span="8">
        <van-image
          width="50%"
          src="https://s1.4sai.com/src/img/png/31/31a32c6cbcf74a7186c6e24feb0ba6f1.png?imageMogr2/auto-orient/thumbnail/!282x282r/gravity/Center/crop/282x282/quality/85/&e=1735488000&token=1srnZGLKZ0Aqlz6dk7yF4SkiYf4eP-YrEOdM1sob:XJnyuLbZhy1ons7jggOt0AB7TGk="
        />
        <div>新鲜水果</div>
      </van-col>
      
    </van-row>

    <van-row gutter="10" class="option" >
     <van-col span="8">
        <van-image
          width="50%"
          src="https://s1.aigei.com/src/img/png/40/401781d133024cb487eb647a4aed2798.png?imageMogr2/auto-orient/thumbnail/!282x282r/gravity/Center/crop/282x282/quality/85/&e=1735488000&token=P7S2Xpzfz11vAkASLTkfHN7Fw-oOZBecqeJaxypL:gyPvXKFjKtjbItPX_gEtg_fynEo="
        />
        <div>跑腿代购</div>
      </van-col>
      <van-col span="8">
        <van-image
          width="50%"
          src="https://s1.aigei.com/src/img/png/b6/b6b252c54466485e936e5779d953da21.png?imageMogr2/auto-orient/thumbnail/!282x282r/gravity/Center/crop/282x282/quality/85/&e=1735488000&token=P7S2Xpzfz11vAkASLTkfHN7Fw-oOZBecqeJaxypL:ppdbqWp-KKa31vdmVsduqjL-dlA="
        />
        <div>休闲娱乐</div>
      </van-col>
      <van-col span="8">
        <van-image
          width="50%"
          src="https://s1.4sai.com/src/img/png/7d/7d60b6191c4747a1ac88c00ce5e8a8d0.png?imageMogr2/auto-orient/thumbnail/!282x282r/gravity/Center/crop/282x282/quality/85/&e=1735488000&token=1srnZGLKZ0Aqlz6dk7yF4SkiYf4eP-YrEOdM1sob:T2LJCwe_X9iVo9HYjjannc5Tlv0="
        />
        <div>电影演出</div>
      </van-col>
    </van-row>

    
  </div>
</template>

<script>

export default {
  name: 'HomeView',
  data() {
    return {
      images:[
      'http://s4tdoh0lx.bkt.clouddn.com/meishi001.jpg',
      'http://s4tdoh0lx.bkt.clouddn.com/meishi002.jpg',
      'http://s4tdoh0lx.bkt.clouddn.com/meishi003.jpg',
      'http://s4tdoh0lx.bkt.clouddn.com/meishi004.jpg',
      'http://s4tdoh0lx.bkt.clouddn.com/meishi005.jpg'
      ]
    }
  },
  methods: {
    toOption(who){
      this.$router.push({name:who});
      
    }
  },
}
</script>

<style scoped>

  .option{
    height: 100px;
    font-size: 14px;
    color: #555;
  }

</style>
