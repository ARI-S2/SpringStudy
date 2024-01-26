package com.sist.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
/*
 * AOP : 공통 모듈(공통으로 사용되는 소스를 모아서 관리)
 * 		 유지보수, 재사용
 * 		 => OOP에서 불가능한 것을 추가해서 보완
 * 		    ============ 자동 호출(Callback) => 불가능
 * 		 => Callback => 원하는 위치를 지정하면 호출이 가능
 * 						=========
 * 						1. 메소드 지정 (지정된 메소드 => Target) => 어떤 메소드?
 * 						2. 메소드의 위치 (JoinPoint 5가지) => 메소드의 어느 부분?
 * 						   public void display(){
 * 						   		@Before
 * 								try{
 * 								    => 로그 파일(걸리는 시간~)
 * 									=> 트랜잭션
 * 									=============== @Around
 * 									핵심
 * 									=============== @Around
 * 								}catch(){
 * 									@AfterThrowing
 * 									=> @ControllerAdvice
 * 								}finally{
 									@After
 * 								}
 * 								return @AfterReturning
 * 							}
 * 						PointCut+JoinPoint => Advice
 * 						Advice가 여러개 => 공통모듈(Aspect)
 * 	=> pointCut : 어떤 메소드
 * 	=> JoinPoint :메소드 호출 위치
 * 	=> Weaving : 묶어준다(조립)
 * 	=> Target : 대상 메소드
 * 	=> Proxy : 조립된 메소드 (대리자)
 * 	=> Advice : 공통 모듈 단위
 *  => Aspect : 공통 모듈
 *  
 *  
 *   */
@ControllerAdvice // 예외 처리
public class CommonsException {

}
