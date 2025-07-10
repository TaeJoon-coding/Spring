package com.javateam.demoMyBatis3.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.javateam.demoMyBatis3.dao.TestDAO;
import com.javateam.demoMyBatis3.domain.TestVO;
import com.javateam.demoMyBatis3.service.TestMyBatis3Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestMyBatis3ServiceImpl implements TestMyBatis3Service {
	
	@Autowired
	@Qualifier("testDAO")
	private TestDAO testDAO;
	
	private final PlatformTransactionManager txManager;
		  
	public TestMyBatis3ServiceImpl(PlatformTransactionManager txManager) {
		this.txManager = txManager;
	}
	@Autowired
	private  TransactionTemplate txTemplate;
	
	@Transactional(readOnly = true)
	@Override
	public TestVO selectTestById(String id) {
		return testDAO.selectTestById(id);
	}

	@Override
	public boolean insertTest(TestVO testVO) {
//		TransactionStatus txStatus =
//		        txManager.getTransaction(new DefaultTransactionDefinition());
		DefaultTransactionDefinition txDef = new DefaultTransactionDefinition();
		txDef.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
		txDef.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus txStatus = txManager.getTransaction(txDef);
		
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
	
	// insertTestTemplate
	@Override
	public boolean insertTestTemplate(TestVO testVO) {
		
		boolean result = false;
		
		TransactionTemplate txTemplate = new TransactionTemplate(txManager);
		
		result = txTemplate.execute(new TransactionCallback<Boolean>() {

			@Override
			public Boolean doInTransaction(TransactionStatus status) {
				
				boolean result = false;
				
				try {
					testDAO.insertTest(testVO);
					result = true;
				} catch (Exception e) {
					result = false;
					status.setRollbackOnly();
					// あえてRollbackする必要はない。
				}
				return result;
			}
					
		});
		
		log.info("insertTestTemplate result : {}", result);
		
		return result;
	}
	
	// insertTestTemplateLambda
	@Override
	public boolean insertTestTemplateLambda(TestVO testVO) {
		
		boolean result = false;
		
//		TransactionTemplate txTemplate = new TransactionTemplate(txManager);
//		result = txTemplate.execute(new TransactionCallback<Boolean>() {
			//new TransactionCallback<Boolean>()がインターフェース
			// public Boolean doInTransaction関数明細
		result = txTemplate.execute((status) -> {
//				boolean result = false;
				try {
					testDAO.insertTest(testVO);
//					result = true;
					return true;
				} catch (Exception e) {
//					result = false;
					status.setRollbackOnly();
					// あえてRollbackする必要はない。
					log.error("insertTestTemplateλ error : " + e);
					return false;
				}
//				return result;
			}
					
		);
		
		log.info("insertTestTemplateλ result : {}", result);
		
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED, 
				   isolation = Isolation.DEFAULT )
	@Override
	public boolean insertTestTransactional(TestVO testVO) {
		
		boolean result = false;
		
		try {
			testDAO.insertTest(testVO);
			result = true;
		} catch (Exception e) {
//			result = false;
			log.error("insertTestTransactional result : {}", e);
		}
		return result;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW,
				   isolation = Isolation.DEFAULT,
				   rollbackFor = Exception.class)
	@Override
	public void insertTestTransactional2(TestVO testVO) {
			// voidはテストにあんまりいいとは言いずらいが、不可能ではない。
		testDAO.insertTest(testVO);
	}
}
