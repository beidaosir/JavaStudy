<template>
    <van-cell title="选择地址" is-link @click="showPopup" />
    <van-row>
        <van-col span="8">
            <p>配送地址</p>
        </van-col>
        <van-col span="16">
            <p style="font-size: 12px;">
                {{selAddress.name}}<br>
                {{selAddress.tel}}<br>
                {{selAddress.address}}
            </p>
        </van-col>
    </van-row>
    <van-popup v-model:show="show" >
        <van-address-list
            v-model="chosenAddressId"
            :list="list"
            default-tag-text="默认"
            @add="onAdd"
            @edit="onEdit"
            @select="onSelect"
            />
    </van-popup>
</template>

<script>
    export default{
        name: 'Address',
        data() {
            return {
                chosenAddressId: '1',
                show: false,
                list: [
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
                ],
            }
        },
        computed: {
            selAddress(){
                let selAdd = null;
                this.list.forEach(address=>{
                    if(address.id == this.chosenAddressId){
                        selAdd = address
                    }
                })
                return selAdd==null?this.list[0]:selAdd
            }
        },
        methods: {
            onSelect(v){
                console.log(v)
            },
            onAdd(){

            },
            onEdit(){

            },
            showPopup(){
                this.show = true
            }
        },
    } 
</script>

<style>
</style>