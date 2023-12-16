<template>
    <div ref="main" style="width: 800px;height: 600px"></div>
</template>

<script>
import axios from 'axios'
//先安装echarts 然后引入使用
import * as echarts from 'echarts';
export default {
    name: 'EchartsView',
    data(){
        return {
            myChart: null,
            option1: {
                xAxis: {
                    type: 'category',
                    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        data: [120, 200, 150, 80, 70, 110, 130],
                        type: 'bar'
                    }
                ]
            },
            option: {
                title: {
                    text: '部门人员分布',
                    subtext: 'Fake Data',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left'
                },
                series: [
                    {
                        name: 'Access From',
                        type: 'pie',
                        radius: '50%',
                        data: [
                            { value: 56, name: '财务部' },
                            { value: 345, name: '销售部' },
                            { value: 123, name: '后勤部' },
                            { value: 67, name: '总裁办' },
                            { value: 68, name: '人事部' }
                        ],
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            }
        }
    },
    methods: {
        getCount(){
            axios({
                method: 'get',
                url: 'http://localhost:8899/elm/emp/count'
            }).then(res=>{
                console.log(res);
                this.option.series[0].data = res.data.data
                this.myChart.setOption(this.option);
            })
        },
        initChart(){
            var chartDom = this.$refs.main;
            this.myChart = echarts.init(chartDom);
            this.myChart.setOption(this.option);
        }
    },
    mounted() {
        this.getCount();
        this.initChart();
    }
}
</script>