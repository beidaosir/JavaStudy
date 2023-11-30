<template>
    <div>
        <h2>{{ title }}</h2>

        <input type="text" class="form-control" style="width: 200px;display: inline-block;" placeholder="请输入餐品编号" v-model.trim="searchForm.foodAccount">
        <input type="text" class="form-control" style="width: 200px;display: inline-block;" placeholder="请输入餐品名称" v-model.trim="searchForm.foodName">
        <button type="button" class="btn btn-primary" @click="search">搜索</button>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"
            @click="showAddDialog">
            添加餐品
        </button>
        <button type="button" class="btn btn-primary" @click="delMany">批量删除</button>
        <table class="table table-striped" style="background-color: white">
            <thead>
                <tr>
                    <th scope="col"><input type="checkbox" v-model="allcheck"
                            :checked="checkIds.length === currentPageList.length"></th>
                    <th scope="col">序号</th>
                    <th scope="col">餐品编号</th>
                    <th scope="col">餐品名称</th>
                    <th scope="col">餐品价格</th>
                    <th scope="col">操作</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(food, index) in currentPageList" :key="food.foodId">
                    <th scope="col"><input type="checkbox" :checked="allcheck" v-model="checkIds" :value="food.foodId" />
                    </th>
                    <th scope="row">{{ index + 1 }}</th>
                    <td>{{ food.foodAccount }}</td>
                    <td>{{ food.foodName }}</td>
                    <td>￥{{ food.foodPrice }}</td>
                    <td>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"
                            @click="showUpdateDialog(food.foodId)">修改</button>
                        <button type="button" class="btn btn-link" @click="del(food.foodId, true)">删除</button>
                    </td>
                </tr>
            </tbody>
        </table>


        <!-- 前进后退页按钮 -->
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
                                <label for="account" class="col-sm-3 col-form-label">商品编号</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="account"
                                        v-model.trim="foodForm.foodAccount">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="name" class="col-sm-3 col-form-label">商品名称</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="name" v-model.trim="foodForm.foodName">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="foodprice" class="col-sm-3 col-form-label">价格</label>
                                <div class="col-sm-9">
                                    <input type="number" min="0" class="form-control" id="foodprice" v-model.number="foodForm.foodPrice">
                                </div>
                            </div>

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" data-dismiss="modal" @click="addOrUpdate">{{ saveBt }}</button>
                    </div>
                </div>
            </div>
        </div>

    </div>
</template>

<script>
import { nanoid } from 'nanoid';

export default {
    name: "Food",
    data() {
        return {
            title: "餐品管理",
            currentPage: 1,
            pageNumber: 5,
            foodList: [],
            dialogTitle: '添加餐品',
            saveBt: '确认添加',
            foodForm: {
                foodName: '',
                foodAccount: '',
                foodPrice: 0
            },
            allcheck: false,
            checkIds: [],

            //搜索框条件收集
            searchForm: {
                foodAccount: '',
                foodName: ''
            },

            showList:[]
        };
    },
    watch: {
        allcheck(newValue) {
            this.checkIds = [];
            if (newValue) {
                this.currentPageList.forEach((foodObj) => {
                    this.checkIds.push(foodObj.foodId);
                });
            }
        }
    },
    methods: {
        search(){
            if(!this.searchForm.foodAccount && !this.searchForm.foodName){
                this.showList = this.foodList;
                return;
            }
            this.showList = this.foodList.filter((foodObj)=>{
               return foodObj.foodAccount.indexOf(this.searchForm.foodAccount)>=0 
                && foodObj.foodName.indexOf(this.searchForm.foodName)>=0
            })
            console.log(this.showList);
        },
        delMany() {
            if (this.checkIds.length === 0) {
                alert('没有选中项，无法删除');
                return;
            }

            if (confirm('确定要删除这' + this.checkIds.length + '项吗？')) {
                this.checkIds.forEach((delId) => {
                    this.del(delId, false);
                });
            }
        },
        //点击添加或者确认修改按钮会调用该函数
        addOrUpdate() {
            if (this.foodForm.foodId) {
                this.update();
            } else {
                this.add();
            }
            window.localStorage.setItem('foodList', JSON.stringify(this.foodList));
        },


        showUpdateDialog(updateId) {
            this.dialogTitle = '修改餐品信息';
            this.saveBt = '确认修改';
            let updateObj = this.foodList.find((foodObj) => foodObj.foodId === updateId);
            Object.assign(this.foodForm, updateObj);
            console.log(this.foodForm);
        },
        showAddDialog() {
            this.dialogTitle = '添加餐品';
            this.saveBt = '确认添加';
            this.foodForm = {
                foodName: '',
                foodAccount: '',
                foodPrice: 0
            };
        },
        changeCurrentPage(page) {
            if (page < 1 || page > this.totalPages) {
                return;
            }
            this.currentPage = page;
        },
        add() {
            let foodObj = Object.assign({}, this.foodForm);
            foodObj.foodId = nanoid();
            this.foodList.unshift(foodObj);
        },
        del(delId, isTip) {
            if (isTip) {
                if (confirm('确定要删除吗？')) {
                    this.foodList = this.foodList.filter((foodObj) => foodObj.foodId !== delId);

                    window.localStorage.setItem('foodList', JSON.stringify(this.foodList));
                }
            } else {
                this.foodList = this.foodList.filter((foodObj) => foodObj.foodId !== delId);

                window.localStorage.setItem('foodList', JSON.stringify(this.foodList));
            }
        },
        update() {
            this.foodList.forEach((foodObj) => {
                if (foodObj.foodId === this.foodForm.foodId) {
                    Object.assign(foodObj, this.foodForm);
                    return;
                }
            });
        }
    },
    computed: {
        currentPageList() {
            let start = (this.currentPage - 1) * this.pageNumber;
            let end = start + this.pageNumber;

            //先排序
            this.showList.sort(function(a,b){
                console.log(a,b);
                return b.datetime - a.datetime;
            })
            return this.showList.slice(start, end);
        },
        totalRows() {
            return this.showList.length;
        },
        totalPages() {
            return Math.ceil(this.totalRows / this.pageNumber);
        }
    },
    mounted() {

        let listStr = window.localStorage.getItem('foodList');
        if (listStr) {
            this.foodList = JSON.parse(listStr);
            this.showList = this.foodList;
        }

        this.foodList.reverse();
    }
};
</script>
