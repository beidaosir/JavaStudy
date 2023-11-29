<template>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4" style="margin: 0 auto;">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">请登录</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <fieldset>
                                <div class="form-group">
                                    <!-- *********双向数据绑定   收集账号********* -->
                                    <input class="form-control" placeholder="用户名" type="text" autofocus
                                        v-model="loginForm.account">
                                </div>
                                <div class="form-group">
                                    <!-- *********双向数据绑定   收集密码********* -->
                                    <input class="form-control" placeholder="密码" type="password"
                                        v-model="loginForm.password">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox">记住我
                                    </label>
                                </div>

                                <div class="form-group">
                                    <div class="form-check form-check-inline">
                                        <!-- ********单选框 选登录角色 *********** -->
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions"
                                            id="inlineRadio1" value="manager" v-model="loginRole">
                                        <label class="form-check-label" for="inlineRadio1">管理员</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions"
                                            id="inlineRadio2" value="business" v-model="loginRole">
                                        <label class="form-check-label" for="inlineRadio2">商家</label>
                                    </div>
                                </div>

                                <!-- Change this to a button or input when using this as a form -->
                                <a href="javascript:;" @click="login" class="btn btn-lg btn-success btn-block">登录</a>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'LoginView',
    data() {
        return {
            //----------初始化的管理员集合-----------
            loginUsers: [
                {
                    userId: 1,
                    account: 'admin',
                    password: '123456',
                    role: 'manager'
                },
                {
                    userId: 2,
                    account: 'zhangsan',
                    password: '123456',
                    role: 'manager'
                },
            ],
            //-----------收集登录表单的数据 用户名和密码-------------
            loginForm: {
                account: '',
                password: ''
            },
            //----------收集登录角色  管理员还是商家登录-------------------
            loginRole: 'manager'
        }
    },
    methods: {
        login() {
            //1、设置登录成功为false
            let success = false;

            //2、管理员登录
            if (this.loginRole == 'manager') {

                //遍历管理员的集合
                this.loginUsers.forEach((loginUser) => {
                    //判断当前遍历到的用户的账号密码是否跟输入的一致
                    if (loginUser.account == this.loginForm.account && loginUser.password == this.loginForm.password) {
                        //一致  登录成功
                        //路由跳转  进入主页
                        this.$router.push('/');
                        //将登录成功的用户信息进行存储
                        window.localStorage.setItem('loginUser', JSON.stringify(loginUser));
                        //将登录成功设为true
                        success = true;
                    }
                })

            } 
            //3、商家登录
            else if (this.loginRole == 'business') {
               
               //从本地存储读取商家信息 从字符串转成集合对象
               let businessList = localStorage.getItem('businessList') ? JSON.parse(localStorage.getItem('businessList')) : [];

               //遍历商家集合
               businessList.forEach((businessObj) => {
                    //对比每一个商家的账号密码和输入的是否一致
                    if (businessObj.businessAccount == this.loginForm.account && businessObj.password == this.loginForm.password) {
                        //如果一致  登录成功
                        this.$router.push('/');
                        window.localStorage.setItem('loginUser', JSON.stringify(businessObj));
                        success = true;
                    }
                })
            }

            
            //如果登录失败   提示一下用户
            if (!success) {
                alert('用户名或密码错误，请重试');
            }

        }
    }
} 
</script>

<style>
.container {
    margin-top: 150px;
}
</style>