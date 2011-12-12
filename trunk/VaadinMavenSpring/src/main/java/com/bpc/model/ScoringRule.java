package com.bpc.model;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "SCORING_RULE")
@NamedQueries({ @NamedQuery(name = "ScoringRule.findAll", query = "SELECT s FROM ScoringRule s"),
		@NamedQuery(name = "ScoringRule.findByRuleId", query = "SELECT s FROM ScoringRule s WHERE s.id = :ruleId"),
		@NamedQuery(name = "ScoringRule.findByWeight", query = "SELECT s FROM ScoringRule s WHERE s.weight = :weight") })
public class ScoringRule implements EntityBean {

	@Id
	@Column(name = "RULE_ID")
	@SequenceGenerator(name = "SEQ_SCORING_RULE", sequenceName = "SEQ_SCORING_RULE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SCORING_RULE")
	private Long id;

	private BigDecimal weight;

	@JoinColumn(name = "SCHEME_ID", referencedColumnName = "SCHEME_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ScoringScheme scheme;

	@JoinColumn(name = "FACTOR_ID", referencedColumnName = "FACTOR_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Factor factor;

	@Column(name = "REQUIRED")
	private Character required;

	@Transient
	private List<ScoringRuleCase> ruleCases;

	@Transient
	private List<MappingRule> mappingRuleList;

	public ScoringRule() {
	}

	public ScoringRule(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ScoringScheme getScheme() {
		return scheme;
	}

	public void setScheme(ScoringScheme scheme) {
		this.scheme = scheme;
	}

	public Factor getFactor() {
		return factor;
	}

	public void setFactor(Factor factor) {
		this.factor = factor;
	}

	public void setRuleCases(List<ScoringRuleCase> ruleCases) {
		this.ruleCases = ruleCases;
	}

	public List<ScoringRuleCase> getRuleCases() {
		return ruleCases;
	}

	public BigDecimal getWeight() {
		if (weight == null) weight = BigDecimal.valueOf(0.0);
		return weight;
	}

	public Character getRequired() {
		if (required == null) required = new Character('Y');
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

	public List<MappingRule> getMappingRuleList() {
		return mappingRuleList;
	}

	public void setMappingRuleList(List<MappingRule> mappingRuleList) {
		this.mappingRuleList = mappingRuleList;
	}

	@Override
	public String toString() {
		return id.toString() + " : " + scheme.getName();
	}

}
