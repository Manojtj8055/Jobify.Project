package com.xworkz.jobify.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.jobify")
@EnableWebMvc
public class BeanConfig implements WebMvcConfigurer {

	public BeanConfig() {
		System.out.println("Bean Created ");
	}

	@Bean
	public ViewResolver viewResolver() {
		System.out.println("Bean Created ViewResolver");
		return new InternalResourceViewResolver("/", ".jsp");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		System.out.println("Bean Created addViewControllers");
		registry.addRedirectViewController("/", "Registers.jsp");

	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub

		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("Bean Created addResourceHandlers ");
		registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/fonts/");
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
		registry.addResourceHandler("/vendor/**").addResourceLocations("classpath:/vendor/");

	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multiPartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		return resolver;
	}
}
