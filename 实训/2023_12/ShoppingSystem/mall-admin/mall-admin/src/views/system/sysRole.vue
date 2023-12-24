<template>
    <div class="search-div">
        <!-- 搜索表单 -->
        <el-form label-width="70px" size="small">
            <el-form-item label="角色名称">
                <el-input v-model="queryDto.roleName" style="width: 100%" placeholder="角色名称"></el-input>
            </el-form-item>
            <el-row style="display: flex">
                <el-button type="primary" size="small" @click="searchSysRole">
                    搜索
                </el-button>
                <el-button size="small" @click="resetData">重置</el-button>
            </el-row>
        </el-form>

        <!-- 添加按钮 -->
        <div class="tools-div">
            <el-button type="success" size="small">添 加</el-button>
        </div>

        <!--- 角色表格数据 -->
        <el-table :data="list" style="width: 100%">
            <el-table-column prop="roleName" label="角色名称" width="180" />
            <el-table-column prop="roleCode" label="角色code" width="180" />
            <el-table-column prop="createTime" label="创建时间" />
            <el-table-column label="操作" align="center" width="280">
                <el-button type="primary" size="small">修改</el-button>
                <el-button type="danger" size="small">删除</el-button>
            </el-table-column>
        </el-table>

        <!--分页条-->
        <el-pagination v-model:current-page="pageParams.page" v-model:page-size="pageParams.limit"
            :page-sizes="[10, 20, 50, 100]" @size-change="fetchData" @current-change="fetchData"
            layout="total, sizes, prev, pager, next" :total="total" />
    </div>
</template>

<script setup>
import {ref,onMounted} from 'vue'
import { GetSysRoleListByPage } from '@/api/sysRole'
//定义数据模型
let list = ref([]) //角色列表

let total = ref(0) //总记录数

const pageParamsForms = {
    page: 1,//当前页
    limit: 3,//每页记录数
}
const pageParams = ref(pageParamsForms)

const queryDto = ref({"roleName":""})//条件封装数据

//钩子函数
onMounted(()=>{
    fetchData() //调用列表方法
})


//操作方法：列表方法  搜索方法
//列表方法：axios请求调用接口得到列表数据   async异步操作
const fetchData = async()=>{
    //data,code,message 与后端Result中返回保持一致
    const {data,code,message} = await GetSysRoleListByPage(pageParams.value.page,pageParams.value.limit,queryDto.value)
    list.value = data.list
    total.value = data.total
}

//搜索方法
const searchSysRole = ()=>{
    fetchData()
}

// 重置方法
const resetData = () => {
  // 清空搜索条件
  queryDto.value.roleName = ''

  // 重置分页参数
  pageParams.value = { ...pageParamsForms }

  // 触发重新获取数据
  fetchData()
}

</script>

<style scoped>
.search-div {
    margin-bottom: 10px;
    padding: 10px;
    border: 1px solid #ebeef5;
    border-radius: 3px;
    background-color: #fff;
}

.tools-div {
    margin: 10px 0;
    padding: 10px;
    border: 1px solid #ebeef5;
    border-radius: 3px;
    background-color: #fff;
}
</style>