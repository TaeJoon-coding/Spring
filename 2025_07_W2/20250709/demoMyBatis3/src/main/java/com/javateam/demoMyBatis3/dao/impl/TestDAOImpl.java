package com.javateam.demoMyBatis3.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javateam.demoMyBatis3.dao.TestDAO;
import com.javateam.demoMyBatis3.domain.TestVO;

import lombok.extern.slf4j.Slf4j;

// DAO component(Java Bean, domain)
// DB = 永続貯蔵装置（Persistent Repository）
// @Repository	// ここに代わりにComponentを記入してもいい。
@Repository("testDAO")	// 名前をつけること。
@Slf4j
public class TestDAOImpl implements TestDAO {

	// Spring Bean Container 自動インスタンス(SqlSession)を生成。
	@Autowired	//以下のように宣言だけで良いように成る。
	private SqlSession sqlSession;	// このように宣言だけでいい。
	// private SqlSessionTemplate sqlSession;
	
	@Override
	public TestVO selectTestById(String id) {
		
		log.info("--- TestDAO.selectTestById");
		
		return sqlSession.selectOne("sql_mapper.TestMapper.selectTestById", id);
	}
	
	@Override
	public void insertTest(TestVO testVO) {
		
		sqlSession
			.insert("sql_mapper.TestMapper.insertTest", testVO);
	}
	

}
