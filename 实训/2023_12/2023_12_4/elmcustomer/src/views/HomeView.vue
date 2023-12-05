<template>
  <div class="home">
    <van-row class="header">
      <van-col span="8">
        <span class="header-title">饿了么</span>
      </van-col>
      <van-col span="8">
        <van-icon name="location-o" />
        <span @click="showPicker = true">{{fieldValue}}</span>
      </van-col>
    </van-row>

    <van-row>
      <van-col span="24">
        <van-notice-bar
          left-icon="volume-o"
          scrollable 
          text="无论我们能活多久，都不能缺少美食的陪伴，下单吧，亲。"
        />
      </van-col>
    </van-row>

    <van-row>
      <van-col span="24">
        <van-swipe :autoplay="3000" lazy-render>
          <van-swipe-item v-for="image in images" :key="image">
            <img :src="image" style="width: 100%;height: 160px;"/>
          </van-swipe-item>
        </van-swipe>
      </van-col>
    </van-row> 

    <van-row gutter="10" class="option">
      <van-col span="8">
        <router-link to="/business">
          <van-image
            width="80%"
            height="70%"
            src="https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg"
          />
        </router-link>
        <div>美食外卖</div>
      </van-col>
      <van-col span="8">
        <van-image
          width="80%"
          height="70%"
          src="https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg"
        />
        <div>超市便利</div>
      </van-col>
      <van-col span="8">
        <van-image
          width="80%"
          height="70%"
          src="https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg"
        />
        <div>新鲜水果</div>
      </van-col>
      
    </van-row>

    <van-row gutter="10" class="option" >
     <van-col span="8">
        <van-image
          width="80%"
          height="70%"
          src="https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg"
        />
        <div>跑腿代购</div>
      </van-col>
      <van-col span="8">
        <van-image
          width="80%"
          height="70%"
          src="https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg"
        />
        <div>休闲娱乐</div>
      </van-col>
      <van-col span="8">
        <van-image
          width="80%"
          height="70%"
          src="https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg"
        />
        <div>电影演出</div>
      </van-col>
    </van-row>

    <van-popup v-model:show="showPicker" round position="bottom">
        <van-picker
          :columns="columns"
          @cancel="showPicker = false"
          @confirm="onConfirm"
        />
      </van-popup>
  </div>
</template>

<script>

export default {
  name: 'HomeView',
  data() {
    return {
      fieldValue: '暂无定位',
      showPicker: false,
      columns: [
      { text: '杭州', value: 'Hangzhou' },
      { text: '宁波', value: 'Ningbo' },
      { text: '温州', value: 'Wenzhou' },
      { text: '绍兴', value: 'Shaoxing' },
      { text: '湖州', value: 'Huzhou' },
      ],
      images:[
      'https://fastly.jsdelivr.net/npm/@vant/assets/apple-1.jpeg',
      'https://fastly.jsdelivr.net/npm/@vant/assets/apple-2.jpeg',
      ]
    }
  },
  methods: {
    onConfirm(e) {
      this.showPicker = false;
      this.fieldValue = e.selectedOptions[0].text;
    },
  },
}
</script>

<style scoped>

  .header{
    height: 35px;
    background-color: lightblue;
    line-height: 35px;
    font-size: 14px;
    color: #555;
  }

  .header-title{
    font-size: 20px;
    font-weight: bolder;
    color: white;
    font-family: '微软雅黑';
    letter-spacing: 3px;
  }

  .option{
    height: 100px;
    font-size: 14px;
    color: #555;
  }

</style>
