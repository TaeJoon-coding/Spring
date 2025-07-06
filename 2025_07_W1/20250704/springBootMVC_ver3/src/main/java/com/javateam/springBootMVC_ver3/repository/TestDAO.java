package com.javateam.springBootMVC_ver3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javateam.springBootMVC_ver3.domain.TestEntity;

//import org.springframework.stereotype.Repository;
//
//@Repository
//記入しなくてもいい。
public interface TestDAO extends JpaRepository<TestEntity, String> {

	// nameフィールドで(同等)検索してその結果をnameフィールドを基準にして昇順
	// https://arahansa.github.io/docs_spring/jpa.html#jpa.query-methods
	// https://arahansa.github.io/docs_spring/jpa.html#repositories.query-methods.details
	List<TestEntity> findByNameOrderByNameAsc(String name);
	
	// nameフィールドで(like)検索してその結果をnameフィールドを基準にして昇順
	List<TestEntity> findByNameLikeOrderByNameAsc(String name);
	
	List<TestEntity> findByNameContainsOrderByNameAsc(String name);
}
