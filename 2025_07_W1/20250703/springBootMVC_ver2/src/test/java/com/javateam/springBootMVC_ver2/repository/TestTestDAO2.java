package com.javateam.springBootMVC_ver2.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.javateam.springBootMVC_ver2.domain.TestEntity;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class TestTestDAO2 {
	
	@Autowired
	private TestDAO testDAO;
	
	@Test
	@Transactional
	@Rollback(false)	// DBに反映される。
//	@Rollback(true)		// DBに反映されない。
	void test() {
		
		log.info("testDAO insert Test");
		
		TestEntity testVO2 = TestEntity.builder().id("abcd1234")
									    .name("javaman")
									    .address("Ehime")
									    .build();
		
		TestEntity testVO3 = testDAO.save(testVO2);
		
		assertEquals(testVO2, testVO3);
	}
	
	@Test
	void testCount() {
		log.info("全体人数確認");
//		assertEquals(100, testDAO.count());
		assertEquals(101, testDAO.count());
	}

}
