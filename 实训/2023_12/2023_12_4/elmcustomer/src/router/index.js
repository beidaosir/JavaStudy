import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/business',
    name: 'business',
    component: () => import('../views/Business.vue')
  },
  {
    path: '/order',
    name: 'order',
    component: () => import('../views/Order.vue')
  },
  {
    path: '/my',
    name: 'my',
    component: () => import('../views/My.vue')
  },
  {
    path: '/food',
    name: 'food',
    component: () => import('../views/Food.vue')
  },
  {
    path: '/foodDetail',
    name: 'foodDetail',
    component: () => import('../views/FoodDetail.vue')
  },
  {
    path: '/cart',
    name: 'cart',
    component: () => import('../views/Cart.vue')
  },
  {
    path: '/orderSub',
    name: 'orderSub',
    component: () => import('../views/OrderSub.vue')
  },
  {
    path: '/myaddress',
    name: 'myaddress',
    component: () => import('../views/MyAddress.vue')
  },
  {
    path: '/addaddress',
    name: 'addaddress',
    component: () => import('../views/AddAddress.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
