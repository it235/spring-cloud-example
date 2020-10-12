/*该SQL为项目必须执行的脚本*/
CREATE TABLE `sys_province` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增列',
  `province_code` varchar(40) NOT NULL COMMENT '省份代码',
  `province_name` varchar(50) NOT NULL COMMENT '省份名称',
  `short_name` varchar(20) NOT NULL COMMENT '简称',
  `lng` varchar(20) DEFAULT NULL COMMENT '经度',
  `lat` varchar(20) DEFAULT NULL COMMENT '纬度',
  `sort` int(6) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(60) DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(60) DEFAULT NULL COMMENT '修改人ID',
  `del_flag` tinyint(11) DEFAULT NULL COMMENT '是否删除[0-有效 1-无效]',
  `delete_by` varchar(60) DEFAULT NULL COMMENT '删除人ID',
  `delete_time` datetime DEFAULT NULL COMMENT '删除日期',
  `tenant_id` varchar(10) DEFAULT 10000 COMMENT '租户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='省份信息';

INSERT INTO `sys_province` (`id`, `province_code`, `province_name`, `short_name`, `lng`, `lat`, `sort`, `create_time`, `create_by`, `update_time`, `update_by`, `del_flag`, `delete_by`, `delete_time`) VALUES
('1', '110000', '北京', '北京', '116.405289', '39.904987', '1', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('2', '120000', '天津', '天津', '117.190186', '39.125595', '2', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('3', '130000', '河北省', '河北', '114.502464', '38.045475', '3', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('4', '140000', '山西省', '山西', '112.549248', '37.857014', '4', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('5', '150000', '内蒙古自治区', '内蒙古', '111.670799', '40.81831', '5', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('6', '210000', '辽宁省', '辽宁', '123.429092', '41.796768', '6', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('7', '220000', '吉林省', '吉林', '125.324501', '43.886841', '7', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('8', '230000', '黑龙江省', '黑龙江', '126.642464', '45.756966', '8', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('9', '310000', '上海', '上海', '121.472641', '31.231707', '9', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('10', '320000', '江苏省', '江苏', '118.76741', '32.041546', '10', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('11', '330000', '浙江省', '浙江', '120.15358', '30.287458', '11', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('12', '340000', '安徽省', '安徽', '117.283043', '31.861191', '12', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('13', '350000', '福建省', '福建', '119.306236', '26.075302', '13', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('14', '360000', '江西省', '江西', '115.892151', '28.676493', '14', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('15', '370000', '山东省', '山东', '117.000923', '36.675808', '15', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('16', '410000', '河南省', '河南', '113.665413', '34.757977', '16', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('17', '420000', '湖北省', '湖北', '114.298569', '30.584354', '17', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('18', '430000', '湖南省', '湖南', '112.982277', '28.19409', '18', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('19', '440000', '广东省', '广东', '113.28064', '23.125177', '19', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('20', '450000', '广西壮族自治区', '广西', '108.320007', '22.82402', '20', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('21', '460000', '海南省', '海南', '110.331192', '20.031971', '21', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('22', '500000', '重庆', '重庆', '106.504959', '29.533155', '22', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('23', '510000', '四川省', '四川', '104.065735', '30.659462', '23', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('24', '520000', '贵州省', '贵州', '106.713478', '26.578342', '24', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('25', '530000', '云南省', '云南', '102.71225', '25.040609', '25', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('26', '540000', '西藏自治区', '西藏', '91.13221', '29.66036', '26', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('27', '610000', '陕西省', '陕西', '108.948021', '34.263161', '27', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('28', '620000', '甘肃省', '甘肃', '103.823555', '36.058041', '28', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('29', '630000', '青海省', '青海', '101.778915', '36.623177', '29', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('30', '640000', '宁夏回族自治区', '宁夏', '106.278175', '38.46637', '30', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('31', '650000', '新疆维吾尔自治区', '新疆', '87.617729', '43.792816', '31', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('32', '710000', '台湾省', '台湾', '121.509064', '25.044333', '34', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('33', '810000', '香港特别行政区', '香港', '114.173355', '22.320047', '32', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL),
('34', '820000', '澳门特别行政区', '澳门', '113.549088', '22.198952', '33', '2019-02-28 17:16:58', NULL, '2019-02-28 17:17:05', NULL, '0', NULL, NULL);