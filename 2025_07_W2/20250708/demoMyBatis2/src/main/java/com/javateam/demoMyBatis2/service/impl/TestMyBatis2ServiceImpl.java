package com.javateam.demoMyBatis2.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.javateam.demoMyBatis2.dao.TestDAO;
import com.javateam.demoMyBatis2.domain.TestVO;
import com.javateam.demoMyBatis2.service.TestMyBatis2Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestMyBatis2ServiceImpl implements TestMyBatis2Service {
	
	@Autowired
	@Qualifier("testDAO")
	private TestDAO testDAO;
	
	private final PlatformTransactionManager txManager;
		  
	public TestMyBatis2ServiceImpl(PlatformTransactionManager txManager) {
		this.txManager = txManager;
	}
	
	@Transactional(readOnly = true)
	@Override
	public TestVO selectTestById(String id) {
		return testDAO.selectTestById(id);
	}

	@Override
	public boolean insertTest(TestVO testVO) {

		TransactionStatus txStatus =
		        txManager.getTransaction(new DefaultTransactionDefinition());
		
		boolean result = false;
				
		try {
			
			testDAO.insertTest(testVO);			
			txManager.commit(txStatus);
			result = true;
			
		} catch (Exception e) {
			
			txManager.rollback(txStatus);
			result = false;
			log.error("TestMyBatisServiceImpl.insertTest : " + e);
		}
		
		return result;
	}
	

}
