package com.brokenq.elaine.core.test.config;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class Test {
	
	/** Spring 扫描基本包 */
	public static final String BASE_PACKAGES = "com.elaine.brokenq";

	public void test(){
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.scan(BASE_PACKAGES);
		ctx.refresh();
	}
}
