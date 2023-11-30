<template>
    <div>
        <h1>{{ title }}</h1>
        <!-- 3.使用 -->
        <!-- 将add函数传递给TodoHeader子组件 -->
        <TodoHeader :add="add"></TodoHeader>
        <TodoMain :todoList ="todoList" :del="del" :checkTodo="checkTodo"></TodoMain>
        <TodoFooter :doneTotal="doneTotal" :listlen="listlen"></TodoFooter>
    </div>
</template>


<script>
//1.引入
import TodoHeader from '../components/TodoHeader.vue'
import TodoMain from '../components/TodoMain.vue'
import TodoFooter from '../components/TodoFooter.vue'


export default {
    name: 'TodoView',
    data() {
        return {
            title: '我的待办事项',
            todoList:[]
            
        }
    },
    methods:{
        //添加方法，无论谁调用这个方法都要传入一个todo对象
        add(todoObj){
            this.todoList.unshift(todoObj);
            window.localStorage.setItem('todoList',JSON.stringify(this.todoList));
        },

        //删除方法   无论谁调用这个方法传入要删除的id即可
        del(delId){
            this.todoList=this.todoList.filter(todoObj=>todoObj.id != delId);
            window.localStorage.setItem('todoList',JSON.stringify(this.todoList));
        },

        //勾选和取消的方法
        checkTodo(checkId){
            for(let i = 0;i<this.todoList.length;i++){
                if(this.todoList[i].id == checkId){
                    //找到对应的todo对象   更改他的done值   选中改成true   取消改成false
                    //推断：之前是选中状态的话  修改一次应该是取消掉 反之就是选中
                    //也可以 从事件对象中来获取  event.target.checked
                    this.todoList[i].done = !this.todoList[i].done;
                    break;
                }
            }
            window.localStorage.setItem('todoList',JSON.stringify(this.todoList));
        }

    },
    computed:{
        //统计完成的待办事项
        doneTotal(){
            return this.todoList.reduce((total,todoObj)=>todoObj.done?total+1:total,0);
        },
        //计算集合的长度
        listlen(){
            return this.todoList.length;
        }
    },

    //2.注册
    components:{
        TodoHeader,
        TodoMain,
        TodoFooter
    },
    //挂载完毕之后
    mounted(){
        //读取存储的todoList的数据
        let jsonStr = window.localStorage.getItem('todoList');
        if(jsonStr){
            this.todoList = JSON.parse(jsonStr);
        }
    }
}
</script>

<style>

</style>

