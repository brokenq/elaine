package com.brokenq.elaine.web.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.brokenq.elaine.core.config.AppConfig;
import com.brokenq.elaine.web.handler.AuthHandler;

/**
 * 
 * @since 2014年6月12日 上午11:17:49
 * @author brokenq
 */
@Configuration
@EnableWebMvc
@Import(AppConfig.class)
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("locale");
		registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
		registry.addInterceptor(new AuthHandler()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		int cachePeriod = 0;
		registry.addResourceHandler("/favicon.ico").addResourceLocations("/common/images/favicon.ico").setCachePeriod(cachePeriod);
		registry.addResourceHandler("/ui/**").addResourceLocations("/ui/").setCachePeriod(cachePeriod);
		registry.addResourceHandler("/common/**").addResourceLocations("/common/").setCachePeriod(cachePeriod);
		registry.addResourceHandler("/file/**").addResourceLocations("/file/").setCachePeriod(cachePeriod);
		registry.addResourceHandler("/main/**").addResourceLocations("/main/").setCachePeriod(cachePeriod);
		registry.addResourceHandler("/web/**").addResourceLocations("/web/").setCachePeriod(cachePeriod);
		super.addResourceHandlers(registry);
	}

	/**
	 * 视图分析器
	 * @return
	 * @since 2014年6月12日 下午1:09:12
	 * @author brokenq
	 */
	@Bean
	public UrlBasedViewResolver viewResolver(){
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	/**
	 * 国际化资源配置
	 * @return
	 * @since 2014年6月12日 上午11:39:17
	 * @author brokenq
	 */
	@Bean
	public ReloadableResourceBundleMessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:il8n/message");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	/**
	 * 国际化资源分析器
	 * @return
	 * @since 2014年6月12日 下午1:18:30
	 * @author brokenq
	 */
	public SessionLocaleResolver localeResolver(){
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
		return localeResolver;
	}
}
