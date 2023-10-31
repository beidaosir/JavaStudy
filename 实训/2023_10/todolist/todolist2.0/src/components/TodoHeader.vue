<template>
    <div>
        <input type="text" v-model="content" @keyup.enter="addAction" />
        <button @click="addAction">添加</button>
    </div>
</template>


<script>
import { nanoid } from "nanoid";
export default {
    name: "TodoHeader",
    data() {
        return {
            content: "",
        };
    },

    //接收父组件传递的add函数
    props: ["add"],
    methods: {
        addAction() {
            //1.构建对象
            let todoObj = {
                id: nanoid(),
                content: this.content,
                done: false,
            };

            //2.加入集合  集合在父组件(todoView)调用 父组件的add方法  使用父组件传递add函数
            this.add(todoObj);

            //3.清空content
            this.content = "";
        },
    },
};
</script>

<style scoped>
input{
    border: none;
    outline: none;
    border: solid 2px #999;
    border-radius: 5px;
    padding-left: 10px;
}

button{
    border: none;
    outline: none;
    background-color: #42b983;
    border-radius: 5px;
    margin-left: 10px;
    color: #FFF;
    
}
</style>