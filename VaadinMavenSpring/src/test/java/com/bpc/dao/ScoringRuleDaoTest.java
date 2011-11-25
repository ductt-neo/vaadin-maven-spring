package com.bpc.dao;

import com.bpc.model.ScoringRule;
import com.bpc.model.ScoringUser;
import org.junit.Assert;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/17/11
 * Time: 3:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScoringRuleDaoTest extends AbstractDependencyInjectionSpringContextTests {
    // specifies the Spring configuration to load for this test fixture
    protected String[] getConfigLocations() {
        return new String[]{"classpath:spring-dataSource.xml", "classpath:spring-dao.xml"};
    }

    private ScoringRuleDao scoringRuleDao;
    private ScoringUserDao scoringUserDao;

    public void setScoringRuleDao(ScoringRuleDao scoringRuleDao) {
        this.scoringRuleDao = scoringRuleDao;
    }

    public void setScoringUserDao(ScoringUserDao scoringUserDao) {
        this.scoringUserDao = scoringUserDao;
    }

    public void testGetList() throws SQLException {
        List<ScoringRule> scoringRuleList = scoringRuleDao.getList();
        System.out.println("Number of Record loaded: " + scoringRuleList.size());

    }

    public void testGetAllUser() throws SQLException {
        List<ScoringUser> users = scoringUserDao.getList();
        System.out.println("UNIT TEST >>>" + users.size());
        Assert.assertNotNull(users);
    }
}
