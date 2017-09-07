/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-06 20:56:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('23', '11111', '111', '111', '111');
INSERT INTO `student` VALUES ('20', '12333', '3333', '3333', '333');
INSERT INTO `student` VALUES ('22', '222', '22', '22', '22');
INSERT INTO `student` VALUES ('26', '1231', '测试', '111', '123');
INSERT INTO `student` VALUES ('28', '123', '123', '123', '123');
INSERT INTO `student` VALUES ('31', '2014', '李明元', '123', '123');
INSERT INTO `student` VALUES ('32', '123', '123', '123', '123');
INSERT INTO `student` VALUES ('33', '1222', '222', '222', '222');
SET FOREIGN_KEY_CHECKS=1;
