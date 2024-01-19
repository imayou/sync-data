create table sys_mis_request_log
(
    id          bigint auto_increment comment 'ID' primary key,
    job_id      bigint        null,
    job_name    varchar(64)   null,
    prams       mediumtext    null comment '请求参数',
    response    mediumtext    null comment '响应',
    is_success  tinyint(1)    null,
    create_time datetime      null,
    method      varchar(32)   null,
    msg         mediumtext    null,
    url         varchar(512)  null,
    body        mediumtext    null,
    header      varchar(1024) null,
    bid         varchar(64)   null comment '业务id'
) comment '银海mis请求日志';

