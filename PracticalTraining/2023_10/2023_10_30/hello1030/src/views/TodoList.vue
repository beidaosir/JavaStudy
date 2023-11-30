<template>
    <div>
        <h1>{{ title }}</h1>
        <div>
            <input type="text" v-model="content"><button @click="add">添加</button>
        </div>
        <ul>
            <li v-for="(todoObj, index) in todoList" :key="todoObj.id">
                <input type="checkbox" v-model="todoObj.done">
                {{ index + 1 }}、{{ todoObj.content }}
                <button @click="del(todoObj.id)">删除</button>
            </li>
        </ul>
        <p>完成了{{ countDone }}项/总共{{ todoList.length }}项</p>
    </div>
</template>


<script>

//使用nanoid需要先安装再引入
import { nanoid } from 'nanoid'
export default {
    name: 'TodoList',
    data() {
        return {
            title: '我的待办事项',
            content: '',
            todoList: [
                {
                    id: 1001,
                    content: '吃饭',
                    done: false
                },
                {
                    id: 1002,
                    content: '睡觉',
                    done: false
                }
            ]
        }
    },
    methods: {
        del(delId) {
            /* 方法一：
            for (let i = 0; i < this.todoList.length; i++) {
                if (this.todoList[i].id == delId) {
                    this.todoList.splice(i, 1);
                    break;
                }
            } */

            //方法二：
            /* let newArr = this.todoList.filter(function(currentObj){
                //返回true 当前currentObj就会加入新数组  false就不要了 
                return currentObj.id != delId
            })
            this.todoList = newArr; */

            //方法二优化版本：
            this.todoList = this.todoList.filter(currentObj=>currentObj.id != delId);

        },
        add() {
            //1.构建一个todo对象
            let todoObj = {
                id: nanoid(),
                content: this.content,
                done: false
            }
            console.log(todoObj);
            //2.加入到todoList中
            //this.todoList.push(todoList);  //添加到最后
            this.todoList.unshift(todoObj);  //添加到最前面

            //3.清空输入框  重置content即可
            this.content = ''
        }
    },
    computed:{
        countDone(){
            let number=0;
            for(let i = 0;i<this.todoList.length;i++){
                if(this.todoList[i].done){
                    number++;
                }
            }
            return number;
        }
    }
}
</script>

<style>
 ul {
            list-style: none;
            /* 设置列表项标记为方块 */
        }
</style>