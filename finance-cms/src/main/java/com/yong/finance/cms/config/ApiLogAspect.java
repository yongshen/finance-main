package com.yong.finance.cms.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by sgy on 2017/7/30.
 */
@Aspect
@Order(5)
@Component
public class ApiLogAspect {

    protected Logger _logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.yong.finance.cms.controller..*.*(..))")
    public void webLog(){}

  /*  @Around("webLog()")
    public Object monitorElapsedTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        // Log the elapsed time
        double elapsedTime = stopWatch.getTime() / 1000.0;
        Signature signature = proceedingJoinPoint.getSignature();
        String infoString = signature.toShortString() + "  -> " + elapsedTime + " s";
        if (elapsedTime > 1) {
            _logger.warn("[耗时过长!!!]" + infoString);
        } else {
            _logger.info(infoString);
        }
        return result;
    }*/

//    @Before("webLog()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        startTime.set(System.currentTimeMillis());
//
//        // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        // 记录下请求内容
////        logger.info("URL : " + request.getRequestURL().toString());
////        logger.info("HTTP_METHOD : " + request.getMethod());
////        logger.info("IP : " + request.getRemoteAddr());
////        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
////        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
//    }
//
//    @AfterReturning(returning = "ret", pointcut = "webLog()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        // 处理完请求，返回内容
////        logger.info("RESPONSE : " + ret);
////        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
//    }


}
