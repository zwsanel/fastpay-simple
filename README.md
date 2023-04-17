# 利支付

## 项目目标

打造千万级高可用支付平台，实现即开箱可用，简化个人/企业支付研发成本。

开源版本不代表最终品质，文档请加入QQ群获取

## 项目功能

1. 微信支付快速接入解决方案

2. 支付宝快速接入解决方案

3. 银行卡支付快速接入解决方案

4. SDK支持

5. 高并发能力支持

6. 高可用能力支持

## 支付用例

### 支付宝

```
        AlipayAppPayRequest alipayAppPayRequest = new AlipayAppPayRequest();
        alipayAppPayRequest.setRequestNo( String.valueOf( System.currentTimeMillis() ) );
        alipayAppPayRequest.setSubject("TEST");
        alipayAppPayRequest.setTotalAmount(new BigDecimal( "1.00" ) );
        alipayAppPayRequest.setTimeoutExpress("1c");
        alipayAppPayRequest.setBody("测试");
        alipayService.appPay( alipayAppPayRequest );
```

## 项目要求

开发语言：jAVA
技术栈：SpringBoot、Redis、RocketMQ、Mysql

数据库最低版本要求：5.7
JDK最低版本要求：1.8

## 技术交流

QQ群：561587480
