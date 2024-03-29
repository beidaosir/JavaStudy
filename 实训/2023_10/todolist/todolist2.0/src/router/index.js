import { createRouter, createWebHashHistory } from 'vue-router'
import TodoView from '../views/TodoView.vue'

const routes = [
  {
    path: '/',
    name: 'todo',
    component: TodoView
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
