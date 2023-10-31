<!-- 模板 Html -->
<template>
  <div class="about">
    <h1>{{ msg }}</h1>
    <School></School>
  </div>
</template>

<!-- js内容 -->
<script>
import School from './School.vue';
//添加一个export default默认暴露  因为外面要引入使用
//编写一个school组件，在about中引入使用
export default {
  name: 'AboutView',
  data() {
    return {
      msg: '这是我开发的第一个组件'
    }
  },
  components: {
    School:School
  }

}
</script>

<!-- 样式 css -->
<style></style>
