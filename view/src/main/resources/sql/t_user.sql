SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `t_name` varchar(30) DEFAULT NULL COMMENT '名称',
  `t_age` int(10) DEFAULT NULL COMMENT '年龄',
  `t_address` varchar(100) DEFAULT NULL COMMENT '家庭住址',
  `t_pwd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=264 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'daweige', '24', '成都', null);
