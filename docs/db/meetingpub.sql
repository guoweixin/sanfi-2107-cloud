/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : nj-2101-project

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2021-08-18 13:55:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `meetingpub`
-- ----------------------------
DROP TABLE IF EXISTS `meetingpub`;
CREATE TABLE `meetingpub` (
  `id` varchar(36) NOT NULL COMMENT 'UUID全球理论唯一',
  `pcode` varchar(255) DEFAULT NULL COMMENT '会议编号，规则生成',
  `ptime` varchar(255) DEFAULT NULL COMMENT '会议召开时间',
  `tid` int(11) DEFAULT NULL COMMENT '关联meetingtype[id]',
  `ptitle` varchar(255) DEFAULT NULL COMMENT '会议主题',
  `pzone` varchar(8) DEFAULT NULL COMMENT '需求讲者区域 : 全国  东区 西区 南区 北区',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `uid` int(11) DEFAULT NULL COMMENT '发单人、关联user表id',
  `createDate` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发单时间',
  `status` smallint(1) DEFAULT NULL COMMENT '状态 0无效 1有效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of meetingpub
-- ----------------------------
INSERT INTO `meetingpub` VALUES ('0b790811-608b-4679-8b68-c2395cc7d10a', '20210709004', '2021-07-09T15:14', '2', '我向生活低了头', '全国', '冲冲冲', '31', '2021-07-05 15:14:37', '1');
INSERT INTO `meetingpub` VALUES ('171dc336-342d-41d0-9859-dfff163f3f89', '20210709003', '2021-07-09T11:24', '2', 'mmm', '东区', 'java', '25', '2021-07-05 11:25:03', '1');
INSERT INTO `meetingpub` VALUES ('1778a3c0-da92-4816-83bb-c0f2069097b0', '20210703001', '2021-07-03T11:09', '2', '兄弟们，我们来聊聊天', '东区', '✧ෆ◞◟˃̶̤⌄˂̶̤⋆好运biubiu', '21', '2021-07-02 11:09:17', '1');
INSERT INTO `meetingpub` VALUES ('24e6afad-52a1-481a-bc17-d17112b687fd', '20210705003', '2021-07-05T11:24:24.878', '3', '七月五号关于如何日薪5w', '南区', '好难啊', '1', '2021-07-05 11:24:53', '1');
INSERT INTO `meetingpub` VALUES ('2d7c9225-ab29-46f5-b6a6-2a5bf3d31ff8', '19190118001', '1919-01-18T11:24', '3', '巴黎和会', '全国', '奥利给', '9', '2021-07-05 11:25:12', '1');
INSERT INTO `meetingpub` VALUES ('3442fb83-d6bc-4019-aa5c-c879c8fbb082', '20210705007', '2021-07-05T15:15:33.441', '2', '女菩萨交流会', '全国', '。', '11', '2021-07-05 15:15:45', '1');
INSERT INTO `meetingpub` VALUES ('4fe25325-b91e-48df-8e7f-948380e6c30e', '20210702002', '2021-07-02T11:09', '2', 'Java成长之路', '西区', '十年经验', '31', '2021-07-02 11:10:08', '1');
INSERT INTO `meetingpub` VALUES ('5f6943d2-2d17-4845-9ba2-9d4586670ab7', '20210707001', '2021-07-07T11:24', '1', '月薪百万', '南区', '一百年买汤臣一品', '17', '2021-07-05 11:25:06', '1');
INSERT INTO `meetingpub` VALUES ('684efdc6-d8a7-4a90-801a-89f0d3efafa8', '20210705006', '2021-07-05T15:14', '2', '富婆再爱我一次', '全国', '略略略', '27', '2021-07-05 15:15:26', '1');
INSERT INTO `meetingpub` VALUES ('73e0abd7-638e-4b31-88e2-5be582e20c3e', '20210704001', '2021-07-04T11:09', '2', '关于牛肉干什么时候到的讨论', '东区', '会议取消，没有牛肉干', '3', '2021-07-02 11:10:10', '1');
INSERT INTO `meetingpub` VALUES ('9ccd59a4-ae65-408c-af22-4e2a3d2a61c7', '20210705001', '2021-07-05T11:24', '1', '唱跳rap篮球', '全国', '鸡你太美', '35', '2021-07-05 11:24:30', '1');
INSERT INTO `meetingpub` VALUES ('9cfedba8-e9b1-4806-9361-a3aec0b73121', '20210730001', '2021-07-30T11:09', '1', '呵呵呵呵', '全国', '浓浓的', '9', '2021-07-02 11:09:53', '1');
INSERT INTO `meetingpub` VALUES ('9f1b1637-d370-4661-8b12-37eeedf69d2f', '20210709001', '2021-07-09T12:12', '2', '面试题讲解', '东区', '面试题讲解', '1', '2021-07-02 10:36:58', '1');
INSERT INTO `meetingpub` VALUES ('a450f94d-48f9-4555-8d8e-3285efcb28f4', '20210702001', '2021-07-02T11:09', '2', '1nm光刻机', '东区', '高科技', '17', '2021-07-02 11:09:40', '1');
INSERT INTO `meetingpub` VALUES ('acb32c3e-4287-4dd5-9845-025f69071138', '20210705005', '2021-07-05T15:14', '2', '腾讯集团股东会议', '全国', 'q币免费领取', '9', '2021-07-05 15:14:43', '1');
INSERT INTO `meetingpub` VALUES ('ae05b399-0943-4975-88ff-36320f04eedf', '20210927001', '2021-09-27T15:12', '3', '阿里巴巴董事会议', '全国', '罢免马云', '9', '2021-07-05 15:13:02', '1');
INSERT INTO `meetingpub` VALUES ('c1d6b5df-331b-4304-ad1f-513c2b42c6a9', '20210703002', '2021-07-03T11:09', '3', '渣男怎么养成的', '全国', '教你怎么变成渣男', '27', '2021-07-02 11:09:32', '1');
INSERT INTO `meetingpub` VALUES ('c1dbc7a0-c7d1-422c-8708-231969ac6a48', '20210726001', '2021-07-26T11:09', '1', '第十一届党组织会员', '北区', '记得参加', '9', '2021-07-02 11:09:36', '1');
INSERT INTO `meetingpub` VALUES ('c66e7784-895a-4fae-9044-864d45ab1ef6', '20210705002', '2021-07-05T11:24', '2', '如何正确躺平', '全国', '富婆是唯一出路', '5', '2021-07-05 11:24:52', '1');
INSERT INTO `meetingpub` VALUES ('c8843d19-1c2b-4222-839c-6dac8f1512d2', '20210705004', '2021-07-05T15:13:32.578', '1', '学习', '全国', '好的', '15', '2021-07-05 15:13:43', '1');
INSERT INTO `meetingpub` VALUES ('c9b48168-786a-48ed-aa9b-6cb6637cc576', '20210702003', '2021-07-02T12:00', '3', '给面试题画个重点？', '北区', '面试题咋个背？', '21', '2021-07-02 11:54:10', '1');
INSERT INTO `meetingpub` VALUES ('d6bb5f2d-c2f7-4e00-9556-297d24c6f7f9', '20210710001', '2021-07-10T12:30', '2', '学习SpringCloud', '全国', '要求熟练Cloud组件', '1', '2021-07-02 09:56:49', '1');
INSERT INTO `meetingpub` VALUES ('db1b7eac-a7f6-4a7f-8db8-6689af2471f0', '20210716001', '2021-07-16T18:30', '1', 'Redis的讲解', '南区', '要求有Redis使用三年经验', '1', '2021-07-02 09:57:56', '1');
INSERT INTO `meetingpub` VALUES ('eebd6221-9a15-4eb2-86bc-45ac0d8332ed', '20210710002', '2021-07-10T11:09', '2', '欢迎来到对抗路', '南区', '以雷霆击碎黑暗', '5', '2021-07-02 11:09:48', '1');
INSERT INTO `meetingpub` VALUES ('f560bada-4eca-4973-8945-d245c18dc385', '20210707002', '2021-07-07T15:15', '2', '抢我单鸭', '全国', '抢我单的人最帅', '3', '2021-07-05 15:15:39', '1');
INSERT INTO `meetingpub` VALUES ('feeb0cd6-eb0e-4331-9c57-ff06d56f4620', '20210709002', '2021-07-09T00:00', '2', '哈哈哈哈哈哈哈', '东区', '笑死', '9', '2021-07-03 16:49:24', '1');
