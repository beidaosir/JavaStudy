使用vuex必须安装
安装方式：
 1、创建项目时勾选vuex
 2、项目创建完毕之后  通过 npm i vuex

在src中创建store文件夹，在store文件夹中创建index.js文件

在index.js中编写以下内容
import { createStore } from 'vuex'

export default createStore({
  state: {
    
  },
  getters: {

  },
  mutations: {
    
  },
  actions: {
    
  }
})


在main.js中引入并使用


重点内容
1、 state是一个对象，对象中可以用键值对存储共享数据，所有组件都可以访问共享
    示例： 模仿data中的属性编写即可
    state: {
        number: 10
    }

在组件中的使用方式
{{$store.state.number}}
console.log(this.$store.state.number)

2、getters是一个对象，类似于组件中的computed计算属性
   示例： 
   getters: {
      newNumber(state){
         return state.number+10;
      }
   }

   在组件中的使用：
   {{$store.getters.newNumber}}
    console.log(this.$store.getters.newNumber)

3、mutations是一个对象，里面写方法，类似于组件中的methods，写同步
  示例：
  mutations: {
    add(state,param){
        state.number+=param
    }
  }

  在组件中的调用
  this.$store.commit('add',2);

4、actions是一个对象，里面写方法，类似于组件中的methods，可以写异步，可以调用mutations的方法
  示例：
   actions: {
     addAction(state,param){
        //异步
        setTimeout(()=>{
            //调用mutations的方法
            state.commit('add',param);
        },3000)
     }
   }

   在组件中的使用：
   this.$store.dispatch('addAction',3);