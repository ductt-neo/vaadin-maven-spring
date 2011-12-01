package com.bpc.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

/**
 * @author do_th
 */
@Entity
@Table(name = "SCORING_RULE")
@NamedQueries({ @NamedQuery(name = "ScoringRule.findAll", query = "SELECT s FROM ScoringRule s"),
      @NamedQuery(name = "ScoringRule.findByRuleId", query = "SELECT s FROM ScoringRule s WHERE s.id = :ruleId"),
      @NamedQuery(name = "ScoringRule.findByWeight", query = "SELECT s FROM ScoringRule s WHERE s.weight = :weight") })
public class ScoringRule implements EntityBean {

   private Long id;

   private BigDecimal weight;

   private ScoringScheme scheme;

   private Factor factor;

   private Character required;

   private List<ScoringRuleCase> ruleCases;

   private List<MappingRule> mappingRuleList;

   public ScoringRule() {
   }

   public ScoringRule(Long id) {
      this.id = id;
   }

   @TableGenerator(name = "RULE_TABLE_GENERATOR",

   table = "SEQUENCE_GENERATOR_TABLE", pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", pkColumnValue = "RULE_SEQUENCE")
   @Id
   @GeneratedValue(strategy = GenerationType.TABLE, generator = "RULE_TABLE_GENERATOR")
   @Column(name = "RULE_ID")
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   @JoinColumn(name = "SCHEME_ID", referencedColumnName = "SCHEME_ID")
   @ManyToOne(optional = false, fetch = FetchType.EAGER)
   public ScoringScheme getScheme() {
      return scheme;
   }

   public void setScheme(ScoringScheme scheme) {
      this.scheme = scheme;
   }

   @JoinColumn(name = "FACTOR_ID", referencedColumnName = "FACTOR_ID")
   @ManyToOne(optional = false, fetch = FetchType.EAGER)
   public Factor getFactor() {
      return factor;
   }

   public void setFactor(Factor factor) {
      this.factor = factor;
   }

   public void setRuleCases(List<ScoringRuleCase> ruleCases) {
      this.ruleCases = ruleCases;
   }

   @Transient
   public List<ScoringRuleCase> getRuleCases() {
      return ruleCases;
   }

   public BigDecimal getWeight() {
      if (weight == null) weight = BigDecimal.valueOf(0.0);
      return weight;
   }

   @Column(name = "REQUIRED")
   public Character getRequired() {
      return required;
   }

   public void setRequired(Character required) {
      this.required = required;
   }

   @Transient
   public Object getModelId() {
      return getId();
   }

   public void setWeight(BigDecimal weight) {
      this.weight = weight;
   }

   @Transient
   public List<MappingRule> getMappingRuleList() {
      return mappingRuleList;
   }

   public void setMappingRuleList(List<MappingRule> mappingRuleList) {
      this.mappingRuleList = mappingRuleList;
   }

   @Override
   public String toString() {
      return id.toString()+" : "+ scheme.getName();
   }

}
