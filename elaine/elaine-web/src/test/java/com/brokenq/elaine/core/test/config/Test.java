package com.brokenq.elaine.core.test.config;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.brokenq.elaine.web.config.WebConfig;

@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class Test {
	
	/** Spring 扫描基本包 */
	public static final String BASE_PACKAGES = "com.elaine.brokenq";

	public void test(){
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.scan(BASE_PACKAGES);
		ctx.refresh();
	}
}
