package com.javateam.demoMyBatis3.mapper;

import org.apache.ibatis.annotations.Insert;
//「annotations」から相続された物々
import org.apache.ibatis.annotations.Mapper;	
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.javateam.demoMyBatis3.domain.TestVO;

@Mapper
public interface TestMapper {

	@Select("SELECT * FROM test_tbl WHERE id = #{id}")
	TestVO selectTestById(@Param("id") String id);
	
	@Insert("INSERT INTO test_tbl (id, name, address)" 
				+ "VALUES (#{testVO.id}, #{testVO.name}, #{testVO.address})")
	void insertTest(@Param("testVO") TestVO testVO);
	
	@Insert("INSERT INTO test_tbl (id, name, address)" 
				+ "VALUES (#{id}, #{name}, #{address})")
	void insertTest2(TestVO testVO);
}
