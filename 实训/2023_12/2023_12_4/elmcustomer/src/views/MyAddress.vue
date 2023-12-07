<template>
    <van-address-list
        v-model="chosenAddressId"
        :list="list"
        :disabled-list="disabledList"
        disabled-text="以下地址超出配送范围"
        default-tag-text="默认"
        @add="onAdd"
        @edit="onEdit"
    />
</template>

<script>
export default{
    name: 'MyAddress',
    data() {
        return {
            chosenAddressId: '1',
            list:[
                {
                    id: '1',
                    name: '张三',
                    tel: '13000000000',
                    address: '浙江省杭州市西湖区文三路 138 号东方通信大厦 7 楼 501 室',
                    isDefault: true,
                },
                {
                    id: '2',
                    name: '李四',
                    tel: '1310000000',
                    address: '浙江省杭州市拱墅区莫干山路 50 号',
                },
            ]
        }
    },
    methods: {
        onSelect(v){
            console.log(v)
        },
        onAdd(){
            this.$router.push("/addAddress")
        },
        onEdit(){

        },
        showPopup(){
            this.show = true
        }
    }
} 
</script>

<style>
</style>