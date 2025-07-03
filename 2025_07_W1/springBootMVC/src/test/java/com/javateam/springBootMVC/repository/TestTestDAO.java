package com.javateam.springBootMVC.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.javateam.springBootMVC.domain.TestEntity;

//import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class TestTestDAO {
	
	@Autowired
	TestDAO dao;

	@Test
	@Transactional
	@Rollback(false)	// DBに反映される。
//	@Rollback(true)		// DBに反映されない。
	void test() {
		
		TestEntity testVO = TestEntity.builder()
									  .id("abcd1234")
									  .name("javaman")
									  .address("Ehime")
									  .build();
		
		TestEntity testVO2 = dao.save(testVO);
		
		assertEquals(testVO, testVO2);
	}

}
