package com.bpc.dao;

import com.bpc.model.ScoringRule;
import com.bpc.model.ScoringRuleCase;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/21/11
 * Time: 2:24 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ScoringRuleCaseDao extends AbstractDAO<ScoringRuleCase,Integer>{
    public List<ScoringRuleCase> getRuleCaseList(ScoringRule scoringRule);
}
