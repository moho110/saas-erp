/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : rycrm-tenant-2

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 22/01/2022 15:39:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for crm_comment
-- ----------------------------
DROP TABLE IF EXISTS `crm_comment`;
CREATE TABLE `crm_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL COMMENT '客户ID',
  `content` varchar(512) DEFAULT NULL COMMENT '回复内容',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='客户跟进记录表';

-- ----------------------------
-- Records of crm_comment
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crm_customer
-- ----------------------------
DROP TABLE IF EXISTS `crm_customer`;
CREATE TABLE `crm_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '客户ID',
  `code` varchar(32) DEFAULT '' COMMENT '客户编号',
  `name` varchar(64) DEFAULT '' COMMENT '客户名称',
  `linkman` varchar(64) DEFAULT '' COMMENT '联系人',
  `phone` varchar(64) DEFAULT '' COMMENT '联系电话',
  `region` varchar(64) DEFAULT '' COMMENT '地区',
  `customer_industry` varchar(64) DEFAULT '' COMMENT '客户行业',
  `customer_rank` varchar(64) DEFAULT '' COMMENT '客户级别',
  `customer_status` varchar(64) DEFAULT '' COMMENT '客户状态',
  `clues_name` varchar(64) DEFAULT '' COMMENT '线索名称',
  `clues_source` varchar(64) DEFAULT '' COMMENT '线索来源',
  `clues_status` varchar(64) DEFAULT '' COMMENT '线索状态',
  `deal_status` char(1) DEFAULT '0' COMMENT '是否成交(0未成交 1成交)',
  `status` char(1) DEFAULT '1' COMMENT '状态(0线索 1客户 2公海)',
  `owner` varchar(64) DEFAULT NULL COMMENT '负责人',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志(0代表存在 2代表删除)',
  `version` int(11) DEFAULT '0' COMMENT '版本',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `last_update_record` varchar(255) DEFAULT '' COMMENT '最后跟进记录',
  `last_followup_time` datetime DEFAULT NULL COMMENT '最后跟进时间',
  `next_followup_time` datetime DEFAULT NULL COMMENT '下次跟进时间',
  `pre_owner` varchar(64) DEFAULT '' COMMENT '前负责人',
  `to_pool_time` datetime DEFAULT NULL COMMENT '转公海时间',
  `to_customer_time` datetime DEFAULT NULL COMMENT '转客户时间',
  `pool_type` varchar(64) DEFAULT '' COMMENT '公海类型',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_name` (`name`) USING BTREE,
  KEY `idx_phone` (`phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='客户表';

