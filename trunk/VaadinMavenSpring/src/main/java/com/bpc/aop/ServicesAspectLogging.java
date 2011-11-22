package com.bpc.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/22/11
 * Time: 9:25 AM
 * To change this template use File | Settings | File Templates.
 */
@Aspect
public class ServicesAspectLogging {
    private static final Logger logger = Logger.getLogger(ServicesAspectLogging.class);
    @Around("execution(* com.bpc.services.*.*(..))")
    public Object aroundLogging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().getName();
        String serviceName = proceedingJoinPoint.getTarget().toString()+"."+method;
        logger.info("Before call service:" + serviceName);
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            logger.info("After call service: " + serviceName);
        }
    }
}
