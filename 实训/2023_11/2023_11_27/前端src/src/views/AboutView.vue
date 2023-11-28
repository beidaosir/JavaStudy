<template>
  <div>
    <button @click="getById">通过id查询</button>
    <button @click="getByPage">分页查询</button>
    <button @click="add">添加</button>
    <button @click="update">修改</button>
    <button @click="del">删除</button>
  </div>

  <el-row class="mb-4">
    <el-button>Default</el-button>
    <el-button type="primary">Primary</el-button>
    <el-button type="success">Success</el-button>
    <el-button type="info">Info</el-button>
    <el-button type="warning">Warning</el-button>
    <el-button type="danger">Danger</el-button>
  </el-row>

  <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="date" label="Date" width="180" />
    <el-table-column prop="name" label="Name" width="180" />
    <el-table-column prop="address" label="Address" />
  </el-table>
</template>

<script>
import axios from 'axios';
export default {
  name: 'AboutView',
  data() {
    return {
      tableData: [
        {
          date: '2016-05-03',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-02',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-04',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-01',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
      ]
    }
  },
  methods: {
    del() {
      axios({
        method: 'delete',
        url: 'http://localhost:8080/emp/7947'
      }).then((resData) => {
        console.log(resData);
      })
    },
    getById() {
      axios({
        method: 'get',
        url: 'http://localhost:8080/emp/7844'
      }).then((resData) => {
        console.log(resData);
      })
    },
    getByPage() {
      axios({
        method: 'post',
        url: 'http://localhost:8080/emp/page',
        data: {
          currentPage: 2,
          pageNumber: 3,
          ename: "A"
        }
      }).then((resData) => {
        console.log(resData);
      })
    },
    add() {
      axios({
        method: 'post',
        url: 'http://localhost:8080/emp/save',
        data: {
          ename: "张亮",
          job: "前台",
          hiredate: "2023-11-27",
          sal: 5000.0
        }
      }).then((resData) => {
        console.log(resData);
      })
    },
    update() {
      axios({
        method: 'post',
        url: 'http://localhost:8080/emp/save',
        data: {
          ename: "张亮",
          job: "前台",
          hiredate: "2023-11-27",
          sal: 5000.0,
          empno: 7948
        }
      }).then((resData) => {
        console.log(resData);
      })
    }
  },
  //生命周期钩子函数
  mounted() {

  }
} 
</script>

<style></style>

