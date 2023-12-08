<template>
    <div class="login-page">
      <!-- 导航栏部分 -->
      <van-nav-bar title="饿了么注册" />
   
      <!-- 一旦form表单提交了，就会触发submit，可以在submit事件中
           根据拿到的表单提交信息，发送axios请求
       -->
      <van-form @submit="onSubmit">
        <!-- 输入框组件 -->
        <!-- \w 字母数字_   \d 数字0-9 -->
        <van-field
          v-model="phone"
          name="username"
          label="手机号"
          placeholder="手机号"
          :rules="[
            { required: true, message: '请填写手机号' },
            { pattern: /^[0-9]{11}$/, message: '手机号为11位数字' }
          ]"
        />

        <van-field
            v-model="sms"
            center
            clearable
            label="短信验证码"
            :rules="[
                { required: true, message: '请填写验证码' },
                { pattern: /^[0-9]{6,}$/, message: '验证码包含6个数字' }
            ]"
        >
            <template #button>
            <van-button size="small" type="primary">发送验证码</van-button>
            </template>
        </van-field>

        <div style="margin: 16px">
          <van-button block type="primary" native-type="submit" to="/info">注册</van-button>
        </div>
      </van-form>

      <van-row>
        <van-col :span="12" :offset="2">
            <van-button plain type="success" size="small"  to="/phone">去登录</van-button>
        </van-col>
      </van-row>
      
    </div>
  </template>
   
  <script>
  export default {
    name: 'Register',
    data () {
      return {
        phone: '13700112299',
        sms: '123456',
      }
    },
    methods: {
      onSubmit (values) {
        console.log('submit', values)
      }
    }
  }
  </script>