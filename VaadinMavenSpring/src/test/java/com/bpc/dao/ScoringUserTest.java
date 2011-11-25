package com.bpc.dao;

import com.bpc.model.ScoringUser;
import com.bpc.services.CalculateWebServices;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/17/11
 * Time: 3:44 PM
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations={"classpath:spring-dao.xml"})
public class ScoringUserTest extends AbstractJUnit4SpringContextTests {
     // specifies the Spring configuration to load for this test fixture
    @Autowired
    private ApplicationContext context;
    @Autowired
    private ScoringUserDao scoringUserDao;

    @Test
    public void testGetAllUser()throws SQLException{
        List<ScoringUser> users=scoringUserDao.getAllUsers();
        System.out.println("UNIT TEST >>>"+users.size());
        Assert.assertNotNull(users);
    }

    @Test
    public void testGetUserByName()throws SQLException{
        ScoringUser user=scoringUserDao.getUserByName("user1");
        System.out.println("UNIT TEST >>>"+user.getUserName());
        Assert.assertNotNull(user);
    }
}
