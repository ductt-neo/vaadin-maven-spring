package com.bpc.utils;

import java.util.List;

import com.bpc.dao.ScoringSchemeDao;
import com.bpc.model.Factor;
import com.bpc.model.MappingRule;
import com.bpc.model.ScoringRule;
import com.bpc.model.ScoringRuleCase;
import com.bpc.model.ScoringScheme;
import com.bpc.services.ScoringRuleServices;
import com.vaadin.data.util.BeanItemContainer;

/**
 * Created by IntelliJ IDEA. User: do_th Date: 11/18/11 Time: 4:15 PM To change
 * this template use File | Settings | File Templates.
 */
public class ScoringRuleController {

   private ScoringRuleServices scoringRuleServices;
   private ScoringSchemeDao scoringSchemeDao;

   public void setScoringRuleServices(ScoringRuleServices scoringRuleServices) {
      this.scoringRuleServices = scoringRuleServices;
   }

   public BeanItemContainer<ScoringRule> getScoringRuleBeanItemContainer() {
      List<ScoringRule> scoringRuleList = this.scoringRuleServices.getAll();
      BeanItemContainer<ScoringRule> beanItemContainer = new BeanItemContainer<ScoringRule>(ScoringRule.class,
            scoringRuleList);
      beanItemContainer.sort(new Object[] { FieldNameUtils.scoringRuleFieldName }, new boolean[] { true });
      return beanItemContainer;
   }

   public BeanItemContainer<ScoringRuleCase> getRuleCaseBeanItemContainer(ScoringRule scoringRule) {
      List<ScoringRuleCase> ruleCaseList = this.scoringRuleServices.getRuleCaseList(scoringRule);
      // List<ScoringRuleCase> ruleCaseList = scoringRule.getRuleCases();
      BeanItemContainer<ScoringRuleCase> beanItemContainer = new BeanItemContainer<ScoringRuleCase>(
            ScoringRuleCase.class, ruleCaseList);
      beanItemContainer.sort(FieldNameUtils.ruleCaseFieldName, new boolean[] { true });
      return beanItemContainer;
   }

   public BeanItemContainer<MappingRule> getMappingRuleBeanItemContainer(ScoringRule scoringRule) {
      List<MappingRule> mappingRuleList = this.scoringRuleServices.getMappingRuleList(scoringRule);
      // List<MappingRule> mappingRuleList = scoringRule.getMappingRuleList();
      BeanItemContainer<MappingRule> beanItemContainer = new BeanItemContainer<MappingRule>(MappingRule.class,
            mappingRuleList);
      beanItemContainer.sort(FieldNameUtils.mappingRuleFieldName, new boolean[] { true });
      return beanItemContainer;
   }

   public BeanItemContainer<Factor> getFactors() {
      List<Factor> factors = this.scoringRuleServices.getFactors();
      BeanItemContainer<Factor> beans = new BeanItemContainer<Factor>(Factor.class, factors);
      return beans;
   }

   public BeanItemContainer<ScoringScheme> getSchemes() {
      List<ScoringScheme> schemes = scoringSchemeDao.findAll();
      BeanItemContainer<ScoringScheme> beans = new BeanItemContainer<ScoringScheme>(ScoringScheme.class, schemes);
      return beans;
   }

   public void setScoringSchemeDao(ScoringSchemeDao scoringSchemeDao) {
      this.scoringSchemeDao = scoringSchemeDao;
   }

}
