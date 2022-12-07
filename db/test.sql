/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80020 (8.0.20)
 Source Host           : 127.0.0.1:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80020 (8.0.20)
 File Encoding         : 65001

 Date: 07/12/2022 21:27:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `money` double NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, '张三', 5000);
INSERT INTO `account` VALUES (2, '李四', 5000);
INSERT INTO `account` VALUES (3, 'admin', 111111);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `ordertime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `total` double NULL DEFAULT NULL,
  `uid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, NULL, 11, 1);
INSERT INTO `orders` VALUES (2, '2022-12-07 20:55:28', 29, 5);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roleDesc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '院长', '负责全面工作');
INSERT INTO `sys_role` VALUES (2, '研究员', '课程研发工作');
INSERT INTO `sys_role` VALUES (3, '讲师', '授课工作');
INSERT INTO `sys_role` VALUES (4, '助教', '协助解决学生的问题');
INSERT INTO `sys_role` VALUES (5, 'CTO', '正事不干CTO');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'zhangsan', 'zhangsan@itcast.cn', '123', '13888888888');
INSERT INTO `sys_user` VALUES (2, 'lisi', 'lisi@itcast.cn', '123', '13999999999');
INSERT INTO `sys_user` VALUES (3, 'wangwu', 'wangwu@itcast.cn', '123', '18599999999');
INSERT INTO `sys_user` VALUES (4, 'CTO', '', '1234', '');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `userId` bigint NOT NULL,
  `roleId` bigint NOT NULL,
  PRIMARY KEY (`userId`, `roleId`) USING BTREE,
  INDEX `roleId`(`roleId` ASC) USING BTREE,
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `sys_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (1, 2);
INSERT INTO `sys_user_role` VALUES (2, 2);
INSERT INTO `sys_user_role` VALUES (2, 3);
INSERT INTO `sys_user_role` VALUES (4, 5);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `birthday` bigint NULL DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'ceshi', 'abc', 1668689902764);
INSERT INTO `user` VALUES (2, 'ceshi', 'abc', 1668690701400);
INSERT INTO `user` VALUES (3, 'ceshi', 'abc', 1668690709335);
INSERT INTO `user` VALUES (4, 'ceshi', 'abc', 1668690746489);
INSERT INTO `user` VALUES (5, 'ceshi', 'abc', 1668690751463);
INSERT INTO `user` VALUES (6, 'ceshi', 'abc', 1668691874618);
INSERT INTO `user` VALUES (7, 'ceshi', 'abc', 1668692193792);
INSERT INTO `user` VALUES (8, 'ceshi', 'abc', 1668692199852);
INSERT INTO `user` VALUES (9, 'ceshi', 'abc', 1668692208736);
INSERT INTO `user` VALUES (11, 'tom', 'abc', NULL);
INSERT INTO `user` VALUES (12, '张五', '123456', NULL);
INSERT INTO `user` VALUES (13, 'ceshi23', 'abc', 1670417346432);
INSERT INTO `user` VALUES (14, '张五', '123456', NULL);
INSERT INTO `user` VALUES (15, 'ceshi23', 'abc', 1670417525805);
INSERT INTO `user` VALUES (16, '张五', '123456', NULL);
INSERT INTO `user` VALUES (17, 'ceshi23', 'abc', 1670417632892);
INSERT INTO `user` VALUES (18, '张五', '123456', NULL);
INSERT INTO `user` VALUES (19, 'ceshi23', 'abc', 1670417677931);
INSERT INTO `user` VALUES (20, '张五', '123456', NULL);
INSERT INTO `user` VALUES (21, 'ceshi23', 'abc', 1670417726431);

SET FOREIGN_KEY_CHECKS = 1;
