package com.javateam.demoMyBatis3.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.javateam.demoMyBatis3.domain.TestVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class TestTestMyBatis3Service {

	@Autowired
	private TestMyBatis3Service testService;
	
	@Transactional
	@Rollback(true)	// テスト段階では
	@Test
	void testInsertTest() {
		
		TestVO expectedVO = TestVO.builder()
				.id("java111")
				.name("スプリング")
				.address("渋谷")
				.build();
		assertTrue(testService.insertTest(expectedVO));
	}

}
