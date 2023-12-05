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
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
