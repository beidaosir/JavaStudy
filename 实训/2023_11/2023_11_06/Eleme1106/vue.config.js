const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  //打包基本目录
	publicPath:'./',
	//输出目录
	outputDir:'dist',
	//静态资源目录
	assetsDir:'assets',
})
