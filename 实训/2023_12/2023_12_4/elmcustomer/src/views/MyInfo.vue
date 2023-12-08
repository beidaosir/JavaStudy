<template>
    <div class="login-page">
      <!-- 导航栏部分 -->
      <van-nav-bar :title="phone" />
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
          label="输入密码"
          placeholder="输入密码"
          :rules="[
            { required: true, message: '请填写密码' },
            { pattern: /^\d{6}$/, message: '密码包含6个字符' }
          ]"
        />

        <van-field
          v-model="repass"
          type="password"
          name="repass"
          label="重复密码"
          placeholder="重复密码"
          :rules="[
            { required: true, message: '请填写重复密码' },
            { pattern: /^\d{6}$/, message: '密码包含6个字符' }
          ]"
        />

        <van-field name="radio" label="性别">
            <template #input>
                <van-radio-group v-model="gender" direction="horizontal">
                <van-radio :name="0">男</van-radio>
                <van-radio :name="1">女</van-radio>
                </van-radio-group>
            </template>
        </van-field>

        <van-field
            v-model="birthday"
            is-link
            readonly
            name="datePicker"
            label="时间选择"
            placeholder="点击选择时间"
            @click="showPicker = true"
        />
        <van-popup v-model:show="showPicker" position="bottom">
            <van-date-picker @confirm="onConfirm" @cancel="showPicker = false" />
        </van-popup>

        <van-field name="uploader" label="上传头像">
            <template #input>
                <van-uploader v-model="pics" multiple :max-count="1" />
            </template>
        </van-field>

        <div style="margin: 16px">
          <van-button block type="primary" native-type="submit">提交</van-button>
        </div>
      </van-form>

      <van-row>
        <van-col :span="12" :offset="2">
            <van-button plain type="success" size="small"  to="/loginPhone">去登录</van-button>
        </van-col>
      </van-row>
      
    </div>
  </template>
   
  <script>
  export default {
    name: 'MyInfo',
    data () {
      return {
        showPicker: false,
        username: 'zhangsan',
        phone: '13700112299',
        password: '123456',
        repass: '123456',
        gender: 0,
        birthday: '2000-01-01',
        pics: [
            {url: 'https://fastly.jsdelivr.net/npm/@vant/assets/leaf.jpeg'}
        ]
      }
    },
    methods: {
      onSubmit (values) {
        console.log('submit', values)
        localStorage.setItem('currentUser',JSON.stringify({username:this.username}));
        this.$router.push({path:'/my'})
      },
      onConfirm(v){
        this.birthday = v.selectedValues.join('-');
        this.showPicker = false;
      }
    }
  }
  </script>