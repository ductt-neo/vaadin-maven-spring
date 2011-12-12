/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bpc.model;

import java.util.List;

import javax.persistence.Basic;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "MAPPING_SCHEME")
@NamedQueries({
		@NamedQuery(name = "MappingScheme.findAll", query = "SELECT m FROM MappingScheme m"),
		@NamedQuery(name = "MappingScheme.findByMappingSchemeId", query = "SELECT m FROM MappingScheme m WHERE m.mappingSchemeId = :mappingSchemeId"),
		@NamedQuery(name = "MappingScheme.findByName", query = "SELECT m FROM MappingScheme m WHERE m.name = :name"),
		@NamedQuery(name = "MappingScheme.findByCode", query = "SELECT m FROM MappingScheme m WHERE m.code = :code"),
		@NamedQuery(name = "MappingScheme.findByCodeAndSpec", query = "SELECT m FROM MappingScheme m WHERE m.code = :code and m.applicationSpecification = :appSpec") })
public class MappingScheme implements EntityBean {

	@Id
	@Basic(optional = false)
	@Column(name = "MAPPING_SCHEME_ID")
	@SequenceGenerator(name = "SEQ_MAPPING_SCHEME", sequenceName = "SEQ_MAPPING_SCHEME")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MAPPING_SCHEME")
	private Long mappingSchemeId;

	@Basic(optional = false)
	@Column(name = "NAME")
	private String name;

	@Basic(optional = false)
	@Column(name = "CODE")
	private String code;

	@Transient
	private List<ScoreCalculation> scoreCalculationList;

	@JoinColumn(name = "SCORING_SCHEME_ID", referencedColumnName = "SCHEME_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ScoringScheme scoringScheme;

	@JoinColumn(name = "APP_SPEC_ID", referencedColumnName = "APP_SPEC_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ApplicationSpecification applicationSpecification;

	@Transient
	private List<MappingRule> mappingRuleList;

	public MappingScheme() {
	}

	public MappingScheme(Long mappingSchemeId) {
		this.mappingSchemeId = mappingSchemeId;
	}

	public MappingScheme(Long mappingSchemeId, String name, String code) {
		this.mappingSchemeId = mappingSchemeId;
		this.name = name;
		this.code = code;
	}

	public Long getMappingSchemeId() {
		return mappingSchemeId;
	}

	public void setMappingSchemeId(Long mappingSchemeId) {
		this.mappingSchemeId = mappingSchemeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<ScoreCalculation> getScoreCalculationList() {
		return scoreCalculationList;
	}

	public void setScoreCalculationList(List<ScoreCalculation> scoreCalculationList) {
		this.scoreCalculationList = scoreCalculationList;
	}

	public ScoringScheme getScoringScheme() {
		return scoringScheme;
	}

	public void setScoringScheme(ScoringScheme scoringScheme) {
		this.scoringScheme = scoringScheme;
	}

	public ApplicationSpecification getApplicationSpecification() {
		return applicationSpecification;
	}

	public void setApplicationSpecification(ApplicationSpecification applicationSpecification) {
		this.applicationSpecification = applicationSpecification;
	}

	public List<MappingRule> getMappingRuleList() {
		return mappingRuleList;
	}

	public void setMappingRuleList(List<MappingRule> mappingRuleList) {
		this.mappingRuleList = mappingRuleList;
	}

	@Transient
	public Object getModelId() {
		return getMappingSchemeId();
	}

	public String toString() {
		return this.name;
	}

}
