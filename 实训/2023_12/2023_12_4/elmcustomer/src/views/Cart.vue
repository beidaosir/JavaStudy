<template>
    <Address></Address>
    <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
        <van-list
            v-model:loading="loading"
            :finished="finished"
            finished-text="没有更多了"
            @load="onLoad"
        >
        <van-card v-for="item in cartItems" :key="item.itemId"
            :price="item.food.foodPrice"
            :title="item.food.foodName"
            :thumb="item.food.foodPic"
            >
            <template #tags>
                <span>小计：￥{{item.number*item.food.foodPrice}}</span>&nbsp;&nbsp;&nbsp;&nbsp;
                <van-stepper v-model="item.number" theme="round" button-size="22" disable-input
                    @change="numberChange(item)"/>
            </template>
            <template #footer>
                <van-button size="mini" type="danger" round  @click="delItem(item)" ><van-icon name="cross" /></van-button>
            </template>
        </van-card>
            
        </van-list>
    </van-pull-refresh>

    <van-submit-bar :price="sumPrice" button-text="去下单" @submit="onSubmit" />
</template>

<script>
import { showConfirmDialog } from 'vant';
import Address from '@/components/Address.vue';
export default {
    name: 'Food',
    components: {Address},
    data() {
        return {
            cartItems: [],
            loading: false,
            refreshing: false,
            finished: false
        }
    },
    computed: {
        sumPrice(){
            let sum = 0;
            this.cartItems.forEach(item=>{
                sum += item.food.foodPrice*item.number
                console.log(item.food.foodPrice*item.number,sum)
            })
            return sum*100;
        }
    },
    methods: {
        delItem(item){
            showConfirmDialog({
                title: '提示',
                message:
                    '您是要删除这一项吗？',
            })
            .then(() => {
                
                this.$axios({
                    method: 'delete',
                    url: '/cart/app/'+item.itemId
                }).then(res=>{
                    if(res.data.code == 200){
                       this.cartItems = this.cartItems.filter(elem=>{
                            return elem.itemId!=item.itemId
                        })
                    }
                })
                
            })
            .catch(() => {
                
            });
        },
        //餐品数量变化调用
        numberChange(item){
            console.log(item);
            const param = Object.assign({},item);
            this.$axios({
                method: 'put',
                url: '/cart/app',
                data: param
            }).then(res=>{
                console.log(res);
            })
        },
        onSubmit(){
            this.$router.push("/order")
        },
        foodDetail(foodId){
            console.log(foodId);
            this.$router.push('/foodDetail?id='+foodId);
        },
        onLoad(){
            this.$axios({
                method: 'get',
                url:'/cart/app/'+this.businessId+'/'+this.userId
            }).then(res=>{
                console.log(res);
                this.loading = false;
                if(res.data.code == 200){
                    this.cartItems = res.data.data.cartItems;
                    this.finished = true
                }
            })
        },
        onRefresh(){
            // 清空列表数据
            this.finished = false;

            // 重新加载数据
            // 将 loading 设置为 true，表示处于加载状态
            this.loading = true;
            onLoad();
        },
    },
    created(){
       const bu = history.state.bu;
       this.businessId = bu.businessId;
       this.userId = bu.userId;
    }
} 
</script>

<style></style>