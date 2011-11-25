package com.bpc.dao;

import com.bpc.model.ScoringUser;
import com.bpc.model.ScoringUserAuthority;
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
public class ScoringUserAuthorityTest extends AbstractJUnit4SpringContextTests {
     // specifies the Spring configuration to load for this test fixture
    @Autowired
    private ApplicationContext context;
    @Autowired
    private ScoringUserAuthorityDao scoringUserAuthorityDao;

    @Test
    public void testGetAllUser()throws SQLException{
        List<ScoringUserAuthority> userAuthorities=scoringUserAuthorityDao.getAllUserAuthorities();
        System.out.println("UNIT TEST >>>" +userAuthorities.size());
        Assert.assertNotNull(userAuthorities);
    }

}
