package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
//	private Date dueDate;	initBinder
	//날짜 변환
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date dueDate;
}
