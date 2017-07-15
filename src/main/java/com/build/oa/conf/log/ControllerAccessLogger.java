package com.build.oa.conf.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by xzhang on 7/15/2017.
 */
@Aspect
@Component
public class ControllerAccessLogger {

    final private static Logger logger = LoggerFactory.getLogger(ControllerAccessLogger.class);


    @Pointcut("execution(public * com.build.oa.web..*.*(..))")
    public void webLog() {}

    @Before("webLog()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("URL :" + request.getRequestURL());
        logger.info("HTTP_METHOD :" + request.getMethod());
        logger.info("IP :" + request.getRemoteAddr());
        logger.info("CLASS_METHOD  :" + joinPoint.getSignature().getDeclaringType());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }


    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void afterReturning(Object ret){
        logger.info("RESPONSE_TYPE:" +ret.getClass());
        logger.info("RESPONSE_OBJECT:" +ret.toString());
    }


}
