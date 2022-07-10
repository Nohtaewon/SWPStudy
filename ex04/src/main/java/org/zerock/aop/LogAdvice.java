package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect		// 해당 클래스의 객체가 Aspect를 구현한 것
@Log4j
@Component
public class LogAdvice {
	//execution 은 접근제한자와 특정클래스의 메서드를 지정할 수 있다.
	@Before("execution(* org.zerock.service.SampleService*.*(..))")		//AspectJ의 표현식
	public void logBefore() {
		log.info("================================");
	}
	
	@Before("execution(* org.zerock.service.SampleService*.doAdd(String, String))&&args(str1, str2)")		
	public void logBeforeWithParam(String str1, String str2) {
		log.info("str1: "+str1);
		log.info("str2: "+str2);
	}
	// 지정한 대상이 예외를 발생한 후 동작하면서 문제를 찾을 수 있게 도와줌
	@AfterThrowing(pointcut="execution(* org.zerock.service.SampleService*.*(..))", throwing="exception")
	public void logException(Exception exception) {
		log.info("Exception.......................!");
		log.info("exception: "+exception);
	}
	// ProceedingJoinPoint 는 @Around와 결합해서 파라미터나 예외 등을 처리 할 수 있다
	// ProceedingJoinPoint 는 대상이되는 Target이나 파라미터등을 파악하고 직접실행을 결정할 수도 있다
	// @Around는 void가 아닌 타입 설정
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start=System.currentTimeMillis();
		
		log.info("Target: "+pjp.getTarget());
		log.info("Param: "+Arrays.toString(pjp.getArgs()));
		
		//invoke method
		Object result=null;
		
		try {
			result=pjp.proceed();
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		long end=System.currentTimeMillis();
		
		log.info("TIME: "+(end - start));
		
		return result;
	}
}
