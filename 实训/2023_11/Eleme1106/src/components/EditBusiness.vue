<template>
    <div>
      <h2>Business Information Management</h2>
  
      <!-- 商家信息编辑表单 -->
      <div v-if="isEditing">
        <h3>Edit Business Information</h3>
        <form>
          <div class="form-group">
            <label for="businessName">Business Name</label>
            <input type="text" class="form-control" id="businessName" v-model.trim="businessData.businessName">
          </div>
          <div class="form-group">
            <label for="businessAccount"></label>
            <input type="text" class="form-control" id="businessAccount" v-model.trim="businessData.businessAccount">
          </div>
          <!-- 添加其他商家信息字段 -->
          <!-- 根据需要添加更多的表单字段 -->
  
          <button type="button" class="btn btn-primary" @click="updateBusiness">Save Changes</button>
          <button type="button" class="btn btn-secondary" @click="cancelEditing">Cancel</button>
        </form>
      </div>
  
      <!-- 显示商家信息管理列表 -->
      <div v-else>
        <!-- 添加商家信息列表的内容 -->
  
        <!-- 点击编辑按钮触发商家信息编辑 -->
        <button @click="editBusiness(businessData)">Edit Business</button>
      </div>
  
    </div>
  </template>
  
  <script>
  export default {
    name: "BusinessManagement",
    data() {
      return {
        businessData: {
          businessAccount: "",
          businessName: "",
          // 添加其他商家信息字段
          // 根据需要初始化商家信息数据
        },
        isEditing: false,
      };
    },
    methods: {
      // 点击编辑按钮触发商家信息编辑
      editBusiness(businessData) {
        this.businessData = { ...businessData }; // 将要编辑的商家信息数据填充到 businessData 中
        this.isEditing = true; // 切换到编辑状态
      },
      // 保存商家信息修改
      updateBusiness() {
        // 在这里执行更新商家信息的操作，可以将数据提交到服务器或更新本地数据
        // 可以使用 this.businessData 中的数据
  
        // 保存完毕后切换回非编辑状态
        this.isEditing = false;
      },
      // 取消编辑
      cancelEditing() {
        this.isEditing = false;
        // 重置表单数据
        this.businessData = { ...this.businessData };
      },
    },
  };
  </script>
  