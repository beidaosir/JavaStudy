import {
  createRouter,
  createWebHashHistory
} from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Welcome from '../components/Welcome.vue'
import Business from '../components/Business.vue'
import Food from '../components/Food.vue'
import LoginView from '../views/LoginView'
import EditBusiness from '../components/EditBusiness.vue'
import Temp from '../components/Temp.vue'


const routes = [{
    path: '/',
    name: 'home',
    component: HomeView,
    children: [

      //如果访问默认路径，重定向到welcome
      {
        path: '/',
        redirect: '/welcome'
      },

      //配置欢迎路由
      {
        path: '/welcome',
        name: 'welcome',
        component: Welcome
      },

      //配置商家路由
      {
        path: '/business', //父路由组合子路由路径
        name: 'business',
        component: Business
      },

      //配置商品路由
      {
        path: '/food', 
        name: 'food',
        component: Food
      }, 
      {
        path: '/editbusiness', 
        name: 'editbusiness',
        component: EditBusiness
      }, 
      
      
      {
        path: '/temp', 
        name: 'temp',
        component: Temp
      }, 
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  }

]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router