package com.ashken.config;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan("com.ashken.*")
public class ApplicationContextConfig extends WebMvcConfigurerAdapter {
	
	
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getMultipartResolver()
	{
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20971520);
		multipartResolver.setMaxInMemorySize(1048576);
		return multipartResolver;
	}
	
	@Bean(name="jsonMessageConverter")
	public MappingJackson2HttpMessageConverter getJsonMessageConverter()
	{
		return new MappingJackson2HttpMessageConverter();
	}
		
	@Autowired
	@Bean(name="RequestMappingHandlerAdapter")
	public RequestMappingHandlerAdapter getRequestMappingHandlerAdaptor(MappingJackson2HttpMessageConverter jsoncon )
	{
		ArrayList<HttpMessageConverter<?>> l=new ArrayList<HttpMessageConverter<?>>();
		l.add(jsoncon);
		RequestMappingHandlerAdapter rmha = new RequestMappingHandlerAdapter();
		rmha.setMessageConverters(l);
		return rmha;
	}
	
	///************ ALLOW ACCESS TO STATIC RESOURCES *********************************
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
             
            PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
            resolver.setFallbackPageable(new PageRequest(0, 2));
            resolver.setPageParameterName("page.page");
            resolver.setSizeParameterName("page.size");
            resolver.setOneIndexedParameters(true);
            argumentResolvers.add(resolver);
            
            super.addArgumentResolvers(argumentResolvers);
    }
	

}