package com.laoluoli.java.activitygrade.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
        logger.info("################URL : " + request.getRequestURL().toString());
        logger.info("################HTTP_METHOD : " + request.getMethod());
        logger.info("################IP : " + request.getRemoteAddr());
        logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));

        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
        logger.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
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