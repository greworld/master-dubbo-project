/*
Navicat MySQL Data Transfer

Source Server         : 192.168.11.147
Source Server Version : 50719
Source Host           : 192.168.11.147:3306
Source Database       : activity

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-01-02 18:33:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity_award
-- ----------------------------
DROP TABLE IF EXISTS `activity_award`;
CREATE TABLE `activity_award` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `award_name` varchar(50) DEFAULT NULL COMMENT '奖品名称',
  `award_info` varchar(255) DEFAULT NULL COMMENT '奖品信息(如果是卡券类，则以json格式把卡券编号进行存储)',
  `award_type` int(11) DEFAULT NULL COMMENT '奖品类型',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_award
-- ----------------------------
INSERT INTO `activity_award` VALUES ('1', '京东e卡', '京东e卡', '1', '2018-01-02 18:30:13');
INSERT INTO `activity_award` VALUES ('2', '理财金', '5200', '2', '2018-01-02 18:30:14');
INSERT INTO `activity_award` VALUES ('3', '理财金', '2000', '2', '2018-01-02 18:30:15');
INSERT INTO `activity_award` VALUES ('4', '理财金', '1000', '2', '2018-01-02 18:30:16');
INSERT INTO `activity_award` VALUES ('5', '谢谢参与', null, '3', '2018-01-02 18:30:16');
INSERT INTO `activity_award` VALUES ('6', '谢谢参与', null, '3', '2018-01-02 18:30:17');

-- ----------------------------
-- Table structure for activity_award_item
-- ----------------------------
DROP TABLE IF EXISTS `activity_award_item`;
CREATE TABLE `activity_award_item` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `item_name` varchar(50) DEFAULT NULL COMMENT '奖项名称',
  `total_num` int(11) DEFAULT NULL COMMENT '奖品数量',
  `probability` float(11,3) DEFAULT NULL COMMENT '概率',
  `status` int(11) DEFAULT NULL COMMENT '奖项状态（0不可用，1可用）',
  `day_total_num` int(11) DEFAULT NULL COMMENT '每天限制发放数',
  `level` int(11) DEFAULT NULL COMMENT '奖项等级',
  `award_id` int(11) DEFAULT NULL COMMENT '奖项对应的奖品编号（外键）',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_award_item
-- ----------------------------
INSERT INTO `activity_award_item` VALUES ('1', '一等奖', '10', '0.050', '1', '2', '1', '1', '2017-12-10 14:16:21');
INSERT INTO `activity_award_item` VALUES ('2', '二等奖', '20', '0.100', '1', '3', '2', '2', '2017-12-10 14:16:30');
INSERT INTO `activity_award_item` VALUES ('3', '三等奖', '20', '0.250', '1', '10', '3', '3', '2017-12-10 14:17:51');
INSERT INTO `activity_award_item` VALUES ('4', '四等奖', '40', '0.100', '1', '10', '4', '4', '2017-12-10 14:18:06');
INSERT INTO `activity_award_item` VALUES ('5', '五等奖', '1000', '0.250', '1', '10000', '5', '5', '2017-12-10 14:19:07');
INSERT INTO `activity_award_item` VALUES ('6', '六等奖', '1000', '0.250', '1', '10000', '6', '6', '2017-12-10 14:19:07');

-- ----------------------------
-- Table structure for activity_record
-- ----------------------------
DROP TABLE IF EXISTS `activity_record`;
CREATE TABLE `activity_record` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '用户idd',
  `name` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `level` int(11) DEFAULT NULL COMMENT '奖品登记',
  `award_name` varchar(255) DEFAULT NULL COMMENT '奖品名称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_record
-- ----------------------------
INSERT INTO `activity_record` VALUES ('1', '1', 'Mic', '13073804251', '6', '谢谢参与', '2018-01-02 18:19:14');
INSERT INTO `activity_record` VALUES ('2', '1', 'Mic', '13073804251', '5', '谢谢参与', '2018-01-02 18:25:40');
INSERT INTO `activity_record` VALUES ('3', '1', 'Mic', '13073804251', '6', '谢谢参与', '2018-01-02 18:25:48');
INSERT INTO `activity_record` VALUES ('4', '1', 'Mic', '13073804251', '6', '谢谢参与', '2018-01-02 18:26:01');
INSERT INTO `activity_record` VALUES ('5', '1', 'Mic', '13073804251', '5', '谢谢参与', '2018-01-02 18:26:19');
INSERT INTO `activity_record` VALUES ('6', '1', 'Mic', '13073804251', '2', '理财金', '2018-01-02 18:30:23');
