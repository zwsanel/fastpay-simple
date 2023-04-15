create table alipay_app
(
    id              bigint unsigned auto_increment comment '物理主键'
        primary key,
    request_no      varchar(64)    default ''                not null comment '商户流水号',
    process_no      varchar(64)    default ''                not null comment '业务流水号',
    app_id          varchar(20)    default ''                not null comment '支付宝APPID',
    out_trade_no    varchar(64)    default ''                not null comment '商户订单号',
    subject         varchar(64)    default ''                not null comment '订单标题',
    total_amount    decimal(17, 2) default 0.00              not null comment '订单总金额，单位为元，精确到小数点后两位',
    timeout_express varchar(64) null comment '该笔订单允许的最晚付款时间，逾期将关闭交易，超时关闭交易无法继续付款',
    time_expire     varchar(64) null comment '绝对超时时间，格式为yyyy-MM-dd HH:mm',
    status          varchar(64)    default ''                not null comment '订单状态',
    trade_no        varchar(64)    default ''                not null comment '支付宝交易号',
    buyer_logon_id  varchar(100)   default ''                not null comment '买家支付宝账号',
    trade_status    varchar(32)    default ''                not null comment '交易状态',
    buyer_user_id   varchar(16)    default ''                not null comment '买家在支付宝的用户id',
    date_created    timestamp      default CURRENT_TIMESTAMP not null comment '创建时间',
    created_by      varchar(100)   default 'sys'             not null comment '创建人',
    date_updated    timestamp      default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '修改时间',
    updated_by      varchar(100)   default 'sys'             not null comment '修改人',
    body            varchar(128) null comment '订单描述',
    constraint uk_request_no
        unique (request_no)
);

create index idx_status
    on alipay_app (status);

create index uk_out_trade_no
    on alipay_app (out_trade_no);

create index uk_trade_no
    on alipay_app (trade_no);

