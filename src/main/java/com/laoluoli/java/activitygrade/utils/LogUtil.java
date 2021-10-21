package com.laoluoli.java.activitygrade.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@Aspect
public class LogUtil {

    private final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    /**
     * 切入点配置
     */
    @Pointcut(value = "execution(* com.laoluoli.java.activitygrade.controller..*.*(..))")
    public void pointCutOne() {
    }

    /**
     * 前置通知
     *
     * @param joinPoint
     */
    @Before(value = "pointCutOne()")
    public void beforeSaveLog(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        // 记录下请求内容
        StringBuilder sb = new StringBuilder();
        sb.append("URL :").append(request.getRequestURL().toString())
                .append(" ,HTTP_METHOD : ").append(request.getMethod())
                .append(",IP : ").append(request.getRemoteAddr())
                .append(",THE ARGS OF THE CONTROLLER :  ").append(Arrays.toString(joinPoint.getArgs()))
                .append("CLASS_METHOD : ")
                .append(joinPoint.getSignature().getDeclaringTypeName()).append(".").append(joinPoint.getSignature());
        logger.info(sb.toString());
    }

//    /**
//     * 后置通知
//     *
//     * @param joinPoint
//     */
//    @After(value = "pointCutOne()")
//    public void afterReturningSaveLog(JoinPoint joinPoint) {
//        System.out.println("在调用" + joinPoint.getSignature().getName() + "方法之后，打印。。。");
//    }
//
//
//    /**
//     * 最终通知
//     */
//    @AfterReturning(value = "pointCutOne()")
//    public void afterSaveLog(JoinPoint joinPoint) {
//        System.out.println("在调用" + joinPoint.getSignature().getName() + "方法时，无论有没有异常都会打印。。。");
//    }
//
//    /**
//     * 环绕通知
//     */
//    public Object aroundSaveLog(ProceedingJoinPoint proceedingJoinPoint) {
//        Object proceed = null;
//        System.out.println(System.currentTimeMillis() + "执行业务方法之前---");
//        try {
//            proceed = proceedingJoinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        System.out.println(System.currentTimeMillis() + "执行业务方法之后---");
//        return proceed;
//    }

    /**
     * 异常通知
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "pointCutOne()", throwing = "e")
    public void afterThrowingSaveLog(JoinPoint joinPoint, Exception e) {
        logger.info("在调用" + joinPoint.getSignature().getName() + "方法时出现了" + e.getClass().getName() + "异常，异常描述：" + e.getMessage());
    }
}