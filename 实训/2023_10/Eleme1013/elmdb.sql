/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50558
Source Host           : localhost:3306
Source Database       : elmdb

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2023-10-22 20:43:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `adminName` varchar(20) CHARACTER SET utf8mb4 NOT NULL COMMENT '管理员账号',
  `password` varchar(20) CHARACTER SET utf8mb4 NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'zhangsan', '123456');
INSERT INTO `t_admin` VALUES ('2', 'admin', 'admin');

-- ----------------------------
-- Table structure for t_business
-- ----------------------------
DROP TABLE IF EXISTS `t_business`;
CREATE TABLE `t_business` (
  `businessId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 商家账号',
  `password` varchar(20) CHARACTER SET utf8mb4 NOT NULL COMMENT '商家密码',
  `businessName` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '商家名称',
  `businessAddress` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '商家地址',
  `businessExplain` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '商家介绍',
  `starPrice` double DEFAULT NULL COMMENT '起送费',
  `deliveryPrice` double DEFAULT NULL COMMENT '配送费',
  PRIMARY KEY (`businessId`)
) ENGINE=InnoDB AUTO_INCREMENT=10005 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_business
-- ----------------------------
INSERT INTO `t_business` VALUES ('10001', '111111', '蜜雪冰城', '经七路', '蜜雪冰城甜蜜蜜', '15', '3');
INSERT INTO `t_business` VALUES ('10002', '111111', '金拱门', '建设路', '周二半价', '25.3', '2.6');

-- ----------------------------
-- Table structure for t_food
-- ----------------------------
DROP TABLE IF EXISTS `t_food`;
CREATE TABLE `t_food` (
  `foodId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `foodName` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '餐品名称',
  `foodExplain` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '餐品介绍',
  `foodPrice` double DEFAULT NULL COMMENT '餐品价格',
  `businessId` int(11) DEFAULT NULL COMMENT '关联商家编号',
  PRIMARY KEY (`foodId`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_food
-- ----------------------------
INSERT INTO `t_food` VALUES ('111', '柠檬水儿', '酸酸甜甜', '4.5', '10001');
