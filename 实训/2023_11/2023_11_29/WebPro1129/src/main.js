import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/lib/theme-chalk/index.css'
import './assets/css/icon.css'
import axios from 'axios'

const app = createApp(App)

app.use(ElementPlus)
    .use(store)
    .use(router)

axios.defaults.baseURL = "http://localhost:8080"
//携带cookie
axios.defaults.withCredentials = true

//配置全局axios
app.config.globalProperties.$axios = axios;

/*
配置axios统一处理响应
所有axios请求得到响应都会进行以下处理
*/
axios.interceptors.response.use(res=>{
    console.log('统一处理后端返回的数据---',res,res.data.code);
    if(res.data.code == 501){
        router.push({
            path: "/login"
        });
    }else{
        return res;
    }
    
},error=>{
    return Promise.reject(error);
})



app.mount('#app')