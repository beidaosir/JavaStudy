<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 餐品表格
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">

                <el-button
                    type="primary"
                    icon="el-icon-delete"
                    class="handle-del mr10"
                    @click="delAllSelection"
                >批量删除</el-button>

                <el-input v-model="query.foodName" placeholder="名称搜" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>

                <el-button type="primary" @click="showAddDialog">添加餐品</el-button>
            </div>

            <el-table
                :data="tableData"
                border
                class="table"
                header-cell-class-name="table-header"
                @selection-change="handleSelectionChange"
            >
                <el-table-column type="selection" width="55" align="center"></el-table-column>
                <el-table-column prop="foodId" label="ID" width="70" align="center"></el-table-column>
                <el-table-column prop="foodName" label="名称"></el-table-column>
                <el-table-column label="简介">
                    <template #default="scope">
                        <el-button link type="primary" size="small" @click="editExplain(scope.row.foodId)">详情介绍</el-button>
                    </template>
                </el-table-column>
                <el-table-column label="价格">
                    <template #default="scope">￥{{ scope.row.foodPrice }}</template>
                </el-table-column>
                <el-table-column label="商家名称">
                    <template #default="scope">{{ scope.row.business.businessName }}</template>
                </el-table-column>
                <el-table-column label="操作" width="180" align="center">
                    <template #default="scope">
                        <el-button
                            type="text"
                            icon="el-icon-edit"
                            @click="handleEdit(scope.$index, scope.row)"
                        >编辑</el-button>
                        <el-button
                            type="text"
                            icon="el-icon-delete"
                            class="red"
                            @click="handleDelete(scope.row)"
                        >删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination
                    background
                    :page-sizes="[3, 5, 8, 10]"
                    layout="total, sizes, prev, pager, next"
                    v-model:current-page="query.pageIndex"
                    v-model:page-size="query.pageSize"
                    :total="pageTotal"
                    @current-change="getData"
                    @size-change="getData"
                ></el-pagination>
            </div>
        </div>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑商家信息" v-model="editVisible" width="40%">
            <el-form ref="form" :model="form" label-width="70px">
                <el-form-item label="餐品名称">
                    <el-input v-model="form.foodName"></el-input>
                </el-form-item>
                <el-form-item label="餐品简介">
                    <el-input v-model="form.foodExplain"></el-input>
                </el-form-item>
                <el-form-item label="价格">
                    <el-input-number v-model="form.foodPrice" :step="5" />
                </el-form-item>
                <el-form-item label="图片">
                    <!-- 使用上传组件 -->
                    <Upload :imageUrl="form.foodPic" @getFoodPic="getFoodPic"></Upload>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="editVisible = false">取 消</el-button>
                    <el-button type="primary" @click="saveEdit">确 定</el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>

<script>
//引入上传组件
import Upload from './Upload.vue';
export default {
    name: "FoodTable",
    //注册上传组件
    components:{Upload},
    data() {
        return {
            query: {
                foodName: '',
                pageIndex: 1,  //当前页
                pageSize: 10,   //每页显示的记录数
                businessId: null
            },
            tableData: [],
            multipleSelection: [],
            delList: [],
            editVisible: false,
            pageTotal: 0,  //总记录数
            form: {
                foodName: '',
                foodExplain: '',
                foodPrice: 0,
                foodPic: ''
            },
        };
    },
    mounted(){
        //从本地存储中获取登录的用户
       const loginUser = JSON.parse(localStorage.getItem('loginUser'));
       //将商家id放入查询条件中
       this.query.businessId = loginUser.bid;
       //查询
       this.getData();
    },
    methods: {
        //编辑详情
        editExplain(foodId){
            console.log(foodId)
            this.$router.push({ path: '/editExplain', query: { foodId:foodId } });
        },
        getFoodPic(picUrl){
            console.log('触发了getFoodPic,接收到',picUrl)
            this.form.foodPic = picUrl;
        },
        //显示添加对话框
        showAddDialog(){
            this.form = {
                foodName: '',
                foodExplain: '',
                foodPrice: 0,
                foodPic: ''
            }
            this.editVisible = true
        },
        // 从服务端获取分页数据
        getData() {
            //准备查询条件
            let data = {
                    currentPage: this.query.pageIndex,
                    pageNumber: this.query.pageSize,
                    foodName: this.query.foodName,
                }
            
            //如果存在businessId带入到查询条件中
            if(this.query.businessId){
                data.businessId = this.query.businessId
            }

            console.log('准备好的查询条件：',data);

            this.$axios({
                method:'post',
                url:'/food/page',
                data: data
            }).then(res=>{
                console.log(res);
                this.tableData = res.data.data.data;
                this.pageTotal = res.data.data.totalRows;
            })

        },
        // 触发搜索按钮
        handleSearch() {
            this.query.pageIndex = 1
            this.getData();
        },
        // 删除操作
        handleDelete(row) {
            // 二次确认删除
            this.$confirm("确定要删除吗？", "提示", {
                type: "warning"
            })
            .then(() => {
                //确定删除之后发送删除请求
                this.$axios({
                    method:'delete',
                    url:'/business/'+row.bid
                }).then(res=>{
                    if(res.data.code==200){
                        this.$message.success("删除成功");
                        this.getData();
                    }else{
                        this.$message.error("删除失败，请重试");
                    }
                })
            })
            .catch(() => {});
        },
        // 多选操作
        handleSelectionChange(val) {
            //将data中存储的选中id数组置为空
            this.multipleSelection = [];
            //遍历选中行数组 拿到id放入选中id的数组
            val.forEach(business => {
                this.multipleSelection.push(business.bid);
            });
            console.log(this.multipleSelection)
        },
        //批量删除的方法
        delAllSelection() {

            //判断有没有选中项
            if(this.multipleSelection.length==0){
                this.$message.error("没有任何选中项，无法删除");
                return;
            }

            this.$confirm("确定要删除这几项吗？", "提示", {
                type: "warning"
            })
            .then(() => {

                this.$axios({
                    method:'post',
                    url:'/business/batch',
                    data: this.multipleSelection
                }).then(res=>{
                    if(res.data.code==200){
                        this.$message.success("删除成功");
                        this.getData();
                    }else{
                        this.$message.error("删除失败，请重试");
                    }
                })
            })
            .catch(() => {});
        },
        // 编辑操作
        handleEdit(index, row) {
            this.form = Object.assign({},row);
            this.editVisible = true;
        },
        // 保存编辑
        saveEdit() {
            //发送添加或修改请求
            this.$axios({
                method:'post',
                url: '/business/save',
                data: this.form
            }).then(res=>{
                if(res.data.code == 200){
                    this.getData();
                    this.editVisible = false;
                    this.$message.success(`操作成功`);
                }else{
                    this.$message.error(`操作失败，请重试`);
                }
            })
           
        }
    }
};
</script>

<style scoped>
.handle-box {
    margin-bottom: 20px;
}

.handle-select {
    width: 120px;
}

.handle-input {
    width: 300px;
    display: inline-block;
}
.table {
    width: 100%;
    font-size: 14px;
}
.red {
    color: #ff0000;
}
.mr10 {
    margin-right: 10px;
}
.table-td-thumb {
    display: block;
    margin: auto;
    width: 40px;
    height: 40px;
}
</style>
