<template>
    <van-row>
        <van-col span="24">
            <van-image
                width="100%"
                height="200"
                src="https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg"
            />
        </van-col>
    </van-row>
    <van-row class="priceRow">
        <van-col span="5">
           <span class="priceCode">￥</span><span class="priceValue">19</span>
        </van-col>
        <van-col span="5" offset="12">
           <span>百亿补贴</span>
        </van-col>
    </van-row> 
    <van-row class="nameRow">
        <van-col span="10" style="color: #555;">  
            巴适黑毛肚 
        </van-col>
        <van-col span="8" offset="6">  
            <van-button style="vertical-align: middle;" 
            color="linear-gradient(to right, #ff6034, #ee0a24)" size="small"
            @click="toCart">
                加入购物车</van-button> 
        </van-col>
    </van-row> 
    
    <van-row>
        <van-col span="24">  
            详情信息
        </van-col>
    </van-row>      
</template>

<script>
export default {
    name: 'FoodDetail',
    methods: {
        toCart(){
            this.$router.push('/cart')
        }
    },
} 
</script>

<style scoped>
 .priceRow{
    background-color: #f92b1d;
    height: 50px;
    line-height: 50px;
    color: white;

 }
 .priceCode{
    font-size: 14px;
 }
 .priceValue{
    font-size: 20px;
 }

 .nameRow{
    background-color: beige;
    height: 50px;
    line-height: 50px;
 }
</style>