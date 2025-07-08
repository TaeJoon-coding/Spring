package com.javateam.demoMyBatis2.service;

import com.javateam.demoMyBatis2.domain.TestVO;

public interface TestMyBatis2Service {

	/*
	 * 個別会員情報照会
	 * 
	 * @Param id 会員ID
	 * @Return 会員情報
	 * 
	 * */
	public TestVO selectTestById(String id);
	
	/*
	 * 個別会員情報挿入（生成）
	 * 
	 * @Param testVO 会員情報
	 * @return 保存するかしないか
	 * */	
	public boolean insertTest(TestVO testVO);
	
}
