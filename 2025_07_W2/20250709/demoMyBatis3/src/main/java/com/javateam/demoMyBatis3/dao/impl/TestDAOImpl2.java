package com.javateam.demoMyBatis3.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javateam.demoMyBatis3.dao.TestDAO;
import com.javateam.demoMyBatis3.domain.TestVO;
import com.javateam.demoMyBatis3.mapper.TestMapper;

import lombok.extern.slf4j.Slf4j;

@Repository("testDAO2")
@Slf4j
public class TestDAOImpl2 implements TestDAO {
	
	@Autowired
	private SqlSession sqlSession;
	// Springから自動生成される。
	
	@Autowired
	TestMapper testMapper;
	
	// XMLではなく、
	// TestMapper(Interface Mapper)で 注入(Injection)
	@Override
	public TestVO selectTestById(String id) {
		// TODO Auto-generated method stub
//		return sqlSession.getMapper(TestMapper.class)
//						 .selectTestById(id);
		return testMapper.selectTestById(id);
	}

	@Override
	public void insertTest(TestVO testVO) {
		// TODO Auto-generated method stub
//		sqlSession.getMapper(TestMapper.class).insertTest(testVO);
		// testMapper.insertTest(testVO);
		testMapper.insertTest2(testVO);
	}


}
