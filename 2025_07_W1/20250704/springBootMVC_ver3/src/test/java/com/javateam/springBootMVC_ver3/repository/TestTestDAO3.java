package com.javateam.springBootMVC_ver3.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.javateam.springBootMVC_ver3.domain.TestEntity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@Data
class TestTestDAO3 {

	// 旧式のやり方。
	// private static final Logger log = LoggerFactory.getLogger(TestTestDAO3.class);
	
	@Autowired
	private TestDAO testDAO;	// 自動生成される。
	
	/*
	 * レコードをページング記法で分けて出力
	 *  : ページ当たり、五人分量がレコード出力 => 1ページ出力
	 * */
	@Test
	void test() {
		log.info("ページングテスト");
		
//		log.info("count : " + testDAO.count());  // void testCount()
		// case-1
//		List<TestEntity> list = testDAO.findAll().subList(15, 21);
		
//		list.forEach(null);		// リターン値がない。
//		list.forEach(x -> {log.info(x + ""); });
//		List<TestEntity> list = testDAO.findAll();
		
		
		// case-2
		// Pageable ◁----- AbstractPageRequest 	◁----- PageRequest
		// 自動変換（多型性）
//		Page<TestEntity> pages = testDAO.findAll(new PageRequest(0,5));		// 効率的なのはこれ。	
		
		// 若干古い方式。外では相続が必要。
//		Page<TestEntity> pages = testDAO.findAll(PageRequest.of(0,5));	// page - 1 ~ 5
//		pages.forEach(x -> {log.info(x + ""); });
		
		// case-3 Sorting, ordering : name フィールドヲ基準にして昇順
//		List<TestEntity> list = testDAO.findAll(Sort.by(Direction.ASC, "name"));
		// 昇順
//		list.forEach(x -> {log.info(x + ""); });
		
		// case-4
//		Page<TestEntity> pages = testDAO.findAll(Pageable.ofSize(5));
//		pages.forEach(x -> {log.info(x + ""); });
		
		// case-5 case-3と同様な表現
//		Page<TestEntity> pages = testDAO.findAll(Pageable.unpaged(Sort.by(Direction.ASC, "name")));
//		pages.forEach(x -> {log.info(x + ""); });
		
		// case-6
//		List<TestEntity> list = testDAO.findAll(Example.of(new TestEntity()),
//								 Sort.by(Direction.ASC, "name"));
//		list.forEach(x -> {log.info(x + ""); });
		
		// case-7
		
	}
	
	@Test
	void testFindByNameOrderByNameAsc() {
		log.info("testFindByNameOrderByNameAsc test");
		
		List<TestEntity> list = testDAO.findByNameOrderByNameAsc("임승인");
		//log.info("tentity : " + list.get(0));
		list.forEach(x -> {log.info(x + ""); });
	}
	
	@Test
	void testfindByNameLikeOrderByNameAsc() {
		log.info("testfindByNameLikeOrderByNameAsc test");
		
		List<TestEntity> list = testDAO.findByNameLikeOrderByNameAsc("임%");
		list.forEach(x -> {log.info(x + ""); });
	}
	
	@Test
	void findByNameContainsOrderByNameAsc() {
		log.info("findByNameContainsOrderByNameAsc  tet");
		
		List<TestEntity> list = testDAO.findByNameContainsOrderByNameAsc("임");	// 自動「%」処理
		list.forEach(x -> {log.info(x + ""); });
		
		// 境界値
	}
}
