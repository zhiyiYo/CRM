use crm;
DROP TABLE IF EXISTS `tbl_transaction`;
CREATE TABLE `tbl_transaction` (
  `id` char(32) NOT NULL,
  `owner` char(32) DEFAULT NULL,
  `money` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `expectedDate` char(10) DEFAULT NULL,
  `customerId` char(32) DEFAULT NULL,
  `stage` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `activityId` char(32) DEFAULT NULL,
  `contactsId` char(32) DEFAULT NULL,
  `createBy` varchar(255) DEFAULT NULL,
  `createTime` char(19) DEFAULT NULL,
  `editBy` varchar(255) DEFAULT NULL,
  `editTime` char(19) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `contactSummary` varchar(255) DEFAULT NULL,
  `nextContactTime` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
insert into
  `tbl_transaction`(
    `id`,
    `owner`,
    `money`,
    `name`,
    `expectedDate`,
    `customerId`,
    `stage`,
    `type`,
    `source`,
    `activityId`,
    `contactsId`,
    `createBy`,
    `createTime`,
    `editBy`,
    `editTime`,
    `description`,
    `contactSummary`,
    `nextContactTime`
  )
values
  (
    '059c5c9b27e04ca085c9695ff1463f0e',
    '40f6cdea0bd34aceb77492a1656d9fb3',
    '200',
    '交易2',
    '2021-01-28',
    '4db545613a3a45c6bf2288d3b939795d',
    '需求分析',
    '已有业务',
    '内部研讨会',
    '84c5f525874244b6bd5a7c9bc73d36f9',
    'f813162a9a6445de8ceb2b6115c8a27b',
    '张三',
    '2021-02-01 13:02:18',
    NULL,
    NULL,
    '2',
    '2',
    '2021-02-04'
  ),
  (
    '4eec1397de764e70994115a3b2cb94bf',
    '40f6cdea0bd34aceb77492a1656d9fb3',
    '100000000',
    '小目标计划',
    '2021-01-29',
    '9cb43d197d5a4df8ae58f27e0a216bf7',
    '资质审查',
    '已有业务',
    '合作伙伴',
    '84c5f525874244b6bd5a7c9bc73d36f9',
    'f813162a9a6445de8ceb2b6115c8a27b',
    '张三',
    '2021-01-29 23:11:46',
    '张三',
    '2021-03-08 00:08:15',
    '不想还花呗......',
    '马云：那就不还了！！！',
    '2021-02-01'
  ),
  (
    'b2a53f73dada4a15b1b3fef193e24874',
    '40f6cdea0bd34aceb77492a1656d9fb3',
    '400',
    '交易4',
    '2021-02-01',
    '4db545613a3a45c6bf2288d3b939795d',
    '提案/报价',
    '已有业务',
    '推销电话',
    '84c5f525874244b6bd5a7c9bc73d36f9',
    'f813162a9a6445de8ceb2b6115c8a27b',
    '张三',
    '2021-02-01 13:03:00',
    NULL,
    NULL,
    '4',
    '4',
    '2021-02-17'
  ),
  (
    'bdcfa3c7f4ee4376919b6c6047bea367',
    '40f6cdea0bd34aceb77492a1656d9fb3',
    '300',
    '交易3',
    '2021-01-28',
    '4db545613a3a45c6bf2288d3b939795d',
    '提案/报价',
    '已有业务',
    '交易会',
    '84c5f525874244b6bd5a7c9bc73d36f9',
    'f813162a9a6445de8ceb2b6115c8a27b',
    '张三',
    '2021-02-01 13:02:44',
    NULL,
    NULL,
    '3',
    '3',
    '2021-02-01'
  ),
  (
    'c01c5a9754b941f88ac109839a193f60',
    '40f6cdea0bd34aceb77492a1656d9fb3',
    '100000000',
    '猪八戒找闰土买西瓜',
    '2021-01-28',
    '07fa2f5471da4661b0776868bafd1d23',
    '资质审查',
    '新业务',
    '外部介绍',
    '84c5f525874244b6bd5a7c9bc73d36f9',
    'f813162a9a6445de8ceb2b6115c8a27b',
    '张三',
    '2021-01-29 23:23:41',
    NULL,
    NULL,
    '最近瓜真多',
    '甜啊',
    '2021-02-04'
  ),
  (
    'd6ea2da3dcdf45aca9bb0efe0f0d19ff',
    '40f6cdea0bd34aceb77492a1656d9fb3',
    '100',
    '交易1',
    '2021-01-28',
    '9cb43d197d5a4df8ae58f27e0a216bf7',
    '资质审查',
    '已有业务',
    'web调研',
    '84c5f525874244b6bd5a7c9bc73d36f9',
    'f813162a9a6445de8ceb2b6115c8a27b',
    '张三',
    '2021-02-01 13:01:59',
    NULL,
    NULL,
    '1',
    '1',
    '1899-12-19'
  );