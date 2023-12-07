import { createStore } from 'vuex'

// Vuex 数据管理框架
export default createStore({
  state: {
    tabActive: 'home'
  },
  getters: {
   
  },
  mutations: {
    changeTabActive(state,param){
        console.log('---修改了----',param)
        state.tabActive = param
    }
  },
  actions: {
  },
  modules: {
  }
})