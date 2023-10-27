/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云RDS
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : rm-cn-4xl3e1zjr00016fo.rwlb.rds.aliyuncs.com:3306
 Source Schema         : db_exam

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 27/10/2023 13:35:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `deadline` datetime(0) NULL DEFAULT NULL COMMENT '截止时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES (1, '第一个任务', '第一个任务的描述', '2023-10-27 12:30:56');
INSERT INTO `task` VALUES (2, '第二个任务', '第二个任务的描述', '2023-10-28 12:30:56');

-- ----------------------------
-- Table structure for task_assignment
-- ----------------------------
DROP TABLE IF EXISTS `task_assignment`;
CREATE TABLE `task_assignment`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `task_id` int NULL DEFAULT NULL COMMENT '任务id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `status` tinyint NULL DEFAULT NULL COMMENT '是否完成 0-未完成，1-已完成',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task_assignment
-- ----------------------------
INSERT INTO `task_assignment` VALUES (1, 1, 2, 0);
INSERT INTO `task_assignment` VALUES (2, 2, 2, 1);
INSERT INTO `task_assignment` VALUES (3, 2, 1, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '{bcrypt}$2a$10$ECswbLLcFI.4qYlKE7H9beFszd6mVAlb56GkqcS7YgdZfDE.MG4da', 'admin', '2541226493@qq.com');
INSERT INTO `user` VALUES (2, 'aaaa', '{bcrypt}$2a$10$snl2o.tZUBYKLQckuekj5urMvq9dhX0.6zW6goFGASGyts8WZ.ZcO', 'user', 'String');

SET FOREIGN_KEY_CHECKS = 1;
