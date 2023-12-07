<template>
    <div>
        <van-list>
            <van-row style="margin: 5px;background-color: white;"
                v-for="order in listData" :key="order.orderId">
                <van-col :span="5">
                    <van-image
                            width="50"
                            height="50"
                            :src="order.business.businessPic"
                        />
                </van-col>
                <van-col :span="16">
                    <div>{{order.business.businessName}}</div>
                    <div style="font-size: 12px;color: #555;">订单编号：{{order.orderId}}</div>
                    <div><van-tag type="primary">{{order.status}}</van-tag></div>
                </van-col>
                <van-col :span="3">
                    <van-button size="small" @click="showPop(order)"><van-icon name="more-o" /></van-button>
                </van-col>
            </van-row>
        </van-list>


        <van-popup v-model:show="popIsShow" position="bottom" :style="{ padding: '3px' }">
            <div style="background-color: bisque;">订单详情</div>
            <div>下单时间：{{currentOrder.createTime}}</div>
            <van-list>
                <van-row v-for="detail in currentOrder.detailList" :key="detail.detailId" 
                style="background-color: paleturquoise;">
                    <van-col :span="8">
                        <van-image
                            width="80"
                            height="80"
                            :src="detail.food.foodPic"
                        />
                    </van-col>
                    <van-col :span="8">
                        {{detail.food.foodName}}
                    </van-col>
                    <van-col :span="8">
                        <div>￥{{detail.food.foodPrice}}</div>
                        <div>共{{detail.number}}件</div>
                    </van-col>
                </van-row>
            </van-list>
            <div>合计：{{currentOrder.sumPrice}}</div>
        </van-popup>

    </div>
</template>

<script>
import { showToast } from 'vant';

    export default{
        name: 'Order',
        data() {
            return {
                popIsShow: false,
                currentOrder: null,
                listData:[
                    {
                        orderId: '3217832719',
                        sumPrice: 32.5,
                        status: '买家已支付',
                        createTime: '2022-01-01 10:25:42',
                        business: {
                            businessName: '柳州螺蛳粉',
                            businessPic:'https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg' 
                        },
                        detailList: []
                    },
                    {
                        orderId: '3452156321',
                        sumPrice: 48.5,
                        status: '卖家已确认',
                        createTime: '2022-02-01 10:25:42',
                        business: {
                            businessName: '老李家面馆',
                            businessPic:'https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg' 
                        },
                        detailList: [
                            {
                                detailId: 1001,
                                food: {
                                    foodId: 111,
                                    foodName: '红烧牛肉面',
                                    foodPrice: 12.5,
                                    foodPic: 'https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg'
                                },
                                number: 2
                            },
                            {
                                detailId: 1002,
                                food: {
                                    foodId: 113,
                                    foodName: '爆肚面',
                                    foodPrice: 18,
                                    foodPic: 'https://fastly.jsdelivr.net/npm/@vant/assets/cat.jpeg'
                                },
                                number: 1
                            },
                        ]
                    },
                ],
            }
        },  
        methods: {
            showPop(order){
                this.currentOrder = order;
                if(this.currentOrder.detailList==null || this.currentOrder.detailList.length==0){
                    showToast('不存在详情信息');
                    return;
                }
                this.popIsShow = true
            }
        },
        mounted(){
            this.currentOrder = this.listData[1];
        }
    } 
</script>

<style>
</style>