SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_logger_infos
-- ----------------------------
DROP TABLE IF EXISTS `t_logger_infos`;
CREATE TABLE `t_logger_infos` (
  `ali_id` int(11) NOT NULL AUTO_INCREMENT,
  `ali_client_ip` varchar(30) DEFAULT NULL COMMENT '客户端请求IP地址',
  `ali_uri` varchar(100) DEFAULT NULL COMMENT '日志请求地址',
  `ali_type` varchar(50) DEFAULT NULL COMMENT '终端请求方式,普通请求,ajax请求',
  `ali_method` varchar(10) DEFAULT NULL COMMENT '请求方式method,post,get等',
  `ali_param_data` longtext COMMENT '请求参数内容,json',
  `ali_session_id` varchar(100) DEFAULT NULL COMMENT '请求接口唯一session标识',
  `ali_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '请求时间',
  `ali_returm_time` varchar(50) DEFAULT NULL COMMENT '接口返回时间',
  `ali_return_data` longtext COMMENT '接口返回数据json',
  `ali_http_status_code` varchar(10) DEFAULT NULL COMMENT '请求时httpStatusCode代码，如：200,400,404等',
  `ali_time_consuming` int(8) DEFAULT '0' COMMENT '请求耗时（毫秒单位）',
  PRIMARY KEY (`ali_id`)
) ENGINE=InnoDB AUTO_INCREMENT=106153 DEFAULT CHARSET=utf8 COMMENT='请求日志信息表';

-- ----------------------------
-- Records of t_logger_infos
-- ----------------------------
INSERT INTO `t_logger_infos` VALUES ('106119', '127.0.0.1', '/user/login', null, 'POST', '{}', null, '2018-08-08 16:36:00', '1533717360326', '{\"msg\":\"用户：null，登录成功。\"}', '200', '125');
INSERT INTO `t_logger_infos` VALUES ('106120', '127.0.0.1', '/user', null, 'POST', '{}', null, '2018-08-08 16:36:23', '1533717383530', 'null', '200', '111');
INSERT INTO `t_logger_infos` VALUES ('106121', '0:0:0:0:0:0:0:1', '/error', null, 'GET', '{}', '3E9A90EED40E35C94BCA30E4F9AA4F6F', '2018-08-08 16:49:35', '1533718175073', 'null', '404', '205');
INSERT INTO `t_logger_infos` VALUES ('106122', '0:0:0:0:0:0:0:1', '/error', null, 'GET', '{}', '3E9A90EED40E35C94BCA30E4F9AA4F6F', '2018-08-08 16:49:39', '1533718179533', 'null', '404', '3');
INSERT INTO `t_logger_infos` VALUES ('106123', '0:0:0:0:0:0:0:1', '/error', null, 'GET', '{}', '3E9A90EED40E35C94BCA30E4F9AA4F6F', '2018-08-08 16:49:42', '1533718182283', 'null', '404', '3');
INSERT INTO `t_logger_infos` VALUES ('106124', '0:0:0:0:0:0:0:1', '/error', null, 'GET', '{}', '3E9A90EED40E35C94BCA30E4F9AA4F6F', '2018-08-08 16:50:28', '1533718228393', 'null', '404', '110');
INSERT INTO `t_logger_infos` VALUES ('106125', '0:0:0:0:0:0:0:1', '/error', null, 'GET', '{}', '3E9A90EED40E35C94BCA30E4F9AA4F6F', '2018-08-08 16:50:32', '1533718232683', 'null', '404', '4');
INSERT INTO `t_logger_infos` VALUES ('106126', '0:0:0:0:0:0:0:1', '/error', null, 'GET', '{}', '3E9A90EED40E35C94BCA30E4F9AA4F6F', '2018-08-08 16:50:52', '1533718252608', 'null', '404', '5');
INSERT INTO `t_logger_infos` VALUES ('106127', '0:0:0:0:0:0:0:1', '/error', null, 'GET', '{}', '3E9A90EED40E35C94BCA30E4F9AA4F6F', '2018-08-08 16:51:44', '1533718304061', 'null', '404', '6');
INSERT INTO `t_logger_infos` VALUES ('106128', '0:0:0:0:0:0:0:1', '/error', null, 'GET', '{}', '3E9A90EED40E35C94BCA30E4F9AA4F6F', '2018-08-08 16:51:48', '1533718308061', 'null', '404', '6');
INSERT INTO `t_logger_infos` VALUES ('106129', '127.0.0.1', '/account', null, 'GET', '{}', null, '2018-08-13 10:40:08', '1534128007964', 'null', '200', '639');
INSERT INTO `t_logger_infos` VALUES ('106130', '127.0.0.1', '/error', null, 'POST', '{}', null, '2018-08-13 10:40:27', '1534128027927', 'null', '404', '45');
INSERT INTO `t_logger_infos` VALUES ('106131', '0:0:0:0:0:0:0:1', '/account', null, 'GET', '{}', null, '2018-08-13 10:41:32', '1534128092713', 'null', '200', '36');
INSERT INTO `t_logger_infos` VALUES ('106132', '0:0:0:0:0:0:0:1', '/account', null, 'GET', '{}', null, '2018-08-13 10:41:41', '1534128101677', 'null', '200', '13');
INSERT INTO `t_logger_infos` VALUES ('106133', '0:0:0:0:0:0:0:1', '/account', null, 'GET', '{}', null, '2018-08-13 10:41:48', '1534128108038', 'null', '200', '25');
INSERT INTO `t_logger_infos` VALUES ('106134', '0:0:0:0:0:0:0:1', '/account', null, 'GET', '{}', null, '2018-08-13 10:41:48', '1534128108684', 'null', '200', '13');
INSERT INTO `t_logger_infos` VALUES ('106135', '0:0:0:0:0:0:0:1', '/account', null, 'GET', '{}', null, '2018-08-13 10:41:48', '1534128108900', 'null', '200', '12');
INSERT INTO `t_logger_infos` VALUES ('106136', '0:0:0:0:0:0:0:1', '/account', null, 'GET', '{}', null, '2018-08-13 10:41:49', '1534128109081', 'null', '200', '14');
INSERT INTO `t_logger_infos` VALUES ('106137', '0:0:0:0:0:0:0:1', '/account', null, 'GET', '{}', null, '2018-08-13 10:41:49', '1534128109265', 'null', '200', '19');
INSERT INTO `t_logger_infos` VALUES ('106138', '0:0:0:0:0:0:0:1', '/account', null, 'GET', '{}', null, '2018-08-13 10:41:49', '1534128109477', 'null', '200', '20');
INSERT INTO `t_logger_infos` VALUES ('106139', '0:0:0:0:0:0:0:1', '/account', null, 'GET', '{}', null, '2018-08-13 10:41:56', '1534128116678', 'null', '200', '15');
INSERT INTO `t_logger_infos` VALUES ('106140', '0:0:0:0:0:0:0:1', '/account', null, 'GET', '{}', null, '2018-08-13 10:42:01', '1534128121130', 'null', '200', '19');
INSERT INTO `t_logger_infos` VALUES ('106141', '127.0.0.1', '/account', null, 'GET', '{}', null, '2018-08-13 10:42:19', '1534128139098', 'null', '200', '14');
INSERT INTO `t_logger_infos` VALUES ('106142', '127.0.0.1', '/account', null, 'GET', '{}', null, '2018-08-13 10:42:33', '1534128153573', 'null', '200', '12');
INSERT INTO `t_logger_infos` VALUES ('106143', '127.0.0.1', '/account', null, 'GET', '{}', null, '2018-08-13 10:43:52', '1534128232435', 'null', '204', '16');
INSERT INTO `t_logger_infos` VALUES ('106144', '127.0.0.1', '/user', null, 'POST', '{}', null, '2018-08-13 11:01:39', '1534129299556', 'null', '200', '169');
INSERT INTO `t_logger_infos` VALUES ('106145', '127.0.0.1', '/account', null, 'POST', '{}', null, '2018-08-13 11:01:53', '1534129313324', 'null', '200', '19');
INSERT INTO `t_logger_infos` VALUES ('106146', '127.0.0.1', '/error', null, 'PUT', '{}', null, '2018-08-13 11:02:17', '1534129337547', 'null', '405', '3');
INSERT INTO `t_logger_infos` VALUES ('106147', '127.0.0.1', '/user', null, 'POST', '{}', null, '2018-08-13 11:03:06', '1534129386480', 'null', '200', '105');
INSERT INTO `t_logger_infos` VALUES ('106148', '127.0.0.1', '/account', null, 'POST', '{}', null, '2018-08-13 11:03:18', '1534129398363', 'null', '200', '9');
INSERT INTO `t_logger_infos` VALUES ('106149', '127.0.0.1', '/account', null, 'GET', '{}', null, '2018-08-13 11:03:41', '1534129421642', 'null', '200', '11');
INSERT INTO `t_logger_infos` VALUES ('106150', '127.0.0.1', '/user', null, 'DELETE', '{}', null, '2018-08-13 11:03:57', '1534129437331', 'null', '200', '50');
INSERT INTO `t_logger_infos` VALUES ('106151', '127.0.0.1', '/account', null, 'POST', '{}', null, '2018-08-13 11:04:03', '1534129443318', 'null', '200', '87');
INSERT INTO `t_logger_infos` VALUES ('106152', '127.0.0.1', '/account', null, 'DELETE', '{}', null, '2018-08-13 11:04:17', '1534129457560', 'null', '200', '26');
