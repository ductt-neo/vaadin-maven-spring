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
* @author do_th
*/

@Entity
@Table(name = "SCORING_RULE_CASE")
@NamedQueries({
		@NamedQuery(name = "ScoringRuleCase.findAll", query = "SELECT s FROM ScoringRuleCase s"),
		@NamedQuery(name = "ScoringRuleCase.findByRuleCaseId", query = "SELECT s FROM ScoringRuleCase s WHERE s.id = :ruleCaseId"),
		@NamedQuery(name = "ScoringRuleCase.findByFactorChoice", query = "SELECT s FROM ScoringRuleCase s WHERE s.factorChoice = :factorChoice"),
		@NamedQuery(name = "ScoringRuleCase.findByScore", query = "SELECT s FROM ScoringRuleCase s WHERE s.score = :score") })
public class ScoringRuleCase implements EntityBean {


	private Long id;

	private String factorChoice;

	private Double score;

	private ScoringRule rule;

	private List<MappingRuleCase> mappingRuleCaseList;

	public ScoringRuleCase() {
	}

	public ScoringRuleCase(Long id) {
		this.id = id;
	}

	@TableGenerator(name = "RULE_CASE_TABLE_GENERATOR",
			table = "SEQUENCE_GENERATOR_TABLE",
			pkColumnName = "SEQUENCE_NAME",
			valueColumnName = "SEQUENCE_VALUE",
			pkColumnValue = "RULE_CASE_SEQUENCE")
	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "RULE_CASE_TABLE_GENERATOR")
	@Column(name = "RULE_CASE_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "FACTOR_CHOICE")
	public String getFactorChoice() {
		return factorChoice;
	}

	public void setFactorChoice(String factorChoice) {
		this.factorChoice = factorChoice;
	}

	@Column(name = "SCORE")
	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@JoinColumn(name = "RULE_ID", referencedColumnName = "RULE_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	public ScoringRule getRule() {
		return rule;
	}

	public void setRule(ScoringRule rule) {
		this.rule = rule;
	}

	@Transient
	public List<MappingRuleCase> getMappingRuleCaseList() {
        return mappingRuleCaseList;
    }

    public void setMappingRuleCaseList(List<MappingRuleCase> mappingRuleCaseList) {
        this.mappingRuleCaseList = mappingRuleCaseList;
    }

	@Override
	public String toString() {
		return  factorChoice;
	}

	@Transient
	public Object getModelId() {
		return getId();
	}

}
