drop table if exists t_admin;

drop table if exists t_user;

/*==============================================================*/
/* Table: t_admin                                               */
/*==============================================================*/
create table t_admin
(
   id                   int not null auto_increment,
   name                 varchar(32),
   account              varchar(32),
   password             varchar(32),
   primary key (id)
);

alter table t_admin comment '管理员表';

insert into t_admin values (1,'管理员','admin','123');

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   int not null auto_increment,
   nick_name            varchar(32),
   account              varchar(32),
   password             varchar(32),
   gender               varchar(6),
   birthday             varchar(32),
   phone                varchar(16),
   email                varchar(64),
   head_pic             varchar(64),
   description          text,
   birthplace           varchar(16),
   primary key (id)
);

alter table t_user comment '普通用户表';

insert into t_user values (1,'张三','zhangsan','123','男','2002-10-10','13966668888','13966668888@qq.com','/a.png','好人一个.','江苏，南京');
/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/10/25 11:40:41                          */
/*==============================================================*/


drop table if exists t_video;

/*==============================================================*/
/* Table: t_video                                               */
/*==============================================================*/
create table t_video
(
    id                   int not null auto_increment,
    name                 varchar(32),
    author               varchar(32),
    type                 varchar(32),
    create_time          varchar(32),
    time_length          int,
    video_path           varchar(64),
    cover_path           varchar(64),
    description          text,
    primary key (id)
);
alter table t_video comment '视频表';
insert into t_video values (1,'my_name','my_author','科幻','2022-10-10 09:55:55',5,'/gydzzzx.mp4','/gydzzzx.png','my_description');

/*==============================================================*/
/* Table: t_video                                               */
/*==============================================================*/
drop table if exists t_watch;

create table t_watch
(
    id                   int not null auto_increment,
    user_id              int,
    video_id             int,
    primary key (id)
);
alter table t_watch comment '播放记录表';
insert into t_watch values (1,3,5);

