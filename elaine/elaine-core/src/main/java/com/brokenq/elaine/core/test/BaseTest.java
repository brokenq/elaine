package com.brokenq.elaine.core.test;

import junit.framework.TestCase;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 集成测试基类
 * @since 2014年6月27日 下午3:28:38
 * @author brokenq
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = false, locations = BaseTest.SPRING_CONF_PATH)
public abstract class BaseTest extends TestCase {

    /** log4j */
    protected static Logger logger = LogManager.getLogger(BaseTest.class);
    
    /** spring配置文件 */
    protected static final String SPRING_CONF_PATH = "classpath*:spring/*.xml";
}
