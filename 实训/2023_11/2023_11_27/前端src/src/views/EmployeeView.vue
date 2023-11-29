<template>
    <div>


        <!-- el-row 行  可以分24份
            el-col :span="分几份"
        -->
        <el-row>
            <el-col :span="3"></el-col>
            <el-col :span="4">
                <el-input v-model="ename" class="w-50 m-2" placeholder="姓名搜索" />
            </el-col>
            <el-col :span="1"><el-button type="primary" @click="getPageData">搜索</el-button></el-col>
            <el-col :span="4">
                <el-button type="primary" @click="showAddDialog">添加员工</el-button>
            </el-col>
        </el-row>

        <el-row>
            <el-col :span="3"></el-col>
            <el-col :span="18">
                <el-table :data="tableData" style="width: 100%">
                    <el-table-column prop="empno" label="员工编号" />
                    <el-table-column prop="ename" label="员工姓名" />
                    <el-table-column prop="job" label="工作岗位" />
                    <el-table-column prop="hiredate" label="入职日期" />
                    <el-table-column prop="sal" label="工资收入" />
                    <el-table-column label="操作">
                        <template #default="scope">
                            <el-button size="small" @click="handleEdit(scope.row)">编辑</el-button>
                            <el-button size="small" type="danger" @click="handleDelete(scope.row)">删除</el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </el-col>
            <el-col :span="3"></el-col>
        </el-row>

        <el-row>
            <el-col :span="3"></el-col>
            <el-col :span="18">
                <!--
                v-model:current-page="currentPage" 当前页
                v-model:page-size="pageNumber"  每页显示多少条数据
                :page-sizes="[3, 5, 8, 10]"   可以切换的每页显示的记录数选项
                layout="total, sizes,                   prev,     pager, next,        jumper"  
                布局：总记录 每页记录数的选项下拉列表   上一页箭头  页码   下一页的箭头  可以跳转到某页
                :total="totalRows"  总记录    使用该数字和pageNumber来做计算
                @size-change="getPageData"  监听到pageNumber的变化重新查询
                @current-change="getPageData" 监听到currentPage的变化重新查询
            -->
                <el-pagination v-model:current-page="currentPage" v-model:page-size="pageNumber" :page-sizes="[3, 5, 8, 10]"
                    :small="false" :disabled="false" :background="false" layout="total, sizes, prev, pager, next, jumper"
                    :total="totalRows" @size-change="getPageData" @current-change="getPageData" />
            </el-col>
            <el-col :span="3"></el-col>
        </el-row>

        <!-- 添加和修改的对话框 -->
        <el-dialog v-model="dialogVisible" :title="dialogTitle" width="30%" :before-close="handleClose">
            <div>
                <el-form :model="form" label-width="120px">
                    <el-form-item label="员工姓名">
                        <el-input v-model="form.ename" />
                    </el-form-item>
                    <el-form-item label="员工岗位">
                        <el-input v-model="form.job" />
                    </el-form-item>
                    <el-form-item label="入职日期">
                        <el-date-picker
                            v-model="form.hiredate"
                            type="date"
                        />
                    </el-form-item>
                    <el-form-item label="员工工资">
                        <el-input-number v-model="form.sal" :step="1000" />
                    </el-form-item>
                </el-form>    
            </div>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="dialogVisible = false">取消</el-button>
                    <el-button type="primary" @click="save">
                        {{dialogSubmitBt}}
                    </el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'EmployeeView',
    data() {
        return {
            currentPage: 1, //当前页
            pageNumber: 5, //每页显示的记录数
            ename: '', //姓名搜索条件
            totalRows: 0, //总数量 查询得到
            tableData: [], //表数据 查询得到
            dialogVisible: false,  //对话框是否显示
            dialogTitle: '添加员工信息',
            dialogSubmitBt: '确认添加',
            form: {
                ename: '',
                job: '',
                sal: 0,
                hiredate: ''
            }
        }
    },
    methods: {
        //删除
        handleDelete(row) {
            console.log("row----", row.empno);
            this.$confirm('您确定要删除吗?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {

                //点击确定之后执行这个位置   发送删除请求
                axios({
                    method: 'delete',
                    url: 'http://localhost:8080/emp/'+row.empno
                }).then(res=>{
                   if( res.data == "success"){
                        //删除成功 重新查询
                        this.getPageData();
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                   }else{
                        this.$message({
                            type: 'info',
                            message: '删除失败请重试'
                        });
                   }
                })

                
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            });
        },
        handleEdit(row){
            console.log("row---",row);
            this.form=Object.assign({},row);
            this.dialogTitle='修改员工信息表'
            this.dialogSubmitBt='确认修改'
            this.dialogVisible=true
        },
        //添加或修改
        save(){
            //发送请求
            axios({
                method: 'post',
                url: 'http://localhost:8080/emp/save',
                data: Object.assign({},this.form)
            }).then(res=>{
                if(res.data=="success"){
                    this.getPageData();
                    this.dialogVisible = false;
                }
            })
        },
        //显示添加的对话框
        showAddDialog(){
            this.dialogTitle = '添加员工信息'
            this.dialogSubmitBt = '确认添加'
            this.form =  {
                ename: '',
                job: '',
                sal: 0,
                hiredate: ''
            }
            this.dialogVisible = true
        },
        //分页查询
        getPageData() {
            axios({
                method: 'post',
                url: 'http://localhost:8080/emp/page',
                data: {
                    currentPage: this.currentPage,
                    pageNumber: this.pageNumber,
                    ename: this.ename
                }
            }).then(res => {
                console.log(res);
                this.tableData = res.data.data; //表数据
                this.totalRows = res.data.totalRows; //总记录数
            })
        }
    },
    mounted() {
        this.getPageData();
    }
} 
</script>

<style></style>