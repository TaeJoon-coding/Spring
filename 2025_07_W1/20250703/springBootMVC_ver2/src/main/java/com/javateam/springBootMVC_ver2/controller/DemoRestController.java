package com.javateam.springBootMVC_ver2.controller;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javateam.springBootMVC_ver2.domain.TestVO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class DemoRestController {

	@GetMapping("rest")
	public String rest() throws JsonProcessingException {
		
		log.info("rest");
		
		//JSON
		TestVO testVO = TestVO.builder()
							  .id("abcd1234")
							  .name("JavaMan")
							  .joindate(Date.valueOf("2025-07-01"))	// 日付の構造を間違えるとホワイトエラー
							  .build();
		
		// VO => JSON(application/json) String
		return new ObjectMapper().writeValueAsString(testVO);
		
		// return "demo";	// 只々、このテキストを出力させてみただけ。
		
	}
	
	
	@GetMapping("rest2")
	public ResponseEntity<TestVO> rest2(HttpServletRequest request, @RequestParam("id") String id){
//	public ResponseEntity<TestVO> rest2(HttpServletRequest request, @RequestParam("id") int id){
		
//		log.info("rest2 servlet id : " + request.getParameter(id));
		log.info("rest2 String id : " + id);
		
		//JSON
		TestVO testVO = TestVO.builder()
							  .id(id+"")
							  .name("JavaMan")
//							  .name("") // 417
//							  .joindate(Date.valueOf("2025-07-02"))	// 日付の構造を間違えるとホワイトエラー
							  .joindate(new Date(System.currentTimeMillis()))	// 実際の加入日を読み込むとき。
							  .build();
		
//		TestVO testVO = null;	// 204
		
		ResponseEntity<TestVO> resEntity = null; // リターン
		
		try {
		
		// 成功(200) /内容ナシ(204)
			if (testVO != null) { // 200
	//			new ResponseEntity<>(testVO, HttpStatus.OK);
				resEntity = new ResponseEntity<>(testVO, HttpStatus.OK);
				
				// 417 (Expectation failed)
				if (testVO.getName().trim().equals("") == true) {
					throw new Exception("이름 필드가 누락되었습니다.");
				}
			} else { //204
				log.info("내용 없음");
//				resEntity = new ResponseEntity<>(testVO, HttpStatus.NO_CONTENT);	// 204
				new ResponseEntity<>(testVO, HttpStatus.NO_CONTENT);
			}
		
		} catch (Exception e) {
			log.error("DemoRestController.rest2 error : " + e.getMessage());
			log.error("DemoRestController.rest2 error : REST サービスエラー");
			
			resEntity = new ResponseEntity<>(testVO, HttpStatus.EXPECTATION_FAILED);	// 417
		}
//		return ResponseEntity.ok(testVO);	// 200番
//		return new ResponseEntity<>(testVO, HttpStatus.OK);
		
		return resEntity;
	}
}
