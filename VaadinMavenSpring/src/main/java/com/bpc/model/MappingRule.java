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
@Table(name = "MAPPING_RULE")
@NamedQueries({
    @NamedQuery(name = "MappingRule.findAll", query = "SELECT m FROM MappingRule m"),
    @NamedQuery(name = "MappingRule.findByMappingRuleId", query = "SELECT m FROM MappingRule m WHERE m.mappingRuleId = :mappingRuleId"),
    @NamedQuery(name = "MappingRule.findByMappingScheme", query = "SELECT m FROM MappingRule m WHERE m.mappingScheme = :mapScheme")})
public class MappingRule implements EntityBean {

    @Id
    @TableGenerator(name = "MAPPING_RULE_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", pkColumnValue = "MAPPING_RULE_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MAPPING_RULE_TABLE_GENERATOR")
    @Basic(optional = false)
    @Column(name = "MAPPING_RULE_ID")
    private Long mappingRuleId;
	@Transient
    private List<MappingRuleCase> mappingRuleCaseList;
    @JoinColumn(name = "SCORING_RULE_ID", referencedColumnName = "RULE_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ScoringRule scoringRule;
    @JoinColumn(name = "MAPPING_SCHEME_ID", referencedColumnName = "MAPPING_SCHEME_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MappingScheme mappingScheme;

    public MappingRule() {
    }

    public MappingRule(Long mappingRuleId) {
        this.mappingRuleId = mappingRuleId;
    }

    public Long getMappingRuleId() {
        return mappingRuleId;
    }

    public void setMappingRuleId(Long mappingRuleId) {
        this.mappingRuleId = mappingRuleId;
    }

    public List<MappingRuleCase> getMappingRuleCaseList() {
        return mappingRuleCaseList;
    }

    public void setMappingRuleCaseList(List<MappingRuleCase> mappingRuleCaseList) {
        this.mappingRuleCaseList = mappingRuleCaseList;
    }

    public ScoringRule getScoringRule() {
        return scoringRule;
    }

    public void setScoringRule(ScoringRule scoringRule) {
        this.scoringRule = scoringRule;
    }

    public MappingScheme getMappingScheme() {
        return mappingScheme;
    }

    public void setMappingScheme(MappingScheme mappingScheme) {
        this.mappingScheme = mappingScheme;
    }

    @Transient
	public Object getModelId() {
		return getMappingRuleId();
	}

    public String toString(){
        return this.mappingRuleId.toString();
    }

}
