<template>
    <div>
        <h2>{{ title }}</h2>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"
            @click="showAddDialog">
            添加商家信息
        </button>
        <button type="button" class="btn btn-primary" @click="delMany">批量删除</button>
        <table class="table table-striped" style="background-color: white">
            <thead>
                <tr>
                    <th scope="col"><input type="checkbox" v-model="allcheck" :checked="checkIds.length == currentPageList.length"></th>
                    <th scope="col">序号</th>
                    <th scope="col">商家账号</th>
                    <th scope="col">商家名称</th>
                    <th scope="col">商家地址</th>
                    <th scope="col">商家简介</th>
                    <th scope="col">起送费</th>
                    <th scope="col">配送费</th>
                    <th scope="col">操作</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(business, index) in currentPageList" :key="business.businessId">
                    <th scope="col"><input type="checkbox" :checked="allcheck" v-model="checkIds" :value="business.businessId" /></th>
                    <th scope="row">{{ index + 1 }}</th>
                    <td>{{ business.businessAccount }}</td>
                    <td>{{ business.businessName }}</td>
                    <td>{{ business.businessAddress }}</td>
                    <td>{{ business.businessInfo }}</td>
                    <td>￥{{ business.startPrice }}</td>
                    <td>￥{{ business.sendPrice }}</td>
                    <td>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"
                            @click="showUpdateDialog(business.businessId)">修改</button>
                        <button type="button" class="btn btn-link" @click="del(business.businessId,true)">删除</button>
                    </td>
                </tr>

            </tbody>
        </table>
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-end">
                <li :class="{ 'page-item': true, disabled: (currentPage == 1) }"><!--disabled-->
                    <a class="page-link" href="javascript:;" @click="changeCurrentPage(currentPage - 1)">Previous</a>
                </li>

                <li :class="{ 'page-item': true, disabled: (currentPage == page) }" v-for="(page, index) in totalPages"
                    :key="index">
                    <a class="page-link" href="javascript:;" @click="changeCurrentPage(page)">{{ page }}</a>
                </li>

                <li :class="{ 'page-item': true, disabled: (currentPage == totalPages) }">
                    <a class="page-link" href="javascript:;" @click="changeCurrentPage(currentPage + 1)">Next</a>
                </li>
            </ul>
        </nav>

        <!-- ********************添加和修改的对话框********************** -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">{{ dialogTitle }}</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group row">
                                <label for="account" class="col-sm-3 col-form-label">商家账号</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="account"
                                        v-model.trim="businessForm.businessAccount">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="name" class="col-sm-3 col-form-label">商家名称</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="name"
                                        v-model.trim="businessForm.businessName">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="address" class="col-sm-3 col-form-label">商家地址</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="address"
                                        v-model.trim="businessForm.businessAddress">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="info" class="col-sm-3 col-form-label">商家简介</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="info"
                                        v-model.trim="businessForm.businessInfo">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="startprice" class="col-sm-3 col-form-label">起送价</label>
                                <div class="col-sm-9">
                                    <input type="number" min="0" class="form-control" id="startprice"
                                        v-model.number="businessForm.startPrice">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="sendprice" class="col-sm-3 col-form-label">配送费</label>
                                <div class="col-sm-9">
                                    <input type="number" min="0" class="form-control" id="sendprice"
                                        v-model.number="businessForm.sendPrice">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" data-dismiss="modal" @click="addOrUpdate">{{ saveBt
                        }}</button>
                    </div>
                </div>
            </div>
        </div>

    </div>
</template>