-- ----------------------------
-- Records of crm_customer
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for crm_order
-- ----------------------------
DROP TABLE IF EXISTS `crm_order`;
CREATE TABLE `crm_order` (
  `id` bigint(20) NOT NULL,
  `order_no` varchar(32) NOT NULL COMMENT '订单编号',
  `customer_id` bigint(20) NOT NULL COMMENT '客户ID',
  `amount` decimal(19,2) DEFAULT '0.00' COMMENT '订单金额',
  `owner` varchar(64) DEFAULT NULL COMMENT '负责人',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `status` char(1) DEFAULT '1' COMMENT '状态(0待审核 1审核通过 2审核不通过)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_order_no` (`order_no`) USING BTREE,
  KEY `idx_customer_id` (`customer_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

-- ----------------------------
-- Records of crm_order
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='参数配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
BEGIN;
INSERT INTO `sys_config` VALUES (1, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', now(), '', NULL, '初始化密码 123456');
INSERT INTO `sys_config` VALUES (2, '客户管理-公海规则', 'crm.pool.days', '10', 'Y', 'admin', now(), '', NULL, '超过时间未跟进将客户移入公海，单位：天');
COMMIT;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` char(1) DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 COMMENT='部门表';


-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8mb4 COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_data` VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '性别男');
INSERT INTO `sys_dict_data` VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '性别女');
INSERT INTO `sys_dict_data` VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '性别未知');
INSERT INTO `sys_dict_data` VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '显示菜单');
INSERT INTO `sys_dict_data` VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '默认分组');
INSERT INTO `sys_dict_data` VALUES (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '系统分组');
INSERT INTO `sys_dict_data` VALUES (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '系统默认是');
INSERT INTO `sys_dict_data` VALUES (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '系统默认否');
INSERT INTO `sys_dict_data` VALUES (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '通知');
INSERT INTO `sys_dict_data` VALUES (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '公告');
INSERT INTO `sys_dict_data` VALUES (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '关闭状态');
INSERT INTO `sys_dict_data` VALUES (18, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '新增操作');
INSERT INTO `sys_dict_data` VALUES (19, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '修改操作');
INSERT INTO `sys_dict_data` VALUES (20, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '删除操作');
INSERT INTO `sys_dict_data` VALUES (21, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '授权操作');
INSERT INTO `sys_dict_data` VALUES (22, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '导出操作');
INSERT INTO `sys_dict_data` VALUES (23, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '导入操作');
INSERT INTO `sys_dict_data` VALUES (24, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '强退操作');
INSERT INTO `sys_dict_data` VALUES (25, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '生成操作');
INSERT INTO `sys_dict_data` VALUES (26, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '清空操作');
INSERT INTO `sys_dict_data` VALUES (27, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (28, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (100, 0, '北京市', '北京市', 'region_list', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:08:08', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (101, 0, '上海市', '上海市', 'region_list', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:08:15', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (102, 0, '广东省', '广东省', 'region_list', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:08:25', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (103, 0, '百度', '百度', 'clues_source', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:09:02', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (104, 1, '抖音', '抖音', 'clues_source', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:09:08', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (105, 2, '头条', '头条', 'clues_source', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:09:31', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (106, 3, '电话', '电话', 'clues_source', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:09:40', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (107, 0, '有效', '有效', 'clues_status', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:09:59', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (108, 1, '无效', '无效', 'clues_status', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:10:06', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (109, 0, '计算机互联网', '计算机互联网', 'customer_industry', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:10:50', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (110, 1, '加工生产', '加工生产', 'customer_industry', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:11:02', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (111, 2, '房地产', '房地产', 'customer_industry', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:11:20', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (112, 3, '金融', '金融', 'customer_industry', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:11:34', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (113, 0, 'A', 'A', 'customer_rank', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:11:55', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (114, 1, 'B', 'B', 'customer_rank', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:11:59', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (115, 2, 'C', 'C', 'customer_rank', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:12:04', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (116, 3, 'D', 'D', 'customer_rank', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:12:10', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (117, 4, 'E', 'E', 'customer_rank', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:12:18', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (118, 0, '测试客户', '测试客户', 'customer_status', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:12:56', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (119, 1, '意向客户', '意向客户', 'customer_status', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:13:07', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (120, 2, '签单客户', '签单客户', 'customer_status', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:13:17', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (121, 3, '回款客户', '回款客户', 'customer_status', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:13:31', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (122, 4, '上门客户', '上门客户', 'customer_status', NULL, 'default', 'N', '0', 'admin', '2022-01-12 18:13:42', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (123, 0, '普通', 'normal', 'pool_type', NULL, 'default', 'N', '0', 'admin', '2022-01-13 13:33:07', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (124, 1, '高级', 'high', 'pool_type', NULL, 'default', 'N', '0', 'admin', '2022-01-13 13:33:24', '', NULL, NULL);
INSERT INTO `sys_dict_data` VALUES (125, 0, '未成交', '0', 'deal_status', NULL, 'default', 'N', '0', 'admin', '2022-01-15 18:11:42', 'admin', '2022-01-15 18:12:15', NULL);
INSERT INTO `sys_dict_data` VALUES (126, 1, '已成交', '1', 'deal_status', NULL, 'default', 'N', '0', 'admin', '2022-01-15 18:11:58', 'admin', '2022-01-15 18:12:09', NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE KEY `dict_type` (`dict_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8mb4 COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_type` VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '用户性别列表');
INSERT INTO `sys_dict_type` VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '任务状态列表');
INSERT INTO `sys_dict_type` VALUES (5, '任务分组', 'sys_job_group', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '任务分组列表');
INSERT INTO `sys_dict_type` VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '通知类型列表');
INSERT INTO `sys_dict_type` VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '通知状态列表');
INSERT INTO `sys_dict_type` VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '操作类型列表');
INSERT INTO `sys_dict_type` VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2022-01-11 19:11:40', '', NULL, '登录状态列表');
INSERT INTO `sys_dict_type` VALUES (100, '线索来源', 'clues_source', '0', 'admin', '2022-01-12 18:05:44', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (101, '线索状态', 'clues_status', '0', 'admin', '2022-01-12 18:05:59', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (102, '行业类别', 'customer_industry', '0', 'admin', '2022-01-12 18:06:30', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (103, '客户级别', 'customer_rank', '0', 'admin', '2022-01-12 18:06:42', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (104, '客户状态', 'customer_status', '0', 'admin', '2022-01-12 18:06:54', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (105, '所在地区', 'region_list', '0', 'admin', '2022-01-12 18:07:47', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (106, '公海类型', 'pool_type', '0', 'admin', '2022-01-13 13:28:04', '', NULL, NULL);
INSERT INTO `sys_dict_type` VALUES (107, '成交状态', 'deal_status', '0', 'admin', '2022-01-15 18:10:43', '', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor` (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统访问记录';

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `path` varchar(200) DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `query` varchar(255) DEFAULT NULL COMMENT '路由参数',
  `is_frame` int(1) DEFAULT '1' COMMENT '是否为外链（0是 1否）',
  `is_cache` int(1) DEFAULT '0' COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2015 DEFAULT CHARSET=utf8mb4 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 200, 'system', NULL, '', 1, 0, 'M', '0', '0', '', 'system', 'admin', '2022-01-11 19:11:40', '', NULL, '系统管理目录');
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, 1, 'user', 'system/user/index', '', 1, 0, 'C', '0', '0', 'system:user:list', 'user', 'admin', '2022-01-11 19:11:40', '', NULL, '用户管理菜单');
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, 2, 'role', 'system/role/index', '', 1, 0, 'C', '0', '0', 'system:role:list', 'peoples', 'admin', '2022-01-11 19:11:40', '', NULL, '角色管理菜单');
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, 3, 'menu', 'system/menu/index', '', 1, 0, 'C', '0', '0', 'system:menu:list', 'tree-table', 'admin', '2022-01-11 19:11:40', '', NULL, '菜单管理菜单');
INSERT INTO `sys_menu` VALUES (103, '部门管理', 1, 4, 'dept', 'system/dept/index', '', 1, 0, 'C', '0', '0', 'system:dept:list', 'tree', 'admin', '2022-01-11 19:11:40', '', NULL, '部门管理菜单');
INSERT INTO `sys_menu` VALUES (104, '岗位管理', 1, 5, 'post', 'system/post/index', '', 1, 0, 'C', '0', '0', 'system:post:list', 'post', 'admin', '2022-01-11 19:11:40', '', NULL, '岗位管理菜单');
INSERT INTO `sys_menu` VALUES (105, '字典管理', 1, 6, 'dict', 'system/dict/index', '', 1, 0, 'C', '0', '0', 'system:dict:list', 'dict', 'admin', '2022-01-11 19:11:40', '', NULL, '字典管理菜单');
INSERT INTO `sys_menu` VALUES (106, '参数设置', 1, 7, 'config', 'system/config/index', '', 1, 0, 'C', '0', '0', 'system:config:list', 'edit', 'admin', '2022-01-11 19:11:40', '', NULL, '参数设置菜单');
INSERT INTO `sys_menu` VALUES (107, '通知公告', 1, 8, 'notice', 'system/notice/index', '', 1, 0, 'C', '0', '0', 'system:notice:list', 'message', 'admin', '2022-01-11 19:11:40', '', NULL, '通知公告菜单');
INSERT INTO `sys_menu` VALUES (108, '日志管理', 1, 9, 'log', '', '', 1, 0, 'M', '0', '0', '', 'log', 'admin', '2022-01-11 19:11:40', '', NULL, '日志管理菜单');
INSERT INTO `sys_menu` VALUES (109, '在线用户', 1, 10, 'online', 'monitor/online/index', '', 1, 0, 'C', '0', '0', 'monitor:online:list', 'online', 'admin', '2022-01-11 19:11:40', '', NULL, '在线用户菜单');
INSERT INTO `sys_menu` VALUES (500, '操作日志', 108, 1, 'operlog', 'monitor/operlog/index', '', 1, 0, 'C', '0', '0', 'monitor:operlog:list', 'form', 'admin', '2022-01-11 19:11:40', '', NULL, '操作日志菜单');
INSERT INTO `sys_menu` VALUES (501, '登录日志', 108, 2, 'logininfor', 'monitor/logininfor/index', '', 1, 0, 'C', '0', '0', 'monitor:logininfor:list', 'logininfor', 'admin', '2022-01-11 19:11:40', '', NULL, '登录日志菜单');
INSERT INTO `sys_menu` VALUES (1001, '用户查询', 100, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:user:query', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1002, '用户新增', 100, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:user:add', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1003, '用户修改', 100, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:user:edit', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1004, '用户删除', 100, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:user:remove', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1005, '用户导出', 100, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:user:export', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1006, '用户导入', 100, 6, '', '', '', 1, 0, 'F', '0', '0', 'system:user:import', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1007, '重置密码', 100, 7, '', '', '', 1, 0, 'F', '0', '0', 'system:user:resetPwd', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1008, '角色查询', 101, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:role:query', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1009, '角色新增', 101, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:role:add', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1010, '角色修改', 101, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:role:edit', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1011, '角色删除', 101, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:role:remove', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1012, '角色导出', 101, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:role:export', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1013, '菜单查询', 102, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:query', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1014, '菜单新增', 102, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:add', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1015, '菜单修改', 102, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:edit', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1016, '菜单删除', 102, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:remove', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1017, '部门查询', 103, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:query', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1018, '部门新增', 103, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:add', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1019, '部门修改', 103, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:edit', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1020, '部门删除', 103, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:remove', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1021, '岗位查询', 104, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:post:query', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1022, '岗位新增', 104, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:post:add', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1023, '岗位修改', 104, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:post:edit', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1024, '岗位删除', 104, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:post:remove', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1025, '岗位导出', 104, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:post:export', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1026, '字典查询', 105, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:query', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1027, '字典新增', 105, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:add', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1028, '字典修改', 105, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:edit', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1029, '字典删除', 105, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:remove', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1030, '字典导出', 105, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:export', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1031, '参数查询', 106, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:query', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1032, '参数新增', 106, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:add', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1033, '参数修改', 106, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:edit', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1034, '参数删除', 106, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:remove', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1035, '参数导出', 106, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:export', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1036, '公告查询', 107, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:query', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1037, '公告新增', 107, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:add', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1038, '公告修改', 107, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:edit', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1039, '公告删除', 107, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:remove', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1040, '操作查询', 500, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:query', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1041, '操作删除', 500, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:remove', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1042, '日志导出', 500, 4, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:export', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1043, '登录查询', 501, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:query', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1044, '登录删除', 501, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:remove', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1045, '日志导出', 501, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:export', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1046, '在线查询', 109, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:query', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1047, '批量强退', 109, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1048, '单条强退', 109, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin', '2022-01-11 19:11:40', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2006, '公海管理', 0, 100, 'crm/pool', NULL, NULL, 1, 0, 'M', '0', '0', '', 'peoples', 'admin', '2022-01-12 19:23:39', 'admin', '2022-01-12 19:57:42', '');
INSERT INTO `sys_menu` VALUES (2007, '线索管理', 0, 101, 'crm/clues', NULL, NULL, 1, 0, 'M', '0', '0', '', 'time-range', 'admin', '2022-01-12 19:25:51', 'admin', '2022-01-12 19:49:32', '');
INSERT INTO `sys_menu` VALUES (2008, '客户管理', 0, 102, 'crm/customer', NULL, NULL, 1, 0, 'M', '0', '0', '', 'user', 'admin', '2022-01-12 19:26:15', 'admin', '2022-01-12 19:50:13', '');
INSERT INTO `sys_menu` VALUES (2009, '客户公海', 2006, 100, 'list', 'crm/pool/list', NULL, 1, 0, 'C', '0', '0', 'crm:pool:list', '#', 'admin', '2022-01-12 19:33:38', 'admin', '2022-01-12 19:59:51', '');
INSERT INTO `sys_menu` VALUES (2010, '我的线索', 2007, 100, 'person', 'crm/clues/person-list', NULL, 1, 0, 'C', '0', '0', 'crm:clues:person:list', '#', 'admin', '2022-01-12 19:37:30', 'admin', '2022-01-12 19:47:18', '');
INSERT INTO `sys_menu` VALUES (2011, '线索列表', 2007, 101, 'list', 'crm/clues/list', NULL, 1, 0, 'C', '0', '0', 'crm:clues:list', '#', 'admin', '2022-01-12 19:38:49', 'admin', '2022-01-12 19:50:03', '');
INSERT INTO `sys_menu` VALUES (2012, '我的客户', 2008, 100, 'person', 'crm/customer/person-list', NULL, 1, 0, 'C', '0', '0', 'crm:customer:person:list', '#', 'admin', '2022-01-12 19:42:14', 'admin', '2022-01-12 19:47:26', '');
INSERT INTO `sys_menu` VALUES (2013, '客户列表', 2008, 101, 'list', 'crm/customer/list', NULL, 1, 0, 'C', '0', '0', 'crm:customer:list', '#', 'admin', '2022-01-12 19:42:44', 'admin', '2022-01-12 19:50:29', '');
INSERT INTO `sys_menu` VALUES (2014, '成交客户', 2008, 102, 'deal', 'crm/customer/deal-list', NULL, 1, 0, 'C', '0', '0', 'crm:customer:deal:list', '#', 'admin', '2022-01-12 19:43:37', 'admin', '2022-01-12 19:50:32', '');
INSERT INTO `sys_menu` VALUES (2015, '业绩订单', 0, 103, 'crm/order', NULL, NULL, 1, 0, 'M', '0', '0', '', 'money', 'admin', '2022-01-19 10:20:01', 'admin', '2022-01-19 10:20:17', '');
INSERT INTO `sys_menu` VALUES (2016, '我的订单', 2015, 0, 'crm/customer', 'crm/order/person-list', NULL, 1, 0, 'C', '0', '0', 'crm:order:person:list', '#', 'admin', '2022-01-19 10:20:36', 'admin', '2022-01-19 10:21:08', '');
INSERT INTO `sys_menu` VALUES (2017, '订单列表', 2015, 1, 'crm/order', 'crm/order/list', NULL, 1, 0, 'C', '0', '0', 'crm:order:list', '#', 'admin', '2022-01-19 11:07:45', '', NULL, '');
/* erp菜单 */
INSERT INTO `sys_menu` VALUES (2020, '基础数据', 0, 5, 'basic', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'color', 'admin', '2022-08-03 20:48:26', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2021, '销售管理', 0, 6, 'sales', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'color', 'admin', '2022-08-03 20:57:50', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2022, '人力管理', 0, 7, 'person', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'dict', 'admin', '2022-08-03 20:58:54', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2023, 'X系统管理', 0, 8, 'xsystem', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'code', 'admin', '2022-08-03 20:59:22', '', NULL, '');

/* begin of basic */

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2030, '帐户列表', 2020, 1, 'account', 'modules/basic/account/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:account:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2031, '帐户子表', 2020, 2, 'acount_head', 'modules/basic/acount_head/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:acount_head:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2032, '帐户条款', 2020, 3, 'act_item', 'modules/basic/act_item/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:act_item:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2033, '平台配置', 2020, 4, 'p_config', 'modules/basic/p_config/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:p_config:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2034, '消息列表', 2020, 5, 'msg', 'modules/basic/msg/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:msg:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

/* end of basic */


/* begin of sales */

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2035, '输入输出条款', 2021, 1, 'in_out_item', 'modules/sales/in_out_item/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:in_out_item:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2036, '队列列表', 2021, 2, 's_number', 'modules/sales/s_number/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:sequence:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2037, 'SN列表', 2021, 3, 'sequence', 'modules/sales/sequence/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:s_number:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2038, '供应商', 2021, 4, 'supplier', 'modules/sales/supplier/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:supplier:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

/* end of sales */

/* begin of person */

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2039, '多租户列表', 2022, 1, 'tenant', 'modules/person/tenant/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:tenant:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2040, '材料列表', 2022, 2, 'material', 'modules/person/material/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:material:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2041, '材料属性', 2022, 3, 'm_attribute', 'modules/person/m_attribute/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:m_attribute:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2042, '材料分类', 2022, 4, 'm_category', 'modules/person/m_category/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:m_category:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2043, '材料当前库存', 2022, 5, 'm_current_stock', 'modules/person/m_current_stock/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:m_current_stock:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2044, '材料扩展', 2022, 6, 'm_extend', 'modules/person/m_extend/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:m_extend:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2045, '材料初始化库存', 2022, 7, 'init_stock', 'modules/person/init_stock/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:init_stock:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2046, '材料属性', 2022, 8, 'm_property', 'modules/person/m_property/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:m_property:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2047, '组织列表', 2022, 9, 'organization', 'modules/person/organization/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:organization:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2048, '组织用户', 2022, 10, 'orga_user_rel', 'modules/person/orga_user_rel/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:orga_user_rel:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');


/* end of person */

/* begin of xsystem */

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2049, '部门列表', 2023, 1, 'depot', 'modules/xsystem/depot/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:depot:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2050, '部门子表', 2023, 2, 'depot_head', 'modules/xsystem/depot_head/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:depot_head:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2051, '部门条款', 2023, 3, 'depot_item', 'modules/xsystem/depot_item/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:depot_item:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2052, '功能列表', 2023, 4, 'function', 'modules/xsystem/function/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:function:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2053, '日志列表', 2023, 5, 'log', 'modules/xsystem/log/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:log:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2054, '角色列表', 2023, 6, 'role', 'modules/xsystem/role/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:role:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2055, '系统配置', 2023, 7, 'sys_config', 'modules/xsystem/sys_config/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:sys_config:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2056, '单元列表', 2023, 8, 'unit', 'modules/xsystem/unit/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:unit:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2057, '用户列表', 2023, 9, 'user', 'modules/xsystem/user/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:user:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2058, '用户业务', 2023, 10, 'user_business', 'modules/xsystem/user_business/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:user_business:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

INSERT INTO `sys_menu` 
(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`,
 `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES
(2059, '人员列表', 2023, 11, 'person', 'modules/xsystem/person/index',
  NULL, 1, 0, 'C', '0', '0', 'erp:person:list',
  'code', 'admin', '2022-08-07 05:59:44', 'admin', '2022-08-07 06:04:42', '');

/* end of xsystem */


COMMIT;

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) NOT NULL COMMENT '公告标题',
  `notice_type` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='通知公告表';

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log` (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='岗位信息表';

-- ----------------------------
-- Records of sys_post
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) DEFAULT '1' COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) DEFAULT '1' COMMENT '部门树选择项是否关联显示',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'admin', 1, '1', 1, 1, '0', '0', 'admin', now(), '', NULL, '超级管理员');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和部门关联表';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';


-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与岗位关联表';

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_post` VALUES (1, 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (1, 1);
COMMIT;

--
-- 表的结构 `jsh_account`
--

CREATE TABLE `jsh_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `serial_no` varchar(50) DEFAULT NULL COMMENT '编号',
  `initial_amount` decimal(24,6) DEFAULT NULL COMMENT '期初金额',
  `current_amount` decimal(24,6) DEFAULT NULL COMMENT '当前余额',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `is_default` bit(1) DEFAULT NULL COMMENT '是否默认',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户信息';


--
-- 表的结构 `jsh_account_head`
--

CREATE TABLE `jsh_account_head` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(50) DEFAULT NULL COMMENT '类型(支出/收入/收款/付款/转账)',
  `organ_id` bigint(20) DEFAULT NULL COMMENT '单位Id(收款/付款单位)',
  `hands_person_id` bigint(20) DEFAULT NULL COMMENT '经手人id',
  `creator` bigint(20) DEFAULT NULL COMMENT '操作员',
  `change_amount` decimal(24,6) DEFAULT NULL COMMENT '变动金额(优惠/收款/付款/实付)',
  `discount_money` decimal(24,6) DEFAULT NULL COMMENT '优惠金额',
  `total_price` decimal(24,6) DEFAULT NULL COMMENT '合计金额',
  `account_id` bigint(20) DEFAULT NULL COMMENT '账户(收款/付款)',
  `bill_no` varchar(50) DEFAULT NULL COMMENT '单据编号',
  `bill_time` datetime DEFAULT NULL COMMENT '单据日期',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `file_name` varchar(500) DEFAULT NULL COMMENT '附件名称',
  `status` varchar(1) DEFAULT NULL COMMENT '状态，0未审核、1已审核',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='财务主表';


--
-- 表的结构 `jsh_account_item`
--

CREATE TABLE `jsh_account_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `header_id` bigint(20) NOT NULL COMMENT '表头Id',
  `account_id` bigint(20) DEFAULT NULL COMMENT '账户Id',
  `in_out_item_id` bigint(20) DEFAULT NULL COMMENT '收支项目Id',
  `bill_id` bigint(20) DEFAULT NULL COMMENT '单据id',
  `need_debt` decimal(24,6) DEFAULT NULL COMMENT '应收欠款',
  `finish_debt` decimal(24,6) DEFAULT NULL COMMENT '已收欠款',
  `each_amount` decimal(24,6) DEFAULT NULL COMMENT '单项金额',
  `remark` varchar(100) DEFAULT NULL COMMENT '单据备注',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='财务子表';


--
-- 表的结构 `jsh_depot`
--

CREATE TABLE `jsh_depot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '仓库名称',
  `address` varchar(50) DEFAULT NULL COMMENT '仓库地址',
  `warehousing` decimal(24,6) DEFAULT NULL COMMENT '仓储费',
  `truckage` decimal(24,6) DEFAULT NULL COMMENT '搬运费',
  `type` int(10) DEFAULT NULL COMMENT '类型',
  `sort` varchar(10) DEFAULT NULL COMMENT '排序',
  `remark` varchar(100) DEFAULT NULL COMMENT '描述',
  `principal` bigint(20) DEFAULT NULL COMMENT '负责人',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_Flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
  `is_default` bit(1) DEFAULT NULL COMMENT '是否默认',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='仓库表';


--
-- 表的结构 `jsh_depot_head`
--

CREATE TABLE `jsh_depot_head` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(50) DEFAULT NULL COMMENT '类型(出库/入库)',
  `sub_type` varchar(50) DEFAULT NULL COMMENT '出入库分类',
  `default_number` varchar(50) DEFAULT NULL COMMENT '初始票据号',
  `number` varchar(50) DEFAULT NULL COMMENT '票据号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `oper_time` datetime DEFAULT NULL COMMENT '出入库时间',
  `organ_id` bigint(20) DEFAULT NULL COMMENT '供应商id',
  `creator` bigint(20) DEFAULT NULL COMMENT '操作员',
  `account_id` bigint(20) DEFAULT NULL COMMENT '账户id',
  `change_amount` decimal(24,6) DEFAULT NULL COMMENT '变动金额(收款/付款)',
  `back_amount` decimal(24,6) DEFAULT NULL COMMENT '找零金额',
  `total_price` decimal(24,6) DEFAULT NULL COMMENT '合计金额',
  `pay_type` varchar(50) DEFAULT NULL COMMENT '付款类型(现金、记账等)',
  `bill_type` varchar(50) DEFAULT NULL COMMENT '单据类型',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `file_name` varchar(500) DEFAULT NULL COMMENT '附件名称',
  `sales_man` varchar(50) DEFAULT NULL COMMENT '业务员（可以多个）',
  `account_id_list` varchar(50) DEFAULT NULL COMMENT '多账户ID列表',
  `account_money_list` varchar(200) DEFAULT NULL COMMENT '多账户金额列表',
  `discount` decimal(24,6) DEFAULT NULL COMMENT '优惠率',
  `discount_money` decimal(24,6) DEFAULT NULL COMMENT '优惠金额',
  `discount_last_money` decimal(24,6) DEFAULT NULL COMMENT '优惠后金额',
  `other_money` decimal(24,6) DEFAULT NULL COMMENT '销售或采购费用合计',
  `deposit` decimal(24,6) DEFAULT NULL COMMENT '订金',
  `status` varchar(1) DEFAULT NULL COMMENT '状态，0未审核、1已审核、2完成采购|销售、3部分采购|销售',
  `purchase_status` varchar(1) DEFAULT NULL COMMENT '采购状态，0未采购、2完成采购、3部分采购',
  `link_number` varchar(50) DEFAULT NULL COMMENT '关联订单号',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单据主表';


--
-- 表的结构 `jsh_depot_item`
--

CREATE TABLE `jsh_depot_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `header_id` bigint(20) NOT NULL COMMENT '表头Id',
  `material_id` bigint(20) NOT NULL COMMENT '商品Id',
  `material_extend_id` bigint(20) DEFAULT NULL COMMENT '商品扩展id',
  `material_unit` varchar(20) DEFAULT NULL COMMENT '商品计量单位',
  `sku` varchar(50) DEFAULT NULL COMMENT '多属性',
  `oper_number` decimal(24,6) DEFAULT NULL COMMENT '数量',
  `basic_number` decimal(24,6) DEFAULT NULL COMMENT '基础数量，如kg、瓶',
  `unit_price` decimal(24,6) DEFAULT NULL COMMENT '单价',
  `tax_unit_price` decimal(24,6) DEFAULT NULL COMMENT '含税单价',
  `all_price` decimal(24,6) DEFAULT NULL COMMENT '金额',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `depot_id` bigint(20) DEFAULT NULL COMMENT '仓库ID',
  `another_depot_id` bigint(20) DEFAULT NULL COMMENT '调拨时，对方仓库Id',
  `tax_rate` decimal(24,6) DEFAULT NULL COMMENT '税率',
  `tax_money` decimal(24,6) DEFAULT NULL COMMENT '税额',
  `tax_last_money` decimal(24,6) DEFAULT NULL COMMENT '价税合计',
  `material_type` varchar(20) DEFAULT NULL COMMENT '商品类型',
  `sn_list` varchar(2000) DEFAULT NULL COMMENT '序列号列表',
  `batch_number` varchar(100) DEFAULT NULL COMMENT '批号',
  `expiration_date` datetime DEFAULT NULL COMMENT '有效日期',
  `link_id` bigint(20) DEFAULT NULL COMMENT '关联明细id',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单据子表';


--
-- 表的结构 `jsh_function`
--

CREATE TABLE `jsh_function` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `number` varchar(50) DEFAULT NULL COMMENT '编号',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `parent_number` varchar(50) DEFAULT NULL COMMENT '上级编号',
  `url` varchar(100) DEFAULT NULL COMMENT '链接',
  `component` varchar(100) DEFAULT NULL COMMENT '组件',
  `state` bit(1) DEFAULT NULL COMMENT '收缩',
  `sort` varchar(50) DEFAULT NULL COMMENT '排序',
  `enabled` bit(1) DEFAULT NULL COMMENT '启用',
  `type` varchar(50) DEFAULT NULL COMMENT '类型',
  `push_btn` varchar(50) DEFAULT NULL COMMENT '功能按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能模块表';



--
-- 表的结构 `jsh_in_out_item`
--

CREATE TABLE `jsh_in_out_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收支项目';


--
-- 表的结构 `jsh_log`
--

CREATE TABLE `jsh_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `operation` varchar(500) DEFAULT NULL COMMENT '操作模块名称',
  `client_ip` varchar(200) DEFAULT NULL COMMENT '客户端IP',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '操作状态 0==成功，1==失败',
  `content` varchar(1000) DEFAULT NULL COMMENT '详情',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志';


--
-- 表的结构 `jsh_material`
--

CREATE TABLE `jsh_material` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_id` bigint(20) DEFAULT NULL COMMENT '产品类型id',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `mfrs` varchar(50) DEFAULT NULL COMMENT '制造商',
  `model` varchar(50) DEFAULT NULL COMMENT '型号',
  `standard` varchar(50) DEFAULT NULL COMMENT '规格',
  `color` varchar(50) DEFAULT NULL COMMENT '颜色',
  `unit` varchar(50) DEFAULT NULL COMMENT '单位-单个',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `img_name` varchar(500) DEFAULT NULL COMMENT '图片名称',
  `unit_id` bigint(20) DEFAULT NULL COMMENT '计量单位Id',
  `expiry_num` int(10) DEFAULT NULL COMMENT '保质期天数',
  `weight` decimal(24,6) DEFAULT NULL COMMENT '基础重量(kg)',
  `enabled` bit(1) DEFAULT NULL COMMENT '启用 0-禁用  1-启用',
  `other_field1` varchar(50) DEFAULT NULL COMMENT '自定义1',
  `other_field2` varchar(50) DEFAULT NULL COMMENT '自定义2',
  `other_field3` varchar(50) DEFAULT NULL COMMENT '自定义3',
  `enable_serial_number` varchar(1) DEFAULT '0' COMMENT '是否开启序列号，0否，1是',
  `enable_batch_number` varchar(1) DEFAULT '0' COMMENT '是否开启批号，0否，1是',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品表';


--
-- 表的结构 `jsh_material_attribute`
--

CREATE TABLE `jsh_material_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `attribute_field` varchar(50) DEFAULT NULL COMMENT '属性字段',
  `attribute_name` varchar(50) DEFAULT NULL COMMENT '属性名',
  `attribute_value` varchar(500) DEFAULT NULL COMMENT '属性值',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品属性表';



--
-- 表的结构 `jsh_material_category`
--

CREATE TABLE `jsh_material_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `category_level` smallint(6) DEFAULT NULL COMMENT '等级',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级id',
  `sort` varchar(10) DEFAULT NULL COMMENT '显示顺序',
  `serial_no` varchar(100) DEFAULT NULL COMMENT '编号',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品类型表';


--
-- 表的结构 `jsh_material_current_stock`
--

CREATE TABLE `jsh_material_current_stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `material_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `depot_id` bigint(20) DEFAULT NULL COMMENT '仓库id',
  `current_number` decimal(24,6) DEFAULT NULL COMMENT '当前库存数量',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品当前库存' ROW_FORMAT=COMPACT;


--
-- 表的结构 `jsh_material_extend`
--

CREATE TABLE `jsh_material_extend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `material_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `bar_code` varchar(50) DEFAULT NULL COMMENT '商品条码',
  `commodity_unit` varchar(50) DEFAULT NULL COMMENT '商品单位',
  `sku` varchar(50) DEFAULT NULL COMMENT '多属性',
  `purchase_decimal` decimal(24,6) DEFAULT NULL COMMENT '采购价格',
  `commodity_decimal` decimal(24,6) DEFAULT NULL COMMENT '零售价格',
  `wholesale_decimal` decimal(24,6) DEFAULT NULL COMMENT '销售价格',
  `low_decimal` decimal(24,6) DEFAULT NULL COMMENT '最低售价',
  `default_flag` varchar(1) DEFAULT '1' COMMENT '是否为默认单位，1是，0否',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `create_serial` varchar(50) DEFAULT NULL COMMENT '创建人编码',
  `update_serial` varchar(50) DEFAULT NULL COMMENT '更新人编码',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间戳',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_Flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品价格扩展' ROW_FORMAT=COMPACT;


--
-- 表的结构 `jsh_material_initial_stock`
--

CREATE TABLE `jsh_material_initial_stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `material_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `depot_id` bigint(20) DEFAULT NULL COMMENT '仓库id',
  `number` decimal(24,6) DEFAULT NULL COMMENT '初始库存数量',
  `low_safe_stock` decimal(24,6) DEFAULT NULL COMMENT '最低库存数量',
  `high_safe_stock` decimal(24,6) DEFAULT NULL COMMENT '最高库存数量',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品初始库存' ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- 表的结构 `jsh_material_property`
--

CREATE TABLE `jsh_material_property` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `native_name` varchar(50) DEFAULT NULL COMMENT '原始名称',
  `enabled` bit(1) DEFAULT NULL COMMENT '是否启用',
  `sort` varchar(10) DEFAULT NULL COMMENT '排序',
  `another_name` varchar(50) DEFAULT NULL COMMENT '别名',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品扩展字段表';



--
-- 表的结构 `jsh_msg`
--

CREATE TABLE `jsh_msg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `msg_title` varchar(100) DEFAULT NULL COMMENT '消息标题',
  `msg_content` varchar(500) DEFAULT NULL COMMENT '消息内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `type` varchar(20) DEFAULT NULL COMMENT '消息类型',
  `status` varchar(1) DEFAULT NULL COMMENT '状态，1未读 2已读',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_Flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息表' ROW_FORMAT=COMPACT;



--
-- 表的结构 `jsh_organization`
--

CREATE TABLE `jsh_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `org_no` varchar(20) DEFAULT NULL COMMENT '机构编号',
  `org_abr` varchar(20) DEFAULT NULL COMMENT '机构简称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父机构id',
  `sort` varchar(20) DEFAULT NULL COMMENT '机构显示顺序',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构表';


--
-- 表的结构 `jsh_orga_user_rel`
--

CREATE TABLE `jsh_orga_user_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `orga_id` bigint(20) NOT NULL COMMENT '机构id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_blng_orga_dspl_seq` varchar(20) DEFAULT NULL COMMENT '用户在所属机构中显示顺序',
  `delete_flag` char(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新人',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构用户关系表';


--
-- 表的结构 `jsh_person`
--

CREATE TABLE `jsh_person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='经手人表';


--
-- 表的结构 `jsh_platform_config`
--

CREATE TABLE `jsh_platform_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `platform_key` varchar(100) DEFAULT NULL COMMENT '关键词',
  `platform_key_info` varchar(100) DEFAULT NULL COMMENT '关键词名称',
  `platform_value` varchar(200) DEFAULT NULL COMMENT '值',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台参数';



--
-- 表的结构 `jsh_role`
--

CREATE TABLE `jsh_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `type` varchar(50) DEFAULT NULL COMMENT '类型',
  `value` varchar(200) DEFAULT NULL COMMENT '值',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';


--
-- 表的结构 `jsh_sequence`
--

CREATE TABLE `jsh_sequence` (
  `seq_name` varchar(50) NOT NULL AUTO_INCREMENT COMMENT '序列名称',
  `min_value` bigint(20) NOT NULL COMMENT '最小值',
  `max_value` bigint(20) NOT NULL COMMENT '最大值',
  `current_val` bigint(20) NOT NULL COMMENT '当前值',
  `increment_val` int(11) NOT NULL DEFAULT '1' COMMENT '增长步数',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单据编号表';


--
-- 表的结构 `jsh_serial_number`
--

CREATE TABLE `jsh_serial_number` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `material_id` bigint(20) DEFAULT NULL COMMENT '产品表id',
  `depot_id` bigint(20) DEFAULT NULL COMMENT '仓库id',
  `serial_number` varchar(64) DEFAULT NULL COMMENT '序列号',
  `is_sell` varchar(1) DEFAULT '0' COMMENT '是否卖出，0未卖出，1卖出',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `updater` bigint(20) DEFAULT NULL COMMENT '更新人',
  `in_bill_no` varchar(50) DEFAULT NULL COMMENT '入库单号',
  `out_bill_no` varchar(50) DEFAULT NULL COMMENT '出库单号',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='序列号表';



-
-- 表的结构 `jsh_supplier`
--

CREATE TABLE `jsh_supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `supplier` varchar(255) NOT NULL COMMENT '供应商名称',
  `contacts` varchar(100) DEFAULT NULL COMMENT '联系人',
  `phone_num` varchar(30) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `description` varchar(500) DEFAULT NULL COMMENT '备注',
  `isystem` tinyint(4) DEFAULT NULL COMMENT '是否系统自带 0==系统 1==非系统',
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  `enabled` bit(1) DEFAULT NULL COMMENT '启用',
  `advance_in` decimal(24,6) DEFAULT '0.000000' COMMENT '预收款',
  `begin_need_get` decimal(24,6) DEFAULT NULL COMMENT '期初应收',
  `begin_need_pay` decimal(24,6) DEFAULT NULL COMMENT '期初应付',
  `all_need_get` decimal(24,6) DEFAULT NULL COMMENT '累计应收',
  `all_need_pay` decimal(24,6) DEFAULT NULL COMMENT '累计应付',
  `fax` varchar(30) DEFAULT NULL COMMENT '传真',
  `telephone` varchar(30) DEFAULT NULL COMMENT '手机',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `tax_num` varchar(50) DEFAULT NULL COMMENT '纳税人识别号',
  `bank_name` varchar(50) DEFAULT NULL COMMENT '开户行',
  `account_number` varchar(50) DEFAULT NULL COMMENT '账号',
  `tax_rate` decimal(24,6) DEFAULT NULL COMMENT '税率',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商/客户信息表';


--
-- 表的结构 `jsh_system_config`
--

CREATE TABLE `jsh_system_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `company_name` varchar(50) DEFAULT NULL COMMENT '公司名称',
  `company_contacts` varchar(20) DEFAULT NULL COMMENT '公司联系人',
  `company_address` varchar(50) DEFAULT NULL COMMENT '公司地址',
  `company_tel` varchar(20) DEFAULT NULL COMMENT '公司电话',
  `company_fax` varchar(20) DEFAULT NULL COMMENT '公司传真',
  `company_post_code` varchar(20) DEFAULT NULL COMMENT '公司邮编',
  `sale_agreement` varchar(500) DEFAULT NULL COMMENT '销售协议',
  `depot_flag` varchar(1) DEFAULT '0' COMMENT '仓库启用标记，0未启用，1启用',
  `customer_flag` varchar(1) DEFAULT '0' COMMENT '客户启用标记，0未启用，1启用',
  `minus_stock_flag` varchar(1) DEFAULT '0' COMMENT '负库存启用标记，0未启用，1启用',
  `purchase_by_sale_flag` varchar(1) DEFAULT '0' COMMENT '以销定购启用标记，0未启用，1启用',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数' ROW_FORMAT=COMPACT;


--
-- 表的结构 `jsh_tenant`
--

CREATE TABLE `jsh_tenant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `login_name` varchar(255) DEFAULT NULL COMMENT '登录名',
  `user_num_limit` int(11) DEFAULT NULL COMMENT '用户数量限制',
  `type` varchar(1) DEFAULT '0' COMMENT '租户类型，0免费租户，1付费租户',
  `enabled` bit(1) DEFAULT b'1' COMMENT '启用 0-禁用  1-启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `expire_time` datetime DEFAULT NULL COMMENT '到期时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='租户';


--
-- 表的结构 `jsh_unit`
--

CREATE TABLE `jsh_unit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '名称，支持多单位',
  `basic_unit` varchar(50) DEFAULT NULL COMMENT '基础单位',
  `other_unit` varchar(50) DEFAULT NULL COMMENT '副单位',
  `other_unit_two` varchar(50) DEFAULT NULL COMMENT '副单位2',
  `other_unit_three` varchar(50) DEFAULT NULL COMMENT '副单位3',
  `ratio` int(11) DEFAULT NULL COMMENT '比例',
  `ratio_two` int(11) DEFAULT NULL COMMENT '比例2',
  `ratio_three` int(11) DEFAULT NULL COMMENT '比例3',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='多单位表';


--
-- 表的结构 `jsh_user`
--

CREATE TABLE `jsh_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) NOT NULL COMMENT '用户姓名--例如张三',
  `login_name` varchar(255) NOT NULL COMMENT '登录用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '登陆密码',
  `position` varchar(200) DEFAULT NULL COMMENT '职位',
  `department` varchar(255) DEFAULT NULL COMMENT '所属部门',
  `email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `phonenum` varchar(100) DEFAULT NULL COMMENT '手机号码',
  `ismanager` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否为管理者 0==管理者 1==员工',
  `isystem` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否系统自带数据 ',
  `Status` tinyint(4) DEFAULT '0' COMMENT '状态，0：正常，1：删除，2封禁',
  `description` varchar(500) DEFAULT NULL COMMENT '用户描述信息',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';


--
-- 表的结构 `jsh_user_business`
--

CREATE TABLE `jsh_user_business` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(50) DEFAULT NULL COMMENT '类别',
  `key_id` varchar(50) DEFAULT NULL COMMENT '主id',
  `value` varchar(10000) DEFAULT NULL COMMENT '值',
  `btn_str` varchar(2000) DEFAULT NULL COMMENT '按钮权限',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户/角色/模块关系表';




SET FOREIGN_KEY_CHECKS = 1;