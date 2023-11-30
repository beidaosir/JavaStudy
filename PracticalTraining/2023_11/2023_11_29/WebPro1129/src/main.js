import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/lib/theme-chalk/index.css'
import './assets/css/icon.css'
import axios from 'axios'

const app = createApp(App)

axios.defaults.baseURL = "http://localhost:8080"
//配置全局axios
app.config.globalProperties.$axios = axios;

app.use(ElementPlus)
    .use(store)
    .use(router)
    .mount('#app')