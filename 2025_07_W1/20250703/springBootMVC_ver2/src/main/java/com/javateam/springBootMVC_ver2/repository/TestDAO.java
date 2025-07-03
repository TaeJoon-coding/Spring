package com.javateam.springBootMVC_ver2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javateam.springBootMVC_ver2.domain.TestEntity;

//import org.springframework.stereotype.Repository;
//
//@Repository
//記入しなくてもいい。
public interface TestDAO extends JpaRepository<TestEntity, String> {

}
