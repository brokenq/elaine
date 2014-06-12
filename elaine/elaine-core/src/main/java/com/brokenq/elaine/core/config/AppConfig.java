package com.brokenq.elaine.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 全局应用配置
 * @since 2014年6月12日 下午4:03:08
 * @author brokenq
 */
@Configuration
public class AppConfig {

//	@Bean
//	public PropertyPlaceholderConfigurer properties(){
//		PropertyPlaceholderConfigurer properties = new PropertyPlaceholderConfigurer();
////		properties.setLocations(new Resource[]{"classpath:conf/*.properties"});
//		properties.setLocations(locations);
//		return properties;
//	}
	
	/**
	 * 异常解析器
	 * @since 2014年6月12日 下午4:47:05
	 * @author brokenq
	 */
	public void exceptionResolver(){
//		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
//		Properties properties = new Properties();
//		properties.setProperty("", "");
//		resolver.setExceptionMappings(properties);
	}
	
	/**
	 * 文件上传解析器
	 * @return
	 * @since 2014年6月12日 下午4:49:39
	 * @author brokenq
	 */
	@Bean
	public CommonsMultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(2 * 1024 * 1024);
		return multipartResolver;
	}
	
	/**
	 * JdbcTemplate配置
	 * @param dataSource 数据源
	 * @return
	 * @since 2014年6月12日 下午4:58:35
	 * @author brokenq
	 */
	@Bean
	@Autowired
	public NamedParameterJdbcTemplate jdbcTemplate(DruidDataSource dataSource){
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	/**
	 * 事务管理配置
	 * @param dataSource 数据源
	 * @return
	 * @since 2014年6月12日 下午5:00:53
	 * @author brokenq
	 */
	@Bean
	@Autowired
	public DataSourceTransactionManager transactionManager(DruidDataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}
}
