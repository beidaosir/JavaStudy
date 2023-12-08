<template>
  <div class="about">
    <van-cell center inset  v-if="currentUser.username">
      <!-- 使用 title 插槽来自定义标题 -->
      <template #title>
        <van-image
          round
          width="50px"
          height="50px"
          src="https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg"
        />
        <span></span>
      </template>
      <template #label>
        <span class="custom-title">{{currentUser.username}}</span>
      </template>
    </van-cell>
    <van-cell center inset  v-else>
      <!-- 使用 title 插槽来自定义标题 -->
      <template #title>
        <van-button plain type="success" size="small"  to="/login">账号密码登录</van-button>
      </template>
    </van-cell>

    <van-grid :border="false" :column-num="4">
      <router-link to="/myaddress"><van-grid-item text="我的地址"  icon="location-o"></van-grid-item></router-link>
      
      <van-grid-item text="我的客服"  icon="service-o"></van-grid-item>
      <van-grid-item text="关于" icon="description-o"></van-grid-item>
      <van-grid-item text="用户隐私" icon="shield-o"></van-grid-item>
      <van-grid-item text="规则中心" icon="warning-o"></van-grid-item>
    </van-grid>
  </div>
</template>

<script>
export default{
  name: 'My',
  data() {
    return {
      currentUser: {}
    }
  },
  mounted(){
    const user = localStorage.getItem('currentUser');
    if(user){
      this.currentUser = JSON.parse(user);
    }
    
  }
}
</script>
