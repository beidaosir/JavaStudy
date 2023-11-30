<template>
    <div>
        <ul>
            <li v-for="(todoObj, index) in todoList" :key="todoObj.id">
                <input type="checkbox" @change="checkTodo(todoObj.id)" :checked="todoObj.done" />
                {{ index + 1 }} . {{ todoObj.content }}
                <button @click="del(todoObj.id)">删除</button>
            </li>
        </ul>
    </div>
</template>


<script>
export default {
    name: "TodoMain",
    data() {
        return {
            
        };
    },

    props:['todoList','del','checkTodo'],
    
};
</script>

<style scoped>
ul{
    margin: 20px;
    list-style: none;
}

ul li{
    cursor: pointer;
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