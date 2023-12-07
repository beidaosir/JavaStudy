<template>
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
                >
                <template #tags>
                    <van-tag plain type="primary">点我呀</van-tag>
                    <van-tag plain type="primary">超级好吃</van-tag>
                </template>
                <template #footer>
                    <van-button size="mini">加入餐车</van-button>
                    <van-button size="mini" @click="foodDetail(food.foodId)">查看详情</van-button>
                </template>
            </van-card>
        </van-list>
    </van-pull-refresh>
</template>

<script>
export default {
    name: 'Food',
    data() {
        return {
            list:[
                {
                    foodId:1,
                    foodName:'酸汤水饺',
                    foodExplain:'好吃',
                    foodPrice: 13,
                    foodPic: 'http://s4tdoh0lx.bkt.clouddn.com/305a9fbaf7ec4f79bfbce667a50acef8777777.png'
                },
                {
                    foodId:2,
                    foodName:'酸汤水饺',
                    foodExplain:'好吃',
                    foodPrice: 13,
                    foodPic: 'http://s4tdoh0lx.bkt.clouddn.com/305a9fbaf7ec4f79bfbce667a50acef8777777.png'
                },
                {
                    foodId:3,
                    foodName:'酸汤水饺',
                    foodExplain:'好吃',
                    foodPrice: 13,
                    foodPic: 'http://s4tdoh0lx.bkt.clouddn.com/305a9fbaf7ec4f79bfbce667a50acef8777777.png'
                }
            ],
            loading: false,
            refreshing: false,
            finished: false
        }
    },
    methods: {
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