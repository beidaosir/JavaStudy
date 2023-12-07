<template>
    <!-- header部分 -->
    <van-row class="header">
        <van-col span="2">
            <van-icon name="arrow-left" @click="back" />
        </van-col>
        <van-col span="8">
            <span class="header-title">饿了么</span>
        </van-col>
        <!-- 选城市定位 -->
        <van-col span="10">
            <van-icon name="location-o" />
            <span @click="showPicker = true">{{ fieldValue }}</span>
        </van-col>
        <van-col span="4">
            <router-link to="/"><van-icon name="wap-home-o"/></router-link>
        </van-col>
    </van-row>

    <van-popup v-model:show="showPicker" round position="bottom">
        <van-picker :columns="columns" @cancel="showPicker = false" @confirm="onConfirm" />
    </van-popup>
</template>

<script>
export default {
    name: '',
    data() {
        return {
            fieldValue: '暂无定位',
            showPicker: false,
            columns: [
                { text: '杭州', value: 'Hangzhou' },
                { text: '宁波', value: 'Ningbo' },
                { text: '温州', value: 'Wenzhou' },
                { text: '绍兴', value: 'Shaoxing' },
                { text: '湖州', value: 'Huzhou' },
            ],
        }
    },
    methods: {
        back(){
            this.$router.back();
        },
        onConfirm(e) {
            this.showPicker = false;
            this.fieldValue = e.selectedOptions[0].text;
        },
    },
} 
</script>

<style scoped>
.header {
    height: 35px;
    background-color: lightblue;
    line-height: 35px;
    font-size: 14px;
    color: #555;
}

.header-title {
    font-size: 20px;
    font-weight: bolder;
    color: white;
    font-family: '微软雅黑';
    letter-spacing: 3px;
}
</style>