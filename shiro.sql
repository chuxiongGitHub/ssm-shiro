/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2016-08-19 16:36:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(128) NOT NULL COMMENT '资源名称',
  `type` varchar(32) NOT NULL COMMENT '资源类型：menu,button,',
  `url` varchar(128) DEFAULT NULL COMMENT '访问url地址',
  `percode` varchar(128) DEFAULT NULL COMMENT '权限代码字符串',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父结点id',
  `parentids` varchar(128) DEFAULT NULL COMMENT '父结点id列表串',
  `sortstring` varchar(128) DEFAULT NULL COMMENT '排序号',
  `available` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '权限', '', '', null, '0', '0/', '0', '1');
INSERT INTO `sys_permission` VALUES ('11', '商品管理', 'menu', '/item/queryItem.action', null, '1', '0/1/', '1.', '1');
INSERT INTO `sys_permission` VALUES ('12', '商品新增', 'permission', '/item/add.action', 'item:create', '11', '0/1/11/', '', '1');
INSERT INTO `sys_permission` VALUES ('13', '商品修改', 'permission', '/item/editItem.action', 'item:update', '11', '0/1/11/', '', '1');
INSERT INTO `sys_permission` VALUES ('14', '商品删除', 'permission', '', 'item:delete', '11', '0/1/11/', '', '1');
INSERT INTO `sys_permission` VALUES ('15', '商品查询', 'permission', '/item/queryItem.action', 'item:query', '11', '0/1/15/', null, '1');
INSERT INTO `sys_permission` VALUES ('21', '用户管理', 'menu', '/user/query.action', 'user:query', '1', '0/1/', '2.', '1');
INSERT INTO `sys_permission` VALUES ('22', '用户新增', 'permission', '', 'user:create', '21', '0/1/21/', '', '1');
INSERT INTO `sys_permission` VALUES ('23', '用户修改', 'permission', '', 'user:update', '21', '0/1/21/', '', '1');
INSERT INTO `sys_permission` VALUES ('24', '用户删除', 'permission', '', 'user:delete', '21', '0/1/21/', '', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(36) NOT NULL,
  `name` varchar(128) NOT NULL,
  `available` char(1) DEFAULT NULL COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f28', '商品管理员', '1');
INSERT INTO `sys_role` VALUES ('ebc9d647-c6f9-11e4-b137-0adc305c3f28', '用户管理员', '1');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` varchar(36) NOT NULL,
  `sys_role_id` varchar(32) NOT NULL COMMENT '角色id',
  `sys_permission_id` varchar(32) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f21', 'ebc8a441-c6f9-11e4-b137-0adc305c', '12');
INSERT INTO `sys_role_permission` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f22', 'ebc8a441-c6f9-11e4-b137-0adc305c', '11');
INSERT INTO `sys_role_permission` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f24', 'ebc9d647-c6f9-11e4-b137-0adc305c', '21');
INSERT INTO `sys_role_permission` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f25', 'ebc8a441-c6f9-11e4-b137-0adc305c', '15');
INSERT INTO `sys_role_permission` VALUES ('ebc9d647-c6f9-11e4-b137-0adc305c3f23', 'ebc9d647-c6f9-11e4-b137-0adc305c', '22');
INSERT INTO `sys_role_permission` VALUES ('ebc9d647-c6f9-11e4-b137-0adc305c3f26', 'ebc8a441-c6f9-11e4-b137-0adc305c', '13');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `usercode` varchar(32) NOT NULL COMMENT '账号',
  `username` varchar(64) NOT NULL COMMENT '姓名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `salt` varchar(64) DEFAULT NULL COMMENT '盐',
  `locked` char(1) DEFAULT NULL COMMENT '账号是否锁定，1：锁定，0未锁定',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('lisi', 'lisi', '李四', 'bf07fd8bbc73b6f70b8319f2ebb87483', 'uiwueylm', '0');
INSERT INTO `sys_user` VALUES ('rainbow', 'rainbow', 'rainbow', '111', 'dsff', null);
INSERT INTO `sys_user` VALUES ('zhangsan', 'zhangsan', '张三', 'cb571f7bd7a6f73ab004a70322b963d5', 'eteokues', '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(36) NOT NULL,
  `sys_user_id` varchar(32) NOT NULL,
  `sys_role_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('ebc8a441-c6f9-11e4-b137-0adc305c3f28', 'zhangsan', 'ebc8a441-c6f9-11e4-b137-0adc305c');
INSERT INTO `sys_user_role` VALUES ('ebc9d647-c6f9-11e4-b137-0adc305c3f28', 'lisi', 'ebc9d647-c6f9-11e4-b137-0adc305c');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(60) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '彩虹', '123', null);
INSERT INTO `user` VALUES ('2', 'dd', 'dd', 'fsaf');
INSERT INTO `user` VALUES ('3', 'dd', 'dd', 'fsaf');
INSERT INTO `user` VALUES ('4', 'ddd', 'dsfasd', 'dfafd');
INSERT INTO `user` VALUES ('5', 'ddd', 'dsfasd', 'dfafd');
INSERT INTO `user` VALUES ('6', 'sdfasdf,sdsdfdsa', null, 'sdafsdfdsf');
INSERT INTO `user` VALUES ('7', 'sdfasdf,sdsdfdsa', null, 'sdafsdfdsf');
INSERT INTO `user` VALUES ('8', 'sdfasdffff,sdsdfdsa', null, 'sdafsdfdsf');
INSERT INTO `user` VALUES ('9', 'sdfasdffff', 'ffff', 'sdafsdfdsf');
INSERT INTO `user` VALUES ('10', '陈彩虹', 'dfadsfasd', 'sdafsdfdsf');
INSERT INTO `user` VALUES ('11', null, null, null);
INSERT INTO `user` VALUES ('12', null, null, null);
