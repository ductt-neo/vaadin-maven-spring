/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bpc.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SCORE_CALCULATION")
@NamedQueries({
		@NamedQuery(name = "ScoreCalculation.findAll", query = "SELECT s FROM ScoreCalculation s"),
		@NamedQuery(name = "ScoreCalculation.findByCalculationId", query = "SELECT s FROM ScoreCalculation s WHERE s.calculationId = :calculationId"),
		@NamedQuery(name = "ScoreCalculation.findByCreditScoreResult", query = "SELECT s FROM ScoreCalculation s WHERE s.creditScoreResult = :creditScoreResult"),
		@NamedQuery(name = "ScoreCalculation.findByApplicationId", query = "SELECT s FROM ScoreCalculation s WHERE s.applicationId = :applicationId"),
		@NamedQuery(name = "ScoreCalculation.findByRequestDate", query = "SELECT s FROM ScoreCalculation s WHERE s.requestDate = :requestDate") })
public class ScoreCalculation implements EntityBean {

	@Id
	@Basic(optional = false)
	@Column(name = "CALCULATION_ID")
	@SequenceGenerator(name = "SEQ_SCORE_CALCULATION", sequenceName = "SEQ_SCORE_CALCULATION")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SCORE_CALCULATION")
	private Long calculationId;

	@Basic(optional = false)
	@Column(name = "CREDIT_SCORE_RESULT")
	private Double creditScoreResult;

	@Basic(optional = false)
	@Column(name = "APPLICATION_ID")
	private String applicationId;

	@Basic(optional = false)
	@Column(name = "REQUEST_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestDate;

	@JoinColumn(name = "MAPPING_SCHEME_ID", referencedColumnName = "MAPPING_SCHEME_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private MappingScheme mappingScheme;

	@JoinColumn(name = "APP_SPEC_ID", referencedColumnName = "APP_SPEC_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ApplicationSpecification applicationSpecification;

	@Transient
	private List<PartialResult> partialResultList;

	public ScoreCalculation() {
	}

	public ScoreCalculation(Long calculationId) {
		this.calculationId = calculationId;
	}

	public ScoreCalculation(Long calculationId, Double creditScoreResult, String applicationId, Date requestDate) {
		this.calculationId = calculationId;
		this.creditScoreResult = creditScoreResult;
		this.applicationId = applicationId;
		this.requestDate = requestDate;
	}

	public Long getCalculationId() {
		return calculationId;
	}

	public void setCalculationId(Long calculationId) {
		this.calculationId = calculationId;
	}

	public Double getCreditScoreResult() {
		return creditScoreResult;
	}

	public void setCreditScoreResult(Double creditScoreResult) {
		this.creditScoreResult = creditScoreResult;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public MappingScheme getMappingScheme() {
		return mappingScheme;
	}

	public void setMappingScheme(MappingScheme mappingScheme) {
		this.mappingScheme = mappingScheme;
	}

	public ApplicationSpecification getApplicationSpecification() {
		return applicationSpecification;
	}

	public void setApplicationSpecification(ApplicationSpecification applicationSpecification) {
		this.applicationSpecification = applicationSpecification;
	}

	public List<PartialResult> getPartialResultList() {
		return partialResultList;
	}

	public void setPartialResultList(List<PartialResult> partialResultList) {
		this.partialResultList = partialResultList;
	}

	@Override
	public String toString() {
		return "com.bpc.model.ScoreCalculation[calculationId=" + calculationId + "]";
	}

	@Transient
	public Object getModelId() {
		return getCalculationId();
	}

}
