<template>
    <div class="login-page">
      <!-- 导航栏部分 -->
      <van-nav-bar title="饿了么登录" />
   
      <!-- 一旦form表单提交了，就会触发submit，可以在submit事件中
           根据拿到的表单提交信息，发送axios请求
       -->
      <van-form @submit="onSubmit">
        <!-- 输入框组件 -->
        <!-- \w 字母数字_   \d 数字0-9 -->
        <van-field
          v-model="username"
          name="username"
          label="用户名"
          placeholder="用户名"
          :rules="[
            { required: true, message: '请填写用户名' },
            { pattern: /^\w{5,}$/, message: '用户名至少包含5个字符' }
          ]"
        />
        <van-field
          v-model="password"
          type="password"
          name="password"
          label="密码"
          placeholder="密码"
          :rules="[
            { required: true, message: '请填写密码' },
            { pattern: /^\d{6}$/, message: '密码包含6个字符' }
          ]"
        />
        <div style="margin: 16px">
          <van-button block type="primary" native-type="submit">登录</van-button>
        </div>
      </van-form>

      <van-row>
        <van-col :span="12" :offset="2">
            <van-button plain type="success" size="small" to="/phone">手机验证码登录</van-button>
        </van-col>
        <van-col :span="10">
            <van-button plain type="success" size="small" to="/register">去注册</van-button>
        </van-col>
      </van-row>
      
    </div>
  </template>
   
  <script>
  export default {
    name: 'login-page',
    data () {
      return {
        username: '',
        password: ''
      }
    },
    methods: {
      //******************点击确认登录提交表单******************** */
      onSubmit (values) {
        console.log('submit', values)
        //发送登录请求  
        this.$axios({
          method:'post',
          url: '/user/app/log',
          data: values
        }).then(res=>{
          console.log(res);
          if (res.data.code == 200) {
            //登录成功存储currentUser
             localStorage.setItem('currentUser',JSON.stringify(res.data.data));
             this.$router.back(); //比如点击加入购物车 发现没登录  登录完成需要跳转回去
          }
        })
      }
    }
  }
  </script>