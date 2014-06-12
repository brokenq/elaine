package com.brokenq.elaine.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 数据源配置
 * @since 2014年6月12日 下午4:56:22
 * @author brokenq
 */
@Configuration
public class DataSourceConfig {

	@Bean
	public DruidDataSource dataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		
		return dataSource;
	}
}
