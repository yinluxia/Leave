package cn.leave.logger;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class LeaveLogger {
	private Logger logger = Logger.getLogger(LeaveLogger.class);

	//前置增强
	public void before(JoinPoint jp) {
		logger.info("调用的是" + jp.getTarget() + "类的方法。方法名是"
				+ jp.getSignature().getName() + "，方法入参是"
				+ Arrays.toString(jp.getArgs()));
	}
	
	//后置增强
	public void afterReturning(JoinPoint jp,Object result){
		logger.info("调用的是" + jp.getTarget() + "类的方法。方法名是"
				+ jp.getSignature().getName() + "，方法返回值是"
				+ result);
	}
	
	//异常抛出增强
	public void afterThrowing(JoinPoint jp,Exception e){
		logger.info("调用的是" + jp.getTarget() + "类的方法。方法名是"
				+ jp.getSignature().getName() + "，方法抛出异常，异常时"
				+ e.getMessage());
	}
	
	//最终增强
	public void after(JoinPoint jp){
		logger.info("调用的是" + jp.getTarget() + "类的方法。方法名是"
				+ jp.getSignature().getName() + "，方法执行完毕。");
	}
}
