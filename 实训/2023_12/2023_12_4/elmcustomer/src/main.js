import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
//引入
import Vant from 'vant'
import 'vant/lib/index.css'

const app = createApp(App)
//使用
app.use(Vant)
.use(router).mount('#app');
