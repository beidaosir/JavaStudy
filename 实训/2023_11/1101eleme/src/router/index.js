import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Welcome from '../components/Welcome.vue'
import Business from '../components/Business.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    children:[

      //如果访问默认路径，重定向到welcome
      {
        path:'/',
        redirect: '/welcome'
      },

      //配置欢迎路由
      {
        path:'/welcome',
        name:'welcome',
        component:Welcome
      },

      //配置商家路由
      {
        path:'/business',//父路由组合子路由路径
        name:'business',
        component:Business
      }
    ]
  },
  
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
