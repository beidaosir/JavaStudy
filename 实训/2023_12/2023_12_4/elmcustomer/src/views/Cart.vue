<template>
    <Address></Address>
    <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
        <van-list
            v-model:loading="loading"
            :finished="finished"
            finished-text="没有更多了"
            @load="onLoad"
        >
            <van-card v-for="food in list" :key="food.foodId"
                :price="food.foodPrice"
                :title="food.foodName"
                :thumb="food.foodPic"
                :num="food.number"
                >
                <template #footer>
                    <span>小计：￥{{food.number*food.foodPrice}}</span>&nbsp;&nbsp;&nbsp;&nbsp;
                    <van-button size="mini" @click="jian(food)">-</van-button>
                    <span>{{food.number}}</span>
                    <van-button size="mini" @click="food.number++">+</van-button>
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
            list:[
                {
                    foodId:1,
                    foodName:'酸汤水饺',
                    foodExplain:'好吃',
                    foodPrice: 13,
                    foodPic: 'http://s4tdoh0lx.bkt.clouddn.com/305a9fbaf7ec4f79bfbce667a50acef8777777.png',
                    number:1
                },
                {
                    foodId:2,
                    foodName:'酸汤水饺',
                    foodExplain:'好吃',
                    foodPrice: 13,
                    foodPic: 'http://s4tdoh0lx.bkt.clouddn.com/305a9fbaf7ec4f79bfbce667a50acef8777777.png',
                    number:1
                }
            ],
            loading: false,
            refreshing: false,
            finished: false
        }
    },
    computed: {
        sumPrice(){
            let sum = 0;
            this.list.forEach(food=>{
                sum += food.foodPrice*food.number
                console.log(food.foodPrice*food.number,sum)
            })
            return sum*100;
        }
    },
    methods: {
        onSubmit(){
            this.$router.push("/order")
        },
        jian(food){
            if(food.number-1<=0){
                showConfirmDialog({
                    title: '提示',
                    message:
                        '您是要删除这一项吗？',
                })
                .then(() => {
                    this.list = this.list.filter(f=>{
                       return f.foodId!=food.foodId
                    })
                })
                .catch(() => {
                    food.number = 1;
                });
            }
        },
        foodDetail(foodId){
            console.log(foodId);
            this.$router.push('/foodDetail?id='+foodId);
        },
        onLoad(){
            // setTimeout(() => {
            //     if (this.refreshing) {
            //         this.list = [];
            //         this.refreshing = false;
            //     }

            //     for (let i = 0; i < 10; i++) {
            //         this.list.push(this.list.length + 1);
            //     }
            //     this.loading = false;

            //     if (this.list.length >= 40) {
            //         this.finished = true;
            //     }
            // }, 1000);
        },
        onRefresh(){
            // 清空列表数据
            // this.finished = false;

            // 重新加载数据
            // 将 loading 设置为 true，表示处于加载状态
            // this.loading = true;
            // onLoad();
        }
    },
} 
</script>

<style></style>