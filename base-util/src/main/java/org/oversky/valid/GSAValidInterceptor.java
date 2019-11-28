package org.oversky.valid;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.oversky.util.common.CommonUtils;
import org.oversky.valid.GSAValid.FilterType;

public class GSAValidInterceptor implements MethodInterceptor {

	/**
	 * 拦截器，主要用来根据配置自动效验dto
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		if(!GSAValidConfig.enable()) {
			return invocation.proceed();
		}
		
		Method method = invocation.getMethod();
		if(method.isAnnotationPresent(GSAValid.class)){
			GSAValid valid = method.getAnnotation(GSAValid.class);
			
			String clzName = valid.type().getName();
			String[] props = valid.props();
			FilterType filter = valid.filter();

			Object[] args = invocation.getArguments();
			String validMsg = null;
			for(Object arg : args){
				if(valid.type().isInstance(arg)){
					validMsg = GSAValidator.serverValid(clzName, props, filter, arg);
					break;
				}
			}
			
			if(CommonUtils.isNotEmpty(validMsg)){
				throw new GSAValidException(validMsg);
			}
		}
		
		return invocation.proceed();
	}
}
