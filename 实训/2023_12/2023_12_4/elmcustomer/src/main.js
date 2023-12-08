import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
//引入
import Vant from 'vant'
import 'vant/lib/index.css'
import store from './store'
import axios from 'axios'

//切换路由tabbar联动
router.beforeEach((to, from, next) => {
    console.log('----路由切换----',to)
    store.commit('changeTabActive',to.name);
    next(); //必须要有
  });

const app = createApp(App)

axios.defaults.baseURL = "http://localhost:8080"
//携带cookie
axios.defaults.withCredentials = true

//配置全局axios
app.config.globalProperties.$axios = axios;

//使用
app.use(Vant)
.use(store)
.use(router).mount('#app');
