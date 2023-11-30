<template>
    <div>
        <ul>
            <li v-for="(news) in newsArr" :key="news.hotindex">{{ news.title }}</li>
        </ul>
    </div>
    
</template>

<script>
import axios from 'axios';
export default {
    name: 'NewsView',
    data() {
        return {
            newsArr: []
        }
    },
    methods: {
        getNewsData() {
            //创建XMLHttpRequest核心对象
            let xhr = new XMLHttpRequest();

            //open()方法来完成Http请求（get方式）
            xhr.open("get", "https://apis.tianapi.com/networkhot/index?key=f91a8a8f27aae6a2b9fd49ef0366b8af");
            //向服务器发送请求
            xhr.send(null);

            //使用onreadystatechange事件监听XMLHttpRequest对象状态。
            xhr.onreadystatechange = () => {
                //readyState属性代表了 XMLHttpRequest对象的五种状态。4状态为响应内容接收并解析完成
                if (xhr.readyState == 4) {
                    //http请求会返回一个状态码。200为请求成功。
                    if (xhr.status == 200) {
                        //xhr.responseText就是服务器端返回的数据
                        console.log(xhr.responseText);
                        let responseData = JSON.parse(xhr.responseText);

                        if (responseData.code == 200) {
                            this.newsArr = responseData.result.list;
                        }
                    }
                }
            };
        },
        getNewsDataByAxios(){
            axios.get("https://apis.tianapi.com/networkhot/index?key=f91a8a8f27aae6a2b9fd49ef0366b8af").then((resData)=>{
                console.log('使用axios请求获取的新闻数据---',resData);
                this.newsArr = resData.data.result.list;
            }).catch((error)=>{
                console.log('请求出错',error);
            })
        }


    },
    mounted() {
        //挂载完毕之后直接调用getNewsData获取热点新闻的数据
        //this.getNewsData();
        this.getNewsDataByAxios();
    }
} 
</script>

<style></style>