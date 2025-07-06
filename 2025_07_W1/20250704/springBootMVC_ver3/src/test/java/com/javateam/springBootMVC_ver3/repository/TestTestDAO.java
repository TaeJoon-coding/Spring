package com.javateam.springBootMVC_ver3.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.javateam.springBootMVC_ver3.domain.TestEntity;
import com.javateam.springBootMVC_ver3.domain.TestVO;

//import com.javateam.springBootMVC_ver3.repository.TestDAO;
//import com.javateam.springBootMVC_ver3.domain.TestEntity;

//import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class TestTestDAO {
	
	@Autowired
	TestDAO testDAO;

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
	void testSelect() {
		
		log.info("select test");
		
		Optional<TestEntity> testVO2 = testDAO.findById("abcd1234");
		
		assertFalse(testVO2.isEmpty());
		
		assertEquals("javaman", testVO2.get().getName());
		
	}
	
}
