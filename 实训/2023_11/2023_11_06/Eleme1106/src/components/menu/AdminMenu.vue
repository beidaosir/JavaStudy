<template>
    <ul class="app-menu">
        <li>
            <!-- 超链接改成router-link -->
            <router-link to="/welcome">
                <a class="app-menu__item active" href="javascript:;">
                    <i class="app-menu__icon fa fa-dashboard"></i>
                    <span class="app-menu__label">欢迎页面</span>
                </a>
            </router-link>

        </li>
        <li>
            <!-- 超链接改成router-link -->
            <router-link to="/business">
                <a class="app-menu__item active" href="javascript:;">
                    <i class="app-menu__icon fa fa-dashboard"></i>
                    <span class="app-menu__label">商家管理</span>
                </a>
            </router-link>

        </li>
        <li>
            <!-- 超链接改成router-link -->
            <router-link to="/temp">
                <a class="app-menu__item active" href="javascript:;">
                    <i class="app-menu__icon fa fa-dashboard"></i>
                    <span class="app-menu__label">商品管理</span>
                </a>
            </router-link>

        </li>
        <li>
            <!-- 超链接改成router-link -->
            <router-link to="/temp">
                <a class="app-menu__item active" href="javascript:;">
                    <i class="app-menu__icon fa fa-dashboard"></i>
                    <span class="app-menu__label">用户管理</span>
                </a>
            </router-link>

        </li>
        <li>
            <!-- 超链接改成router-link -->
            <router-link to="/temp">
                <a class="app-menu__item active" href="javascript:;">
                    <i class="app-menu__icon fa fa-dashboard"></i>
                    <span class="app-menu__label">个人信息</span>
                </a>
            </router-link>

        </li>
    </ul>
</template>

<script>
export default {
    name: 'AdminMenu'
} 
</script>

<style></style>