package com.javateam.demoMyBatis2.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.javateam.demoMyBatis2.domain.TestVO;

import lombok.extern.slf4j.Slf4j;

//@DataJpaTest
@SpringBootTest
@Slf4j
class TestTestDAO {

	@Autowired
	@Qualifier("testDAO")
	private TestDAO testDAO;
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
	
	@Transactional
	@Rollback(true)
	@Test
	public void testInsertTest() {
		
		TestVO expectedVO = TestVO.builder()
								  .id("javaman")
								  .name("김아환")
								  .address("경기도 성남시")
								  .build();
		
		testDAO.insertTest(expectedVO);
		
		TestVO actualVO = testDAO.selectTestById("javaman");
		
		assertThat(actualVO).isEqualTo(expectedVO);
	}
}
