package com.bpc.dao;

import com.bpc.model.MappingRule;
import com.bpc.model.ScoringRule;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/22/11
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MappingRuleDao extends AbstractDAO<MappingRule,Long>{
    public List getMappingRuleList(ScoringRule scoringRule);
}
