use crm;
DROP TABLE IF EXISTS `tbl_customer`;
CREATE TABLE `tbl_customer` (
  `id` char(32) NOT NULL,
  `owner` char(32) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `createBy` varchar(255) DEFAULT NULL,
  `createTime` char(19) DEFAULT NULL,
  `editBy` varchar(255) DEFAULT NULL,
  `editTime` char(19) DEFAULT NULL,
  `contactSummary` varchar(255) DEFAULT NULL,
  `nextContactTime` char(10) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
/*Data for the table `tbl_customer` */
insert into
  `tbl_customer`(
    `id`,
    `owner`,
    `name`,
    `website`,
    `phone`,
    `createBy`,
    `createTime`,
    `editBy`,
    `editTime`,
    `contactSummary`,
    `nextContactTime`,
    `description`,
    `address`
  )
values
  (
    '07fa2f5471da4661b0776868bafd1d23',
    '40f6cdea0bd34aceb77492a1656d9fb3',
    '猪八戒',
    NULL,
    NULL,
    '张三',
    '2021-01-29 23:23:41',
    NULL,
    NULL,
    '甜啊',
    '2021-02-04',
    NULL,
    NULL
  ),
  (
    '202de56b264b4daab4dd5bb8918518f6',
    '40f6cdea0bd34aceb77492a1656d9fb3',
    '格力',
    'www.geli.com',
    '021-33333333',
    '张三',
    '2021-01-29 23:20:16',
    NULL,
    NULL,
    '赌资一个亿',
    '2021-02-01',
    '雷军，打赌吗',
    '上海格力路格力集团'
  ),
  (
    '3b858b4d8a9241f49adbefcee32ba90b',
    '40f6cdea0bd34aceb77492a1656d9fb3',
    '小米集团',
    'www.mi.com',
    '022-88888888',
    '张三',
    '2021-01-29 01:53:18',
    NULL,
    NULL,
    '小爱同学你好',
    '2021-02-01',
    '干翻华为',
    '天津市小米集团路小米集团有限公司'
  ),
  (
    '4db545613a3a45c6bf2288d3b939795d',
    '40f6cdea0bd34aceb77492a1656d9fb3',
    '',
    NULL,
    NULL,
    '张三',
    '2021-02-01 13:02:18',
    NULL,
    NULL,
    '2',
    '2021-02-04',
    NULL,
    NULL
  ),
  (
    '995e231cce32456d9cf3d1c2e6f287c0',
    '40f6cdea0bd34aceb77492a1656d9fb3',
    '万达集团',
    'www.wanda.com',
    '010-66666666',
    '张三',
    '2021-01-28 02:13:40',
    NULL,
    NULL,
    '无',
    '2021-02-02',
    '永远相信美好的事情将要发生',
    '北京市万达路万达集团有限公司'
  ),
  (
    '9cb43d197d5a4df8ae58f27e0a216bf7',
    '40f6cdea0bd34aceb77492a1656d9fb3',
    '阿里巴巴',
    'www.alibaba.com',
    '010-88888888',
    '张三',
    '2021-01-28 02:00:02',
    NULL,
    NULL,
    '无',
    '2021-02-01',
    '干翻华为',
    '北京市阿里巴巴路阿里巴巴集团'
  );