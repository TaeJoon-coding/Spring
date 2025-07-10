package com.javateam.demoMyBatis3.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.javateam.demoMyBatis3.dao.impl.TestDAOImpl2;
import com.javateam.demoMyBatis3.domain.TestVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class TestTestDAO2 {
	
	// より簡単なやり方。
	@Autowired	// こいつのオリジンはほかにある。Lombokよりは愛されている。
	@Qualifier("testDAO2")	// 存在しない名前、この場合、最初の物を読み込む。
	// インターフェースを読み込む方式であり、実は内部的に優先順位表みたいなものがあるようだ。
	private TestDAO testDAO;
	
	// より複雑なやり方。
//	private final TestDAO testDAO;
//	@Autowired
//	public TestTestDAO2(TestDAOImpl2 testDAO) {
//		this.testDAO = testDAO;
//	}

	/*
	 * 個別会員情報照会
	 *  : 期待値 VO 生成(expected) => 実際(actual)値 VO = 比較(equals) => 同等比較点検
	 *  
	 * */
	@Test
	void testSelectTestById() {
		
		log.info("testSelectTestById test");
		
		TestVO expectedVO = TestVO.builder()
								  .id("ayqi8103")
								  .name("김아환")
								  .address("경기도 성남시 분당구 미금로 177 (구미동, 까치마을) 106동 102호")
								  .build();
		
		TestVO actualVO = testDAO.selectTestById("ayqi8103");
		
//		assertEquals(expectedVO, actualVO);
		// 通常とは違って、「import...」から始まるではなく「Add static import...」で、
		// 「import static」を記入する。
		
		assertThat(actualVO).isEqualTo(expectedVO);
	}
}
