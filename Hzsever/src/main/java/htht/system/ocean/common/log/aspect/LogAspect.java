package htht.system.ocean.common.log.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

import htht.system.ocean.common.log.annotation.Log;

@Aspect
@Component
public class LogAspect {

	@Pointcut("@annotation(htht.system.ocean.common.log.annotation.Log)")
	public void logPointCut() {
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		// 执行方法
		Object result = point.proceed();
		// 执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;
		// 保存日志
		saveLog(point, time);
		Object[] args = point.getArgs();
		for (Object arg : args) {
			System.out.println(arg);
		}
		return result;
//		return R.error(1000,"这就是一个切面的测试");
	}

	private void saveLog(ProceedingJoinPoint joinPoint, long time) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Log syslog = method.getAnnotation(Log.class);
		// 请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		System.out.println(className + "." + methodName + "()");
		// 请求的参数
		Object[] args = joinPoint.getArgs();
	}
}
