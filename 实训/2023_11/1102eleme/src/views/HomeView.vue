<template>
  <div class="home">
    <!-- 导航条-->
    <header class="app-header">
      <a class="app-header__logo" href="index.html">吃了么后台</a>
      <a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>
      <!-- 导航条右边菜单 -->
      <ul class="app-nav">
        <!-- 用户菜单 -->
        <li class="dropdown">
          <a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu">
            <i class="fa fa-user fa-lg"></i></a>
          <ul class="dropdown-menu settings-menu dropdown-menu-right">
            <li>
              <a class="dropdown-item" href="javascript:;" @click="logout">
                <i class="fa fa-sign-out fa-lg"></i> 退出
              </a>
            </li>
          </ul>
        </li>
      </ul>
    </header>
    <!-- 侧边菜单 -->
    <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
    <aside class="app-sidebar">
      <div class="app-sidebar__user">
        <img class="app-sidebar__user-avatar" width="45px" height="45px" style="width: 45px;height: 45px;" src="../../public/static/system/images/m2.jpg"
          alt="User Image" />
        <div>
          <p class="app-sidebar__user-name">{{ loginUserName }}</p>
        </div>
      </div>
      <!-- <ul class="app-menu">
        <li>
          <router-link to="/welcome">
            <a class="app-menu__item active" href="javascript:;">
              <i class="app-menu__icon fa fa-dashboard"></i>
              <span class="app-menu__label">欢迎页面</span>
            </a>
          </router-link>
        </li>
        <li>
          <router-link to="/business">
            <a class="app-menu__item active" href="javascript:;">
              <i class="app-menu__icon fa fa-dashboard"></i>
              <span class="app-menu__label">商家管理</span>
            </a>
          </router-link>
        </li>
        <li>
          <router-link to="/food">
            <a class="app-menu__item active" href="javascript:;">
              <i class="app-menu__icon fa fa-dashboard"></i>
              <span class="app-menu__label">餐品管理</span>
            </a>
          </router-link>
        </li>
      </ul> -->

      <div>
        <admin-menu v-if="loginUser.role == 'manager'"></admin-menu>
        <business-menu v-else-if="loginUser.role == 'business'"></business-menu>
      </div>
    </aside>
    <!-- 中间内容区域 -->
    <main class="app-content">
      <router-view /> <!--//在main中添加router-view标签，之后通过router-link切换组件时就显示在这个区域 -->
    </main>
  </div>
</template>

<script>
import AdminMenu from '../components/menu/AdminMenu.vue';
import BusinessMenu from '../components/menu/BusinessMenu.vue';
export default {
  name: "HomeView",

  //2.注册
  components: {
    AdminMenu,
    BusinessMenu
  },
  data() {
    return {
      loginUser: {},
    }
  },
  mounted() {
    //从本地存储读取登录用户的信息  赋值给data中的loginUser属性
    this.loginUser = JSON.parse(localStorage.getItem('loginUser'));
  },
  computed: {
    //使用计算属性判断并返回登录用户的账号名称
    loginUserName() {
      return this.loginUser.role == 'manager' ? this.loginUser.account :
        this.loginUser.role == 'business' ? this.loginUser.businessAccount : '';
    }
  },
  methods: {
    //退出登录
    logout() {
      //从本地存储把之前登录的用户移除掉了
      localStorage.removeItem('loginUser');
      //使用编程模式做路由跳转
      this.$router.push('/login');
    }
  }

};
</script>
