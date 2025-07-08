package com.javateam.demoMyBatis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 基本的にはこれらがあっても POJO()
// POJO : plain old java object
// EJB2の時期、XMLが多い過ぎて、コードを短縮するために、エンタープライズ何とかの代わりに。
// 一旦、自動完成のために。
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder	// これを使うには「@AllArgsConstructor」が必要

// が、使いすぎると、getter(主に)/setter（主にVoid）やその他を手書きにできなくなる。
public class TestVO {
	
	private String id;
	private String name;
	private String address;

}
