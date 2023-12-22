## Go享生活 

Go享生活 购物系统采用的开发模式是前后端分离的开发模式。



### Mall后端



###### 模块说明：

Mall： Go享生活 项目的父工程，进行项目依赖的统一管理，打包方式为pom

common:  Go享生活 项目公共模块的管理模块，父工程为Mall

common-util:    工具类模块，父工程为common

common-service：公共服务模块，父工程为common

model:  Go享生活 实体类模块

manager： Go享生活 项目后台管理系统的后端服务



###### 一个项目中所涉及到的实体类往往有三种：

1、封装请求参数的实体类：这种实体类在定义的时候往往会携带到dto【数据传输对象：Data Transfer Object】字样，会定义在dto包中

2、与数据库对应的实体类：这种实体类往往和数据表名称保证一致，会定义在domain、entity、pojo包中

3、封装响应结果的实体类：这种实体类在定义的时候往往会携带到vo【视图对象：View Object】字样，会定义在vo包中



模块依赖说明：

common-service会依赖：common-util、common

manager会依赖：common-service



本次项目开发的时候所使用的软件环境版本如下所示：

| 软件名称     | 版本说明 |
| ------------ | -------- |
| jdk          | jdk17    |
| spring boot  | 3.0.5    |
| spring cloud | 2022.0.2 |
| redis        | 7.0.10   |
| mysql        | 8.0.30   |
| idea         | 2023.2.2 |
|              |          |





### mall-admin前端

###### 部署操作步骤

```shell
# Vue3-Element-Admin 要求 Node.js 版本 >= 12 ，推荐Node.js  16.x版本

# 使用git克隆项目 或者 直接下载项目
git clone https://github.com/huzhushan/vue3-element-admin.git

# 进入项目目录
cd vue3-element-admin

# 安装依赖
npm install

# 建议不要直接使用 cnpm 安装依赖，会有各种诡异的 bug。可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npm.taobao.org

# 启动服务
npm start
```

修改页面项目bug：

```js
# 将permission.js中的相关代码
# 原代码：import { TOKEN } from '@/store/modules/app' // TOKEN变量名
# 更改为如下代码：
import { TOKEN } from '@/pinia/modules/app' // TOKEN变量名
```

启动

```shell
npm start
```

部署好的前端工程的核心目录结构如下所示：

```java
mock					// 用于测试，模拟后端接口地址
public					// 存储公共的静态资源：图片
src						// 源代码目录，非常重要
    | api				// 提供用于请求后端接口的js文件
    | assets			// 存储静态资源：图片、css
    | components		// 存储公共组件,可重用的一些组件
    | directive			// 存储自定义的一些指令
    | hooks				// 存储自定义的钩子函数
    | i18n				// 存储用于国际化的js文件
    | layout			// 存储首页布局组件
    | pinia				// 用于进行全局状态管理
    | router			// 存储用于进行路由的js文件
    | utils				// 存储工具类的js文件
    | views				// 和路由绑定的组件
    | App.vue			// 根组件
    | default-settings.js // 默认设置的js文件
    | error-log.js		// 错误日志js文件
    | global-components.js // 全局组件的js文件
    | main.js			// 入口js文件(非常重要)
    | permission.js		// 权限相关的js文件(路由前置守卫、路由后置守卫)
vite.config.js			// vite的配置文件，可以在该配置文件中配置前端工程的端口号
```

