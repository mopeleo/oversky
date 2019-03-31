package org.oversky.gurms.web.config;

import org.oversky.gurms.web.filter.JwtAuthTokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Filter 统一配置管理
 * 可以通过 @WebFilter 注解来配置，但使用 @Order 指定顺序时无效
 * 在spring boot中使用Filter和HandlerIntercepter中对于相同路径匹配写法有差别,
 * 如路径/api/v1/service1,在Filter中可以使用/api/*,但在HandlerIntercepter注册时需要写成/api/** 
 * @author Blue
 *
 */
@Configuration
public class WebMvcConfiguration {
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);   
	    config.addAllowedOrigin("http://127.0.0.1:8088");
	    config.addAllowedOrigin("http://localhost:8088");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    source.registerCorsConfiguration("/**", config); // CORS 配置对所有接口都有效
	    FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
	    bean.setOrder(0);
	    return bean;
	}
	
//	@Bean
    public FilterRegistrationBean<JwtAuthTokenFilter> authFilter() {
        FilterRegistrationBean<JwtAuthTokenFilter> registration = new FilterRegistrationBean<>();
        //注入过滤器
        registration.setFilter(new JwtAuthTokenFilter());
        //拦截规则
        registration.addUrlPatterns("/*");
        registration.addInitParameter("excludeUrls", "login,validcode");
        //过滤器名称
        registration.setName("jwtAuthTokenFilter");
        //过滤器顺序
        registration.setOrder(1);
        return registration;
    }
	
}
