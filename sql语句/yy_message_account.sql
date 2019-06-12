/*
Navicat MySQL Data Transfer

Source Server         : localmysql
Source Server Version : 80003
Source Host           : localhost:3306
Source Database       : yiyuan

Target Server Type    : MYSQL
Target Server Version : 80003
File Encoding         : 65001

Date: 2019-06-12 10:00:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for yy_message_account
-- ----------------------------
DROP TABLE IF EXISTS `yy_message_account`;
CREATE TABLE `yy_message_account` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `tag` varchar(512) DEFAULT NULL COMMENT 'tag',
  `account` varchar(512) DEFAULT NULL COMMENT 'account',
  `password` varchar(255) DEFAULT NULL COMMENT 'password',
  `orgaccount` varchar(512) DEFAULT NULL COMMENT 'orgaccount',
  `sign` varchar(1024) DEFAULT NULL COMMENT 'sign',
  `addserival` varchar(1024) DEFAULT NULL COMMENT 'addserival',
  `attribute1` varchar(1024) DEFAULT NULL COMMENT 'attribute1',
  `attribute2` varchar(3000) DEFAULT NULL COMMENT 'attribute2',
  `attribute3` varchar(1024) DEFAULT NULL COMMENT 'attribute3',
  `attribute4` varchar(1024) DEFAULT NULL COMMENT 'attribute4',
  `attribute5` varchar(512) DEFAULT NULL COMMENT 'attribute5',
  `attribute6` varchar(512) DEFAULT NULL COMMENT 'attribute6',
  `attribute7` varchar(512) DEFAULT NULL COMMENT 'attribute7',
  `attribute8` varchar(512) DEFAULT NULL COMMENT 'attribute8',
  `attribute9` varchar(512) DEFAULT NULL COMMENT 'attribute9',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='yy_message_account';

-- ----------------------------
-- Table structure for yy_message_log
-- ----------------------------
DROP TABLE IF EXISTS `yy_message_log`;
CREATE TABLE `yy_message_log` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `content` varchar(2000) DEFAULT NULL COMMENT 'content',
  `destination` varchar(1024) DEFAULT NULL COMMENT 'destination',
  `status` mediumint(10) DEFAULT NULL COMMENT 'status',
  `tag` varchar(512) DEFAULT NULL COMMENT 'tag',
  `attribute1` varchar(1024) DEFAULT NULL COMMENT 'attribute1',
  `attribute2` varchar(1024) DEFAULT NULL COMMENT 'attribute2',
  `attribute3` varchar(1024) DEFAULT NULL COMMENT 'attribute3',
  `attribute4` varchar(1024) DEFAULT NULL COMMENT 'attribute4',
  `attribute5` varchar(1024) DEFAULT NULL COMMENT 'attribute5',
  `attribute6` varchar(1024) DEFAULT NULL COMMENT 'attribute6',
  `attribute7` varchar(1024) DEFAULT NULL COMMENT 'attribute7',
  `attribute8` varchar(1024) DEFAULT NULL COMMENT 'attribute8',
  `attribute9` varchar(1024) DEFAULT NULL COMMENT 'attribute9',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='yy_message_log';
