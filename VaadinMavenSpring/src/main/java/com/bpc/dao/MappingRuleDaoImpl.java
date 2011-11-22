package com.bpc.dao;

import com.bpc.model.MappingRule;
import com.bpc.model.ScoringRule;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/22/11
 * Time: 3:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class MappingRuleDaoImpl extends AbstractHibernateDAOImpl<MappingRule,Long>
                    implements MappingRuleDao{
    @Override
    protected Class<MappingRule> getDomainClass() {
        return MappingRule.class;
    }

    public List<MappingRule> getMappingRuleList(ScoringRule scoringRule) {
        return getHibernateTemplate().find("SELECT s FROM MappingRule s WHERE s.scoringRule = ?",scoringRule);
    }
}
