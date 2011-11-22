package com.bpc.dao;

import com.bpc.model.ScoringRule;
import com.bpc.model.ScoringRuleCase;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/18/11
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScoringRuleDaoImpl
        extends AbstractHibernateDAOImpl<ScoringRule,Integer> implements ScoringRuleDao{

    @Override
    protected Class<ScoringRule> getDomainClass() {
        return ScoringRule.class;
    }



}
