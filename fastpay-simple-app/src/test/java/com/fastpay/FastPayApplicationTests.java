package com.fastpay;

import com.fastpay.alipay.AlipayService;
import com.fastpay.alipay.domain.AlipayAppPayInput;
import com.fastpay.alipay.domain.AlipayTradeQueryInput;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;

@SpringBootTest
class FastPayApplicationTests {

	@Resource
	private AlipayService alipayService;

	@Test
	void contextLoads() {
	}

	@Test
	void alipayAppPay() {
		AlipayAppPayInput alipayAppPayRequest = new AlipayAppPayInput();
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
		AlipayAppPayInput alipayAppPayRequest = new AlipayAppPayInput();
		alipayAppPayRequest.setRequestNo( requestNo );
		alipayAppPayRequest.setSubject("TEST");
		alipayAppPayRequest.setTotalAmount(new BigDecimal( "1.00" ) );
		alipayAppPayRequest.setTimeoutExpress("1c");
		alipayAppPayRequest.setBody("测试");
		System.out.println( alipayService.appPay( alipayAppPayRequest ) );

		AlipayTradeQueryInput orderQueryRequest = new AlipayTradeQueryInput();
		orderQueryRequest.setRequestNo(requestNo);
		System.out.println( alipayService.tradeQuery( orderQueryRequest ) );
	}
}
