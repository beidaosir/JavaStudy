import { createStore } from 'vuex'

export default createStore({
  state: {
    num:10
  },
  getters: {
    newnum(state){
      return state.num*state.num
    }
  },
  mutations: {
    addMethod(state,param){
      state.num += param;
    }
  },
  actions: {
    addMethod(state,param){
      setTimeout(()=>{
        state.commit('addMethod',param)
      },3000);
    }
  },
  modules: {
  }
})
