package com.spbl.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter{
	@Bean
	public RemoteIpFilter remoteIpFilter() {
		return new RemoteIpFilter();
	}
	
	// This will not active until you register it
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		return new LocaleChangeInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	
	// 添加静态资源链接
	// 我们可以：http://localhost:8080/internal/application.properties
	// 我们可以将css，js设置为静态文件
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/internal/**")
				.addResourceLocations("classpath:/");
	}
	
	
	
	
}
