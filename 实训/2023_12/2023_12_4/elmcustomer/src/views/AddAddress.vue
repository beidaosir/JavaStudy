<template>
    <van-address-edit
        :area-list="areaList"
        show-set-default
        show-search-result
        :search-result="searchResult"
        :area-columns-placeholder="['请选择', '请选择', '请选择']"
        @save="onSave"
        @change-detail="onChangeDetail"
    />
</template>

<script>
import { areaList } from '@vant/area-data';
    export default{
        name: 'AddAddress',
        data() {
            return {
                searchResult:[],
                areaList: {}
            }
        },
        methods: {
            onChangeDetail(){

            },
            onSave(){
                this.$router.push('/myAddress')
            }
        },  
        mounted(){
            this.areaList = areaList
        }
    } 
</script>

<style>
</style>