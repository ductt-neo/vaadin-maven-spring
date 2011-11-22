package com.bpc.utils;

import com.bpc.model.MappingRule;
import com.bpc.model.ScoringRule;

import com.bpc.model.ScoringRuleCase;
import com.bpc.services.ScoringRuleServices;
import com.vaadin.data.util.BeanItemContainer;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/18/11
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScoringRuleController {

    private ScoringRuleServices scoringRuleServices;

    public void setScoringRuleServices(ScoringRuleServices scoringRuleServices) {
        this.scoringRuleServices = scoringRuleServices;
    }

    public BeanItemContainer<ScoringRule> getScoringRuleBeanItemContainer() {
        List<ScoringRule> scoringRuleList = this.scoringRuleServices.getAll();
        BeanItemContainer<ScoringRule> beanItemContainer =
                new BeanItemContainer<ScoringRule>(ScoringRule.class, scoringRuleList);
        beanItemContainer.sort(new Object[]{FieldNameUtils.scoringRuleFieldName}, new boolean[]{true});
        return beanItemContainer;
    }

    public BeanItemContainer<ScoringRuleCase> getRuleCaseBeanItemContainer(ScoringRule scoringRule) {
        List<ScoringRuleCase> ruleCaseList = this.scoringRuleServices.getRuleCaseList(scoringRule);
        BeanItemContainer<ScoringRuleCase> beanItemContainer =
                new BeanItemContainer<ScoringRuleCase>(ScoringRuleCase.class, ruleCaseList);
        beanItemContainer.sort(FieldNameUtils.ruleCaseFieldName,new boolean[]{true});
        return beanItemContainer;
    }

    public BeanItemContainer<MappingRule> getMappingRuleBeanItemContainer(ScoringRule scoringRule){
        List<MappingRule> mappingRuleList = this.scoringRuleServices.getMappingRuleList(scoringRule);
        BeanItemContainer<MappingRule> beanItemContainer =
                new BeanItemContainer<MappingRule>(MappingRule.class, mappingRuleList);
        beanItemContainer.sort(FieldNameUtils.mappingRuleFieldName,new boolean[]{true});
        return beanItemContainer;
    }
}