<script>
import { nanoid } from 'nanoid';
export default {
    name: "Business",
    data() {
        return {
            title: "商家信息管理",
            currentPage: 1,//当前页码数
            pageNumber: 5,//每页显示多少条记录
            businessList: [],
            //模态框上的标题
            dialogTitle: '添加商家信息',
            saveBt: '确认添加',
            //模态框上的表单双向数据绑定
            businessForm: {
                businessAccount: '',
                businessName: '',
                businessAddress: '',
                businessInfo: '',
                startPrice: 0,
                sendPrice: 0
            },

            //是否全选
            allcheck: false,

            //选中项的id值
            checkIds: []


        };
    },
    watch: {
        //监视全选和取消全选  全选  将页id全部加入checkIds  取消 清空checkIds
        allcheck(newValue) {
            this.checkIds = []
            //全选
            if (newValue) {
                //将当前页集合中的所有id加入到checkIds中
                this.currentPageList.forEach((businessObj) => {
                    this.checkIds.push(businessObj.businessId);
                })
            }
        }
    },
    methods: {
        //批量删除  就是删除checkIds中收集的id对应的元素
        delMany() {
            if (this.checkIds.length == 0) {
                alert('没有任何选中项，无法删除');
                return;
            }

            //进行删除操作
            if (confirm('您确定要删除这' + this.checkIds.length + '项吗？')) {
                this.checkIds.forEach((delId) => {
                    this.del(delId, false);
                })
            }
        },


        //点击添加或者确认修改按钮会调用该函数
        addOrUpdate() {
            if (this.businessForm.businessId) {
                this.update();
            } else {
                this.add();
            }
            window.localStorage.setItem('businessList', JSON.stringify(this.businessList));
        },

        //显示修改的对话框
        showUpdateDialog(updateId) {
            this.dialogTitle = '修改商家信息';
            this.saveBt = '确认修改';

            //数据回显
            let updateObj = this.businessList.find(businessObj => businessObj.businessId == updateId);

            Object.assign(this.businessForm, updateObj);
            console.log(this.businessForm);//此时businessForm中存在businessId 添加的时候没有id

        },
        //显示添加时的对话框
        showAddDialog() {
            //对添加的对话框进行初始化
            this.dialogTitle = '添加商家信息';
            this.saveBt = '确认添加';

            this.businessForm = {
                businessAccount: '',
                businessName: '',
                businessAddress: '',
                businessInfo: '',
                startPrice: 0,
                sendPrice: 0
            }

        },
        //更新当前页页码
        changeCurrentPage(page) {
            //判断传入的参数是否合理
            if (page < 1 || page > this.totalPages) {
                return;
            }
            this.currentPage = page;
        },
        add() {
            //收集商家信息，构建一个预备添加的对象  不要直接使用this.businessForm    复制一下这个对象就可以
            let businessObj = Object.assign({}, this.businessForm); //复制一个对象的属性

            //生成id
            businessObj.businessId = nanoid();

            this.businessList.unshift(businessObj);//将要添加的对象放入集合

        },
        del(delId,isTip) {
            //isTip是否弹窗提示，如果点击删除按钮就要提示，如果批量删除调用就不需要提示，因为批量删除已经提示过了
            if (isTip) {
                if (confirm('您确定要删除吗？')) {
                    this.businessList = this.businessList.filter(businessObj => businessObj.businessId != delId);
                    window.localStorage.setItem('businessList', JSON.stringify(this.businessList));
                }
            } else {
                this.businessList = this.businessList.filter(businessObj => businessObj.businessId != delId);
                window.localStorage.setItem('businessList', JSON.stringify(this.businessList));

            }


        },
        update() {
            //从集合中找到对应id的对象
            this.businessList.forEach((businessObj) => {
                if (businessObj.businessId == this.businessForm.businessId) {
                    //将form的新数据更新进去
                    Object.assign(businessObj, this.businessForm);
                    return;
                }
            })
        },
    },

    computed: {
        //根据currentPage和pageNumber计算start和end下标 从数组中截取这一段数据 生成一个新的集合在表格上显示
        currentPageList() {
            //第一页 0-4  第二页 5-9
            let start = (this.currentPage - 1) * this.pageNumber;
            let end = start + this.pageNumber;//结束下标不包括
            return this.businessList.slice(start, end);
        },
        //计算总记录数
        totalRows() {
            return this.businessList.length;
        },
        //计算总页数
        totalPages() {
            return Math.ceil(this.totalRows / this.pageNumber);
        }


    },
    mounted() {

        let listStr = window.localStorage.getItem('businessList');
        if (listStr) {
            this.businessList = JSON.parse(listStr);
        }


        //将集合倒序排列    
        this.businessList.reverse();
    }
};
</script>

<style></style>