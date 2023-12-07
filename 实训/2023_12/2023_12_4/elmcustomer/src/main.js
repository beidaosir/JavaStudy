import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
//引入
import Vant from 'vant'
import 'vant/lib/index.css'
import { ConfigProvider } from 'vant';

import store from './store'

router.beforeEach((to, from, next) => {
    console.log('----路由切换----',to)
    store.commit('changeTabActive',to.name);
    next(); //必须要有
  });

const app = createApp(App)
//使用
app.use(Vant)
.use(store)
.use(ConfigProvider)
.use(router).mount('#app');