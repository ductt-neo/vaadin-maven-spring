/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bpc.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

/**
 *
 * @author truong_ht
 */
@Entity
@Table(name = "MAPPING_RULE_CASE")
@NamedQueries({
    @NamedQuery(name = "MappingRuleCase.findAll", query = "SELECT m FROM MappingRuleCase m"),
    @NamedQuery(name = "MappingRuleCase.findByMappingRuleCaseId", query = "SELECT m FROM MappingRuleCase m WHERE m.mappingRuleCaseId = :mappingRuleCaseId"),
    @NamedQuery(name = "MappingRuleCase.findByConditionExpression", query = "SELECT m FROM MappingRuleCase m WHERE m.conditionExpression = :conditionExpression"),
    @NamedQuery(name = "MappingRuleCase.findByMappingRule", query = "SELECT m FROM MappingRuleCase m WHERE m.mappingRule = :mapRule")})
public class MappingRuleCase implements EntityBean {

    @Id
    @TableGenerator(name = "MAPPING_RULE_CASE_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", pkColumnValue = "MAPPING_RULE_CASE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MAPPING_RULE_CASE_TABLE_GENERATOR")
    @Basic(optional = false)
    @Column(name = "MAPPING_RULE_CASE_ID")
    private Long mappingRuleCaseId;
    @Basic(optional = false)
    @Column(name = "CONDITION_EXPRESSION")
    private String conditionExpression;
    @JoinColumn(name = "SCORING_RULE_CASE_ID", referencedColumnName = "RULE_CASE_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ScoringRuleCase scoringRuleCase;
    @JoinColumn(name = "MAPPING_RULE_ID", referencedColumnName = "MAPPING_RULE_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MappingRule mappingRule;
    @Transient
    private List<PartialResult> partialResultList;

    public MappingRuleCase() {
    }

    public MappingRuleCase(Long mappingRuleCaseId) {
        this.mappingRuleCaseId = mappingRuleCaseId;
    }

    public MappingRuleCase(Long mappingRuleCaseId, String conditionExpression) {
        this.mappingRuleCaseId = mappingRuleCaseId;
        this.conditionExpression = conditionExpression;
    }

    public Long getMappingRuleCaseId() {
        return mappingRuleCaseId;
    }

    public void setMappingRuleCaseId(Long mappingRuleCaseId) {
        this.mappingRuleCaseId = mappingRuleCaseId;
    }

    public String getConditionExpression() {
        return conditionExpression;
    }

    public void setConditionExpression(String conditionExpression) {
        this.conditionExpression = conditionExpression;
    }

    public ScoringRuleCase getScoringRuleCase() {
        return scoringRuleCase;
    }

    public void setScoringRuleCase(ScoringRuleCase scoringRuleCase) {
        this.scoringRuleCase = scoringRuleCase;
    }

    public MappingRule getMappingRule() {
        return mappingRule;
    }

    public void setMappingRule(MappingRule mappingRule) {
        this.mappingRule = mappingRule;
    }

    public List<PartialResult> getPartialResultList() {
        return partialResultList;
    }

    public void setPartialResultList(List<PartialResult> partialResultList) {
        this.partialResultList = partialResultList;
    }

    @Transient
	public Object getModelId() {
		return getMappingRuleCaseId();
	}

}
