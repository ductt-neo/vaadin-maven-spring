package com.bpc.utils;

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

    public static final Object SCORING_RULE_PROPERTIES_ID = "id";
    public static final Object SCORING_RULE_PROPERTIES_WEIGHT = "weight";
    public static final Object SCORING_RULE_PROPERTIES_SCHEME = "scheme";
    public static final Object SCORING_RULE_PROPERTIES_FACTOR = "factor";
    public static final Object SCORING_RULE_PROPERTIES_REQUIRED = "required";

    public static String[] ruleCaseFieldName = null;

    private ScoringRuleServices scoringRuleServices;

    static {
        ruleCaseFieldName = ClassFieldNameUtils.getFieldNames(ScoringRuleCase.class);
    }

    public void setScoringRuleServices(ScoringRuleServices scoringRuleServices) {
        this.scoringRuleServices = scoringRuleServices;
    }

    public BeanItemContainer<ScoringRule> getScoringRuleBeanItemContainer() {
        List<ScoringRule> scoringRuleList = this.scoringRuleServices.getAll();
        BeanItemContainer<ScoringRule> beanItemContainer =
                new BeanItemContainer<ScoringRule>(ScoringRule.class, scoringRuleList);
        beanItemContainer.sort(new Object[]{SCORING_RULE_PROPERTIES_ID}, new boolean[]{true});
        return beanItemContainer;
    }

    public BeanItemContainer<ScoringRuleCase> getRuleCaseBeanItemContainer(ScoringRule scoringRule) {
        List<ScoringRuleCase> ruleCaseList = this.scoringRuleServices.getRuleCaseList(scoringRule);
        BeanItemContainer<ScoringRuleCase> beanItemContainer =
                new BeanItemContainer<ScoringRuleCase>(ScoringRuleCase.class, ruleCaseList);
        beanItemContainer.sort(ruleCaseFieldName,new boolean[]{true});
        return beanItemContainer;
    }
}
