<template>
    <van-tabbar v-model="active">
        <van-tabbar-item to="/" name="home" icon="home-o">首页</van-tabbar-item>
        <van-tabbar-item to="/business" name="business" icon="shop-o">商家</van-tabbar-item>
        <van-tabbar-item to="/order" name="order" icon="orders-o">订单</van-tabbar-item>
        <van-tabbar-item to="/my" name="my">
            <span>我的</span>
            <template #icon="props">
                <img :src="props.active ? icon.active : icon.inactive" />
            </template>
        </van-tabbar-item>
    </van-tabbar>
</template>

<script>
export default{
    name: 'TabBar',
    data() {
        return {
            active: 'home',
            icon: {
                active: 'https://fastly.jsdelivr.net/npm/@vant/assets/user-active.png',
                inactive:'https://fastly.jsdelivr.net/npm/@vant/assets/user-inactive.png',
            }
        }
    }, 
} 
</script>

<style>
</style>