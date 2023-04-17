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
    timeout_express varchar(64)                              null comment '该笔订单允许的最晚付款时间，逾期将关闭交易，超时关闭交易无法继续付款',
    time_expire     varchar(64)                              null comment '绝对超时时间，格式为yyyy-MM-dd HH:mm',
    status          varchar(64)    default ''                not null comment '订单状态',
    trade_no        varchar(64)    default ''                not null comment '支付宝交易号',
    buyer_logon_id  varchar(100)   default ''                not null comment '买家支付宝账号',
    trade_status    varchar(32)    default ''                not null comment '交易状态',
    buyer_user_id   varchar(16)    default ''                not null comment '买家在支付宝的用户id',
    date_created    timestamp      default CURRENT_TIMESTAMP not null comment '创建时间',
    created_by      varchar(100)   default 'sys'             not null comment '创建人',
    date_updated    timestamp      default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '修改时间',
    updated_by      varchar(100)   default 'sys'             not null comment '修改人',
    body            varchar(128)                             null comment '订单描述',
    constraint uk_request_no
        unique (request_no)
);

create index idx_status
    on alipay_app (status);

create index uk_out_trade_no
    on alipay_app (out_trade_no);

create index uk_trade_no
    on alipay_app (trade_no);

create table wechat
(
    id               bigint unsigned default '0'               not null comment '物理主键'
        primary key,
    request_no       varchar(64)     default ''                not null comment '商户流水号',
    process_no       varchar(64)     default ''                not null comment '流水号',
    wechat_member_no varchar(20)     default ''                not null comment '微信商户号',
    app_id           varchar(20)     default ''                not null comment '微信应用ID',
    trade_type       varchar(64)     default ''                not null comment '交易类型:JSAPI 小程序,MWEB h5支付，APP app支付,NATIVE 扫码支付',
    notice_queue     varchar(100)    default ''                not null comment '支付结果通知队列名称',
    ext_text1        varchar(500)                              null comment '扩展信息',
    product_id       varchar(64)     default ''                not null comment '产品编号,用于线下扫码支付',
    code_url         varchar(200)    default ''                not null comment '支付url 扫码和h5支付使用',
    mweb_url         varchar(200)    default ''                not null comment 'h5支付唤起url',
    scene_info       varchar(256)    default ''                not null comment '支付场景，主要用于h5支付',
    request_ip       varchar(64)     default ''                not null comment '用户请求ip',
    prepay_id        varchar(64)     default ''                not null comment '预付单',
    order_no         varchar(64)     default ''                not null comment '商户订单号',
    transaction_id   varchar(64)     default ''                not null comment '微信支付订单号',
    amount           decimal(17, 2)                            null comment '金额',
    remark           varchar(200)                              null comment '备注',
    submit_time      timestamp                                 null comment '订单提交时间',
    expire_time      timestamp                                 null comment '订单失效时间',
    pay_time         timestamp                                 null comment '订单支付时间',
    return_time      timestamp                                 null comment '订单返回时间',
    return_code      varchar(16)                               null comment '返回状态码',
    return_msg       varchar(500)                              null comment '返回信息',
    result_code      varchar(20)     default ''                not null comment '返回码',
    err_code         varchar(32)                               null comment '错误代码',
    err_code_des     varchar(128)                              null comment '错误代码描述',
    open_id          varchar(128)                              null comment '用户在商户appid下的唯一标识',
    bank_type        varchar(16)                               null comment '付款银行',
    trade_state      varchar(32)                               null comment '交易状态',
    trade_state_desc varchar(256)                              null comment '交易状态描述',
    status           varchar(20)     default ''                not null comment '状态',
    trade_limit      varchar(20)     default ''                not null comment '交易限制，no_credit(不支持信用卡)，allow_credit(支持信用卡)',
    trade_desc       varchar(100)    default ''                not null comment '交易描述',
    date_created     timestamp       default CURRENT_TIMESTAMP not null comment '创建时间',
    created_by       varchar(100)    default 'sys'             not null comment '创建人',
    date_updated     timestamp       default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '修改时间',
    updated_by       varchar(100)    default 'sys'             not null comment '修改人',
    constraint uk_process_no
        unique (process_no),
    constraint uk_request_no
        unique (request_no)
)
    comment '微信支付表';

create index idx_order_no
    on wechat (order_no);

create index idx_prepay_id
    on wechat (prepay_id);

create index idx_status
    on wechat (status);

create index idx_transaction_id
    on wechat (transaction_id);

create table wechat_refund
(
    id                 int unsigned auto_increment comment '主键'
        primary key,
    request_no         varchar(64)  default ''                not null comment '流水号',
    process_no         varchar(64)  default ''                not null comment '处理号',
    target_request_no  varchar(64)  default ''                not null comment '原始订单流水',
    wechat_member_no   varchar(20)  default ''                not null comment '微信商户号',
    out_refund_no      varchar(64)  default ''                not null comment '退款单号',
    refund_fee         decimal(17, 2)                         null comment '退款金额',
    refund_desc        varchar(80)                            null comment '退款原因',
    return_code        varchar(16)                            null comment '返回状态码',
    return_msg         varchar(128)                           null comment '返回信息',
    result_code        varchar(20)  default ''                not null comment '返回码',
    err_code           varchar(32)                            null comment '错误代码',
    err_code_des       varchar(128)                           null comment '错误代码描述',
    refund_id          varchar(32)  default ''                not null comment '微信退款单号',
    refund_status      varchar(16)  default ''                not null comment '微信退款状态',
    status             varchar(20)  default ''                not null comment '退款状态',
    refund_recv_accout varchar(64)  default ''                not null comment '退款入账账户',
    date_created       timestamp    default CURRENT_TIMESTAMP not null comment '创建时间',
    created_by         varchar(100) default 'sys'             not null comment '创建人',
    date_updated       timestamp    default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '修改时间',
    updated_by         varchar(100) default 'sys'             not null comment '修改人',
    constraint uk_process_no
        unique (process_no),
    constraint uk_request_no
        unique (request_no)
)
    comment '微信退款';

create index idx_target_request_no
    on wechat_refund (target_request_no);

