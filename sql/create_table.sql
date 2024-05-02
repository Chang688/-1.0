
-- 用户表
create table user
(
    username     varchar(256) null comment '用户昵称',
    id           bigint auto_increment comment 'id'
        primary key,
    userAccount  varchar(256) null comment '账号',
    avatarUrl    varchar(1024) null comment '用户头像',
    gender       tinyint null comment '性别',
    userPassword varchar(512)       not null comment '密码',
    phone        varchar(128) null comment '电话',
    contactInfo        varchar(512) null comment '联系方式',
    `profile`        varchar(512) null comment '个人简介',
    userStatus   int      default 0 not null comment '状态 0 - 正常',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete     tinyint  default 0 not null comment '是否删除',
    userRole     int      default 0 not null comment '用户角色 0 - 普通用户 1 - 管理员',
    planetCode   varchar(512) null comment '编号',
    tags         varchar(1024) null comment '标签 json 列表'
) comment '用户';

-- 队伍表
create table team
(
    id          bigint auto_increment comment 'id' primary key,
    name        varchar(256)       not null comment '队伍名称',
    description varchar(1024) null comment '描述',
    avatarUrl varchar(1024) null comment '队伍头像',
    maxNum      int      default 1 not null comment '最大人数',
    expireTime  datetime null comment '过期时间',
    userId      bigint comment '创建人id',
    status      int      default 0 not null comment '0 - 公开，1 - 私有，2 - 加密',
    password    varchar(512) null comment '密码',
    createTime  datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime  datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete    tinyint  default 0 not null comment '是否删除'
) comment '队伍';

-- 用户队伍关系
create table user_team
(
    id         bigint auto_increment comment 'id'
        primary key,
    userId     bigint comment '用户id',
    teamId     bigint comment '队伍id',
    joinTime   datetime null comment '加入时间',
    createTime datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete   tinyint  default 0 not null comment '是否删除'
) comment '用户队伍关系';

# 消息表
CREATE TABLE `im` (
                      `id` bigint NOT NULL AUTO_INCREMENT,
                      `uid` bigint NOT NULL COMMENT '用户id',
                      `username` varchar(255) NOT NULL COMMENT '用户名',
                      `avatarUrl` varchar(1024) DEFAULT NULL COMMENT '用户头像',
                      `profile` varchar(512) DEFAULT NULL COMMENT '个人简介',
                      `text` text COMMENT '消息内容',
                      `createTime` datetime DEFAULT CURRENT_TIMESTAMP NULL COMMENT '创建时间',
                      `img` varchar(1024) DEFAULT NULL COMMENT '图片',
                      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


#文章表
create table article
(
    id      int auto_increment comment '自增id'
        primary key,
    name    varchar(512)   null comment '文章名字',
    time    varchar(512)   null comment '比赛的时间',
    context varchar(15000) null comment '文章内容',
    createTime datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete   tinyint  default 0 not null comment '是否删除'
)
    comment '文章表';

drop table carousel_article;

-- auto-generated definition
create table carousel_article
(
    carouselId int auto_increment comment '轮播图id'
        primary key,
    articleId  int null comment '文章id',
    carouserUrl    varchar(1024) null comment '轮播图头像',
    createTime datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete   tinyint  default 0 not null comment '是否删除'
)
    comment '轮播图_文章';

#动态
create table dynamic
(
    id      int auto_increment comment '自增id'
        primary key,
    userId    int   null comment '用户id',
    context varchar(15000) null comment '动态内容',
    status int not null default 0 comment '0-发的动态 1-代表评论',
    createTime datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete   tinyint  default 0 not null comment '是否删除'
)
    comment '动态评论';
#动态评论关联表
create table dynamic_comment
(
    id      int auto_increment comment '自增id'
        primary key,
    userId    int   null comment '用户id',
    dynamicId int   null comment '动态id',
    createTime datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete   tinyint  default 0 not null comment '是否删除'
)
    comment '动态评论关联表';