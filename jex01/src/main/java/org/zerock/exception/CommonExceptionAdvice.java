package org.zerock.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

@ControllerAdvice // 해당 객체가 스프링의 컨트롤러 에서 발생하는 예외를 처리하는 존재임을 명시하는 용도
@Log4j
public class CommonExceptionAdvice {

	@ExceptionHandler(Exception.class) //해당 메서드가() 들어가는 예외타입을 처리한다
	public String except(Exception ex, Model model) {
		
		log.error("Exception..........."+ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		return "error_page";
	}
}
