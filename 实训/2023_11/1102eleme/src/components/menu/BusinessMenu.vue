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
            <router-link to="/food">
                <a class="app-menu__item active" href="javascript:;">
                    <i class="app-menu__icon fa fa-dashboard"></i>
                    <span class="app-menu__label">餐品管理</span>
                </a>
            </router-link>

        </li>
        <li>
            <!-- 超链接改成router-link -->
            <router-link to="/business">
                <a class="app-menu__item active" href="javascript:;">
                    <i class="app-menu__icon fa fa-dashboard"></i>
                    <span class="app-menu__label">订单管理</span>
                </a>
            </router-link>

        </li>
        <li>
            <!-- 超链接改成router-link -->
            <router-link to="/business">
                <a class="app-menu__item active" href="javascript:;">
                    <i class="app-menu__icon fa fa-dashboard"></i>
                    <span class="app-menu__label">顾客管理</span>
                </a>
            </router-link>

        </li>
        <li>
            <!-- 超链接改成router-link -->
            <router-link to="/business">
                <a class="app-menu__item active" href="javascript:;">
                    <i class="app-menu__icon fa fa-dashboard"></i>
                    <span class="app-menu__label">商家信息</span>
                </a>
            </router-link>

        </li>
    </ul>
</template>

<script>
export default {
    name: 'BusinessMenu'
} 
</script>

<style></style>