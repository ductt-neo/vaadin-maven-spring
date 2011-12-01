package com.bpc.dao;

import com.bpc.model.ScoringRule;
import com.bpc.services.CalculateWebServices;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/17/11
 * Time: 3:44 PM
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations={"classpath:client-spring-context.xml"})
public class CalculateWebServicesTest extends AbstractJUnit4SpringContextTests {
     // specifies the Spring configuration to load for this test fixture
    @Autowired
    private ApplicationContext context;

    @Test
    public void testCalculate()throws SQLException{
        CalculateWebServices client = (CalculateWebServices) context.getBean("client");
        double result= client.addCalc(5,6);
        Assert.assertEquals(11.0, result, 0);
    }
}
