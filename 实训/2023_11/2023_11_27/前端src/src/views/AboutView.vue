<template>
  <div>
    <button @click="getById">通过id查询</button>
    <button @click="getByPage">分页查询</button>
    <button @click="add">添加</button>
    <button @click="update">修改</button>
    <button @click="del">删除</button>

    <h1>文件上传版本一</h1>
    <input type="file" @change="handleChange" ref="fileInput">
    <!--<button @click="toUpFile">上传</button>--><br>
    <img :src="imgUrl" alt="头像" style="width: 300px;">

    <h1>文件上传版本二</h1>
    <el-upload
      class="avatar-uploader"
      action="http://localhost:8080/up1"
      name="upFile"
      :show-file-list="false"
      :on-success="handleAvatarSuccess"
      :before-upload="beforeAvatarUpload"
    >
      <img v-if="imageUrl" :src="imageUrl" class="avatar" />
      <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
    </el-upload>
    
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'AboutView',
  data() {
    return {
      imgUrl: '',
      imageUrl: ''
    }
  },
  methods: {

    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return isJPG && isLt2M;
    },

    handleChange(event){
       console.log(event.target.files[0]) 

       //构建formdata
      let formData = new FormData();
      formData.append('upFile',event.target.files[0]);

      axios({
        method: 'post',
        url: 'http://localhost:8080/up',
        data: formData
      }).then(res=>{
         console.log(res.data);
         this.imgUrl = res.data;
      })
    },
    toUpFile(){
      console.log(this.$refs.fileInput.files[0]);

      //构建formdata
      let formData = new FormData();
      formData.append('upFile',this.$refs.fileInput.files[0]);

      axios({
        method: 'post',
        url: 'http://localhost:8080/up',
        data: formData
      }).then(res=>{
         console.log(res.data);
         this.imgUrl = res.data;
      })

    },

    del() {
      axios({
        method: 'delete',
        url: 'http://localhost:8080/emp/9034'
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
          empno: 9034
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


<style scoped>
.avatar-uploader .avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
</style>