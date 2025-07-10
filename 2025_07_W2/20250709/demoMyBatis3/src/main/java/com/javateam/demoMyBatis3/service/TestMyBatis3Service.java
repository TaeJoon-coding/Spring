package com.javateam.demoMyBatis3.service;

import com.javateam.demoMyBatis3.domain.TestVO;

public interface TestMyBatis3Service {

	/**
	 * 個別会員情報照会
	 * 
	 * @Param id 会員ID
	 * @Return 会員情報
	 * 
	 * */
	public TestVO selectTestById(String id);
	
	/**
	 * 個別会員情報挿入（生成）
	 * 
	 * @Param testVO 会員情報
	 * @return 保存するかしないか
	 * */	
	public boolean insertTest(TestVO testVO);

	/**
	 * 個別会員情報挿入（生成）：TransactionTemplate使用
	 * 
	 * @Param testVO 会員情報
	 * @return 保存するかしないか
	 * */	
	public boolean insertTestTemplate(TestVO testVO);
	
	/**
	 * 個別会員情報挿入（生成）：TransactionTemplate使用
	 * (ラムダ関数を使用。)
	 * 
	 * @Param testVO 会員情報
	 * @return 保存するかしないか
	 * */	
	public boolean insertTestTemplateLambda(TestVO testVO);
	
	/**
	 * 個別会員情報挿入（生成）：@Transactional
	 * 
	 * @Param testVO 会員情報
	 * @return 保存するかしないか
	 * */	
	public boolean insertTestTransactional(TestVO testVO);
	
	/**
	 * 個別会員情報挿入（生成）：@Transactional 2番目
	 * 
	 * @Param testVO 会員情報
	 * 
	 * voidは「@return 保存するかしないか」が存在しない。
	 * */	
	public void insertTestTransactional2(TestVO testVO);
}
