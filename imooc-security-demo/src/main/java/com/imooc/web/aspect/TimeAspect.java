/**
 * 
 */
package com.imooc.web.aspect;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
/**
 * @author linhaifeng1
 *
 */
import org.springframework.stereotype.Component;
//@Aspect
//@Component
public class TimeAspect {
	
	@Around("execution(* com.imooc.web.controller.UserController.*(..))") //User Controller 任何方法 任何参数
	//Spring framework reference 11 章 declare point cut
	public Object handlerControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("time aspect start");
		
		Object[] args = pjp.getArgs();
		
		for(Object arg : args) {
			System.out.println("arg is " + arg);
		}
		
		long start = new Date().getTime();
		
		Object object = pjp.proceed();//调用被拦截的方法
		
		System.out.println("Time aspect 耗时:" + (new Date().getTime() - start));
		System.out.println("time aspect end");
		
		return object;
	}
	
}
