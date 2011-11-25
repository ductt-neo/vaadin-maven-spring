package com.bpc.service;

import com.bpc.dao.ScoringUserDao;
import com.bpc.model.ScoringUser;
import com.bpc.model.ScoringUserAuthority;
import com.bpc.services.ScoringUserAuthorityServices;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/17/11
 * Time: 3:44 PM
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations={"classpath:spring-services.xml"})
public class ScoringUserAuthoritySerivceTest extends AbstractJUnit4SpringContextTests {
     // specifies the Spring configuration to load for this test fixture
    @Resource(name = "userAuthorityService")
    private ScoringUserAuthorityServices businessObject;

    @Test
    public void testGetUserAuthority()throws SQLException{
        ScoringUser user = businessObject.getUserAuthority("user1");
        System.out.println("UNIT TEST >>>" + user.getAuthorities().get(0).getUserName());
        Assert.assertNotNull(user.getAuthorities().get(0));
    }


}
