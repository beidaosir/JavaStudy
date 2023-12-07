<template>
  <div class="about">
    <van-row>
        <van-col span="8">
            <p>配送地址</p>
        </van-col>
        <van-col span="16">
            <p style="font-size: 12px;">
                张三<br>
                12345678910<br>
                新乡市河南师范大学平原湖校区
            </p>
        </van-col>
    </van-row>

    <van-list>
        <van-card v-for="food in list" :key="food.foodId"
            :price="food.foodPrice"
            :title="food.foodName"
            :thumb="food.foodPic"
            :num="food.number"
            >
            <template #footer>
                <span>小计：￥{{food.number*food.foodPrice}}</span>&nbsp;&nbsp;&nbsp;&nbsp;
            </template>
        </van-card>
    </van-list>

    <van-submit-bar :price="sumPrice" button-text="确认支付" @submit="onSubmit" />

  </div>
</template>

<script>
  export default{
    name: 'OrderSub',
    data() {
        return {
            list:[
                {
                    foodId:1,
                    foodName:'酸汤水饺',
                    foodExplain:'好吃',
                    foodPrice: 13,
                    foodPic: 'http://s4tdoh0lx.bkt.clouddn.com/305a9fbaf7ec4f79bfbce667a50acef8777777.png',
                    number:2
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
        this.$router.push('/order')
      }
    },
  }
</script>
