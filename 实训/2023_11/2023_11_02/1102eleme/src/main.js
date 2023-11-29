import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

createApp(App).use(store).use(router).mount('#app')

// 添加全局路由守卫
router.beforeEach((to, from, next) => {
    console.log('------进入路由守卫------')
    // 使用isLogin来模拟是否登录
    let isLogin = JSON.parse(localStorage.getItem('loginUser'));
    // 判断to.path(要跳转的路径)是否是需要权限验证的
    if ('/login' != to.path) {
        //之前有没有登录  如果没有登录
        if (!isLogin) {
            router.push({
                path: '/login'
            })
            //location.reload(); 
        }
    }
    next(); //必须要有
  });