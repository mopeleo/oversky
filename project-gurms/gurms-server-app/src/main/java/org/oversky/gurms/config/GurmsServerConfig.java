package org.oversky.gurms.config;

import org.oversky.valid.GSAValidInterceptor;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GurmsServerConfig {
	
	@Bean(name = "paramValidInterceptor")
	public GSAValidInterceptor paramValidInterceptor() {
		return new GSAValidInterceptor();
	}
	
	@Bean
    public BeanNameAutoProxyCreator paramValidProxy() {
        BeanNameAutoProxyCreator autoProxy = new BeanNameAutoProxyCreator();
        autoProxy.setProxyTargetClass(true);// 这个属性为true时，表示被代理的是目标类本身而不是目标类的接口
        autoProxy.setBeanNames("*ServiceImpl");
        autoProxy.setInterceptorNames("paramValidInterceptor");
        return autoProxy;
    }
}
