/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bpc.model;

import javax.persistence.*;

@Entity
@Table(name = "PARTIAL_RESULT")
@NamedQueries({
		@NamedQuery(name = "PartialResult.findAll", query = "SELECT p FROM PartialResult p"),
		@NamedQuery(name = "PartialResult.findByPartialResultId", query = "SELECT p FROM PartialResult p WHERE p.partialResultId = :partialResultId"),
		@NamedQuery(name = "PartialResult.findByPartialResult", query = "SELECT p FROM PartialResult p WHERE p.partialResult = :partialResult") })
public class PartialResult implements EntityBean {

	@Id
	@Basic(optional = false)
	@Column(name = "PARTIAL_RESULT_ID")
	@SequenceGenerator(name = "SEQ_PARTIAL_RESULT", sequenceName = "SEQ_PARTIAL_RESULT")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PARTIAL_RESULT")
	private Long partialResultId;

	@Basic(optional = false)
	@Column(name = "PARTIAL_RESULT")
	private Double partialResult;

	@JoinColumn(name = "SCORING_RULE_CASE_ID", referencedColumnName = "RULE_CASE_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ScoringRuleCase scoringRuleCase;

	@JoinColumn(name = "SCORING_RULE_ID", referencedColumnName = "RULE_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ScoringRule scoringRule;

	@JoinColumn(name = "CALCULATION_ID", referencedColumnName = "CALCULATION_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ScoreCalculation scoreCalculation;

	@JoinColumn(name = "MAPPING_RULE_CASE_ID", referencedColumnName = "MAPPING_RULE_CASE_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private MappingRuleCase mappingRuleCase;

	public PartialResult() {
	}

	public PartialResult(Long partialResultId) {
		this.partialResultId = partialResultId;
	}

	public PartialResult(Long partialResultId, Double partialResult) {
		this.partialResultId = partialResultId;
		this.partialResult = partialResult;
	}

	public Long getPartialResultId() {
		return partialResultId;
	}

	public void setPartialResultId(Long partialResultId) {
		this.partialResultId = partialResultId;
	}

	public Double getPartialResult() {
		return partialResult;
	}

	public void setPartialResult(Double partialResult) {
		this.partialResult = partialResult;
	}

	public ScoringRuleCase getScoringRuleCase() {
		return scoringRuleCase;
	}

	public void setScoringRuleCase(ScoringRuleCase scoringRuleCase) {
		this.scoringRuleCase = scoringRuleCase;
	}

	public ScoringRule getScoringRule() {
		return scoringRule;
	}

	public void setScoringRule(ScoringRule scoringRule) {
		this.scoringRule = scoringRule;
	}

	public ScoreCalculation getScoreCalculation() {
		return scoreCalculation;
	}

	public void setScoreCalculation(ScoreCalculation scoreCalculation) {
		this.scoreCalculation = scoreCalculation;
	}

	public MappingRuleCase getMappingRuleCase() {
		return mappingRuleCase;
	}

	public void setMappingRuleCase(MappingRuleCase mappingRuleCase) {
		this.mappingRuleCase = mappingRuleCase;
	}

	@Override
	public String toString() {
		return "com.bpc.model.PartialResult[partialResultId=" + partialResultId + "]";
	}

	@Transient
	public Object getModelId() {
		return getPartialResultId();
	}

}
