package com.javateam.springBootMVC_ver2.domain;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class TestVO2 {
	
	private String id;
	private String name;
	private String address;

}