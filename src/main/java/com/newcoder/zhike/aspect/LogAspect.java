package com.newcoder.zhike.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;


@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

//    @Before("execution(* com.newcoder.zhike.controller.*Controller.*(..))")
//    public void beforeMethod(JoinPoint joinPoint) {
//        StringBuilder sb = new StringBuilder();
//        for (Object org : joinPoint.getArgs()) {
//            sb.append("arg: " + org.toString() + "|");
//        }
//        logger.info("before method" + sb.toString());
//
//    }
//
//    @After("execution(* com.newcoder.zhike.controller.IndexController.*(..))")
//    public void afterMethod() {
//        logger.info("after method" + new Date());
//    }
}
