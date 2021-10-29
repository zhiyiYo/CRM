DROP TABLE IF EXISTS `tbl_contacts`;
CREATE TABLE `tbl_contacts` (
  `id` char(32) NOT NULL,
  `owner` char(32) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `customerId` char(32) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `appellation` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mphone` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `birth` char(10) DEFAULT NULL,
  `createBy` varchar(255) DEFAULT NULL,
  `createTime` char(19) DEFAULT NULL,
  `editBy` varchar(255) DEFAULT NULL,
  `editTime` char(19) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `contactSummary` varchar(255) DEFAULT NULL,
  `nextContactTime` char(10) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

/*Data for the table `tbl_contacts` */
insert into
  `tbl_contacts`(
    `id`,
    `owner`,
    `source`,
    `customerId`,
    `fullname`,
    `appellation`,
    `email`,
    `mphone`,
    `job`,
    `birth`,
    `createBy`,
    `createTime`,
    `editBy`,
    `editTime`,
    `description`,
    `contactSummary`,
    `nextContactTime`,
    `address`
  )
values
  (
    'aad0728e996f420382ef74d687dbb34a',
    '40f6cdea0bd34aceb77492a1656d9fb3',
    '内部研讨会',
    '3b858b4d8a9241f49adbefcee32ba90b',
    '雷军',
    '先生',
    'LeiJun@qq.com',
    '18888888888',
    'CEO',
    NULL,
    '张三',
    '2021-01-29 01:53:18',
    NULL,
    NULL,
    '干翻华为',
    '小爱同学你好',
    '2021-02-01',
    '天津市小米集团路小米集团有限公司'
  ),
  (
    'd9255b7ba44b47238a38c6038e0d34de',
    '40f6cdea0bd34aceb77492a1656d9fb3',
    '公开媒介',
    '202de56b264b4daab4dd5bb8918518f6',
    '董明珠',
    '女士',
    'dongmingzhu@126.com',
    '13333333333',
    'CEO',
    NULL,
    '张三',
    '2021-01-29 23:20:16',
    NULL,
    NULL,
    '雷军，打赌吗',
    '赌资一个亿',
    '2021-02-01',
    '上海格力路格力集团'
  ),
  (
    'f813162a9a6445de8ceb2b6115c8a27b',
    '40f6cdea0bd34aceb77492a1656d9fb3',
    '合作伙伴',
    '9cb43d197d5a4df8ae58f27e0a216bf7',
    '马云',
    '先生',
    'mayun@qq.com',
    '13888888888',
    'CEO',
    NULL,
    '张三',
    '2021-01-28 02:00:02',
    NULL,
    NULL,
    '干翻华为',
    '无',
    '2021-02-01',
    '北京市阿里巴巴路阿里巴巴集团'
  ),
  (
    'fadbec6aa3774bf2b8782e5a2d3af153',
    '40f6cdea0bd34aceb77492a1656d9fb3',
    '合作伙伴研讨会',
    '995e231cce32456d9cf3d1c2e6f287c0',
    '王健林',
    '先生',
    'wangjianlin@163.com',
    '13666666666',
    'CEO',
    NULL,
    '张三',
    '2021-01-28 02:13:40',
    NULL,
    NULL,
    '永远相信美好的事情将要发生',
    '无',
    '2021-02-02',
    '北京市万达路万达集团有限公司'
  );