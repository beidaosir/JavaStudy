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
              <a class="dropdown-item" href="page-login.html">
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
        <img class="app-sidebar__user-avatar" width="48px" height="48px" src="static/system/images/m2.jpg"
          alt="User Image" />
        <div>
          <p class="app-sidebar__user-name">Kris Lee</p>
        </div>
      </div>
      <ul class="app-menu">
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
          <router-link to="/business">
            <a class="app-menu__item active" href="javascript:;">
              <i class="app-menu__icon fa fa-dashboard"></i>
              <span class="app-menu__label">商品管理</span>
            </a>
          </router-link>
        </li>
      </ul>
    </aside>
    <!-- 中间内容区域 -->
    <main class="app-content">
      <router-view /> <!--//在main中添加router-view标签，之后通过router-link切换组件时就显示在这个区域 -->
    </main>
  </div>
</template>

<script>

export default {
  name: "HomeView",

};
</script>
