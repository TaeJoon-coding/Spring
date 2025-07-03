package com.javateam.springBootMVC.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TEST_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestEntity {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String  name;
	
	@Column(name="address")
	private String address;
}
