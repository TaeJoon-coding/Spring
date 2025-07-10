package com.javateam.demoMyBatis3.dao;

import com.javateam.demoMyBatis3.domain.TestVO;

public interface TestDAO {
	
	/**
	 * 個別会員情報照会
	 * 
	 * @Param id 会員ID
	 * @return 会員情報
	 * 
	 * 
	 * */
	//	TestVO selectTestById(String id);
	public TestVO selectTestById(String id);	// 「public」はなくても良いが、入れた方が良い。

	/**
	 * 個別会員情報挿入
	 * @param testVO
	 */
	public void insertTest(TestVO testVO);
	
	
}
