/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bpc.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SCORING_RULE_CASE")
@NamedQueries({
		@NamedQuery(name = "ScoringRuleCase.findAll", query = "SELECT s FROM ScoringRuleCase s"),
		@NamedQuery(name = "ScoringRuleCase.findByRuleCaseId", query = "SELECT s FROM ScoringRuleCase s WHERE s.id = :ruleCaseId"),
		@NamedQuery(name = "ScoringRuleCase.findByFactorChoice", query = "SELECT s FROM ScoringRuleCase s WHERE s.factorChoice = :factorChoice"),
		@NamedQuery(name = "ScoringRuleCase.findByScore", query = "SELECT s FROM ScoringRuleCase s WHERE s.score = :score") })
public class ScoringRuleCase implements EntityBean {

	@Id
	@Basic(optional = false)
	@Column(name = "RULE_CASE_ID")
	@SequenceGenerator(name = "SEQ_SCORING_RULE_CASE", sequenceName = "SEQ_SCORING_RULE_CASE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SCORING_RULE_CASE")
	private Long id;

	@Column(name = "FACTOR_CHOICE")
	private String factorChoice;

	@Column(name = "SCORE")
	private Double score;

	@JoinColumn(name = "RULE_ID", referencedColumnName = "RULE_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ScoringRule rule;

	@Transient
	private List<MappingRuleCase> mappingRuleCaseList;

	public ScoringRuleCase() {
		factorChoice = "";
		score = 0d;

	}

	public ScoringRuleCase(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFactorChoice() {
		return factorChoice;
	}

	public void setFactorChoice(String factorChoice) {
		this.factorChoice = factorChoice;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public ScoringRule getRule() {
		return rule;
	}

	public void setRule(ScoringRule rule) {
		this.rule = rule;
	}

	public List<MappingRuleCase> getMappingRuleCaseList() {
		return mappingRuleCaseList;
	}

	public void setMappingRuleCaseList(List<MappingRuleCase> mappingRuleCaseList) {
		this.mappingRuleCaseList = mappingRuleCaseList;
	}

	@Override
	public String toString() {
		return factorChoice;
	}

	@Transient
	public Object getModelId() {
		return getId();
	}

}
