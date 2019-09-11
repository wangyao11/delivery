# 学校食堂配送系统服务端

##数据库设计
```sql
-- 用户(学校)
CREATE TABLE tb_user
(
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  name varchar(100) DEFAULT NULL COMMENT '账户名称',
  account varchar(11) NOT NULL COMMENT '登录账户',
  password varchar(50) NOT NULL COMMENT '密码',
  states tinyint(4) NOT NULL COMMENT '状态:0-启用,1-禁用',
  remark varchar(100) DEFAULT NULL COMMENT '用户备注',
  address varchar(100) DEFAULT NULL COMMENT '用户地址',
  createTime datetime DEFAULT NULL COMMENT '记录创建时间',
  updateTime datetime DEFAULT NULL COMMENT '记录更新时间',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 管理员账户
CREATE TABLE tb_admin
(
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  name varchar(100) DEFAULT NULL COMMENT '账户名称',
  account varchar(11) NOT NULL COMMENT '登录账户',
  password varchar(50) NOT NULL COMMENT '密码',
  remark varchar(100) DEFAULT NULL COMMENT '备注',
  createTime datetime DEFAULT NULL COMMENT '记录创建时间',
  updateTime datetime DEFAULT NULL COMMENT '记录更新时间',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 产品分类
CREATE TABLE tb_product_class
(
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类Id',
  name varchar(100) DEFAULT NULL COMMENT '分类名称',
  remark varchar(100) DEFAULT NULL COMMENT '备注',
  sort int(10) NOT NULL DEFAULT 0 COMMENT '分类排序，从大到小',
  createTime datetime DEFAULT NULL COMMENT '记录创建时间',
  updateTime datetime DEFAULT NULL COMMENT '记录更新时间',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 产品
CREATE TABLE tb_product
(
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品Id',
  name varchar(100) DEFAULT NULL COMMENT '产品名称',
  imageUrl varchar(100) DEFAULT NULL COMMENT '产品图片',
  classId bigint(20) NOT NULL DEFAULT 0 COMMENT '分类Id',
  remark varchar(100) DEFAULT NULL COMMENT '备注',
  states tinyint(4) NOT NULL COMMENT '状态:0-上架,1-下架',
  type tinyint(4) NOT NULL COMMENT '商品类型 0-斤 1-袋 2-瓶 3-桶 4-包 5-个 6-件',
  sort int(10) NOT NULL DEFAULT 0 COMMENT '分类排序，从大到小',
  createTime datetime DEFAULT NULL COMMENT '记录创建时间',
  updateTime datetime DEFAULT NULL COMMENT '记录更新时间',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 配送单
CREATE TABLE tb_delivery_item
(
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '配送区间id',
  dateTime date NOT NULL COMMENT '配送区间时间点 2019-09-04',
  states tinyint(4) NOT NULL COMMENT '状态:0-启用,1-禁用',
  remark varchar(100) DEFAULT NULL COMMENT '备注',
  createTime datetime DEFAULT NULL COMMENT '记录创建时间',
  updateTime datetime DEFAULT NULL COMMENT '记录更新时间',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 配送单详情
CREATE TABLE tb_delivery_user_product_mapper
(
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  deliveryItemId date NOT NULL COMMENT '配送单Id',
  userId tinyint(4) NOT NULL COMMENT '用户',
  productId tinyint(4) NOT NULL COMMENT '产品ID',
  totalCount int NOT NULL DEFAULT 0 COMMENT '产品数量',
  createTime datetime DEFAULT NULL COMMENT '记录创建时间',
  updateTime datetime DEFAULT NULL COMMENT '记录更新时间',
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

```