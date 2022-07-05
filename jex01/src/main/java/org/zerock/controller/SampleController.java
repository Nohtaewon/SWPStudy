package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//날짜 변환
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping("")
	public void basic() {
		log.info("basic........");
	}
	
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get......");
	}
	
	@RequestMapping("/basicOnlyGet")
	public void basicGet2(){
		log.info("basic get only get.....");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {//자동으로 타입을 변환해서 처리
		log.info(""+dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		//기본자료형이나 문자열 등을 이용한다면 파라미터 타입만을 맞게 선언해주는 방식
		//@RequestParam은 파라미터로 사용된 변수의 이름과 전달되는 파라미터의 이름이 다른경우에 유용하게 사용됨 (이 예제는 아님)
		log.info("name: "+name);
		log.info("age: "+age);
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		//동일한 이름의 파라미터가 여러개 전달되는 경우
		log.info("ids: "+ids);
		return "ex02";
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		//배열의 경우
		log.info("array ids: "+Arrays.toString(ids));
		return "ex02Array";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		//파라미터는  [인덱스] 와 같은 형식으로 전달해서 처리할 수 있다
		log.info("list dtos: "+list);
		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo: "+todo);
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page")int page) {
		//기본자료형의 경우 파라미터로 선언하더라도 기본적으로 화면까지 전달되지는 않는다 int page
		//@ModelAttribute 는 강제로 전달받은 파라미터를 Model에 담아서 전달하도록 할때 필요한 어노테이션이다
		log.info("dto: "+dto);
		log.info("page: "+page);
		return "/sample/ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		//URL경로를 그대로 JSP파일의 이름으로 사용하게 됨
		log.info("/ex05.....");
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06.......");
		SampleDTO dto=new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		//원하는 Http 프로토콜의 헤더 정보나 데이터를 전달할 수 있다
		log.info("/ex07.......");
		//{"name":"홍길동"}
		String msg="{\"name\":\"홍길동\"}";
		
		HttpHeaders header=new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload......");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file->{
			log.info("-----------------------------");
			log.info("name:" +file.getOriginalFilename());
			log.info("size:"+file.getSize());
		});
	}
	
}
