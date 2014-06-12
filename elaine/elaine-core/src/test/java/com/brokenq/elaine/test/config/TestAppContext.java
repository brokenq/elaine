package com.brokenq.elaine.test.config;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.brokenq.elaine.core.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestAppContext {

	@Autowired
	private ApplicationContext ctx;
	
//	private mock
//	
//	@Before
//	public void setup(){
//		
//	}
}
