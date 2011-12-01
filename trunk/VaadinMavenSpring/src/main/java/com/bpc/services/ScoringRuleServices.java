package com.bpc.services;

import java.util.List;

import com.bpc.model.Factor;
import com.bpc.model.MappingRule;
import com.bpc.model.ScoringRule;
import com.bpc.model.ScoringRuleCase;

/**
 * Created by IntelliJ IDEA. User: do_th Date: 11/18/11 Time: 3:59 PM To change
 * this template use File | Settings | File Templates.
 */
public interface ScoringRuleServices {
   public List<ScoringRule> getAll();

   public List<ScoringRuleCase> getRuleCaseList(ScoringRule scoringRule);

   public List<MappingRule> getMappingRuleList(ScoringRule scoringRule);

   public List<Factor> getFactors();
}
