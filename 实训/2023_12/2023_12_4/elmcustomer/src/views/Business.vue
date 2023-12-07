<template>
  <div class="about">
    <van-row>
      <van-col span="24">
        <van-list
          v-model:loading="loading"
          :finished="finished"
          finished-text="没有更多了"
          @load="onLoad"
        >
         <router-link 
         v-for="business in listData" :key="business.businessId"
         :to="{name:'food', path:'/food',query: {id: business.businessId}}">
          <van-card
              :price="business.startPrice+'起送'"
              :desc="business.businessExplain"
              :title="business.businessName"
              :thumb="business.pic"
            >
              <template #tags>
                <van-tag plain type="primary">营养小吃</van-tag>
                <van-tag plain type="primary">当地美食</van-tag>
              </template>
              <template #footer>
                <van-button size="mini">按钮</van-button>
                <van-button size="mini">按钮</van-button>
              </template>
            </van-card>

         </router-link>
            
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
      listData: [
        {
          businessId:1,
          businessAccount:'3213213',
          businessName:'美味小吃',
          businessExplain: '好吃不贵，非常实惠',
          startPrice: 15.5,
          deliveryPrice: 5.0,
          pic: 'https://fastly.jsdelivr.net/npm/@vant/assets/ipad.jpeg'
        },
        {
          businessId:2,
          businessAccount:'34444444',
          businessName:'兰州牛肉拉面',
          businessExplain: '好吃不贵，非常实惠',
          startPrice: 12.5,
          deliveryPrice: 4.0,
          pic: 'https://fastly.jsdelivr.net/npm/@vant/assets/ipad.jpeg'
        },
        {
          businessId:3,
          businessAccount:'5555555',
          businessName:'心语甜点',
          businessExplain: '好吃不贵，非常实惠',
          startPrice: 20.0,
          deliveryPrice: 8.0,
          pic: 'https://fastly.jsdelivr.net/npm/@vant/assets/ipad.jpeg'
        }
      ]
    }
  },
}
</script>