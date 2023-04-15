package com.lilipay;

import com.lilipay.alipay.AlipayService;
import com.lilipay.alipay.domain.AlipayAppPayRequest;
import com.lilipay.alipay.domain.AlipayTradeQueryRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;

@SpringBootTest
class LilipayApplicationTests {

	@Resource
	private AlipayService alipayService;

	@Test
	void contextLoads() {
	}

	@Test
	void alipayAppPay() {
		AlipayAppPayRequest alipayAppPayRequest = new AlipayAppPayRequest();
		alipayAppPayRequest.setRequestNo( String.valueOf( System.currentTimeMillis() ) );
		alipayAppPayRequest.setSubject("TEST");
		alipayAppPayRequest.setTotalAmount(new BigDecimal( "1.00" ) );
		alipayAppPayRequest.setTimeoutExpress("1c");
		alipayAppPayRequest.setBody("测试");
		System.out.println( alipayService.appPay( alipayAppPayRequest ) );
	}

	@Test
	void alipayTradeQuery() {
		String requestNo = String.valueOf( System.currentTimeMillis() );
		AlipayAppPayRequest alipayAppPayRequest = new AlipayAppPayRequest();
		alipayAppPayRequest.setRequestNo( requestNo );
		alipayAppPayRequest.setSubject("TEST");
		alipayAppPayRequest.setTotalAmount(new BigDecimal( "1.00" ) );
		alipayAppPayRequest.setTimeoutExpress("1c");
		alipayAppPayRequest.setBody("测试");
		System.out.println( alipayService.appPay( alipayAppPayRequest ) );

		AlipayTradeQueryRequest orderQueryRequest = new AlipayTradeQueryRequest();
		orderQueryRequest.setRequestNo(requestNo);
		System.out.println( alipayService.tradeQuery( orderQueryRequest ) );
	}
}
