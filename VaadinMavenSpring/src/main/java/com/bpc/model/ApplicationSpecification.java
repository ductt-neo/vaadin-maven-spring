package com.bpc.model;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "APPLICATION_SPECIFICATION")
@NamedQueries({
		@NamedQuery(name = "ApplicationSpecification.findAll", query = "SELECT a FROM ApplicationSpecification a"),
		@NamedQuery(name = "ApplicationSpecification.findByAppSpecId", query = "SELECT a FROM ApplicationSpecification a WHERE a.id = :appSpecId"),
		@NamedQuery(name = "ApplicationSpecification.findByName", query = "SELECT a FROM ApplicationSpecification a WHERE a.name = :name"),
		@NamedQuery(name = "ApplicationSpecification.findByCodeAndSystem", query = "SELECT a FROM ApplicationSpecification a WHERE a.code = :code and a.externalSystem = :extSys") })
public class ApplicationSpecification implements EntityBean {

	@Id
	@Column(name = "APP_SPEC_ID")
	@SequenceGenerator(name = "SEQ_APPLICATION_SPECIFICATION", sequenceName = "SEQ_APPLICATION_SPECIFICATION")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_APPLICATION_SPECIFICATION")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CODE")
	private String code;

	@Transient
	private List<ApplicationFieldSpec> fieldSpecs;

	@JoinColumn(name = "EXTERNAL_SYSTEM_ID", referencedColumnName = "EXTERNAL_SYSTEM_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ExternalSystem externalSystem;

	@Transient
	private List<MappingScheme> mappingSchemes;

	@Transient
	private List<ScoreCalculation> scoreCalculations;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public List<ApplicationFieldSpec> getFieldSpecs() {
		return fieldSpecs;
	}

	public void setFieldSpecs(List<ApplicationFieldSpec> fieldSpecs) {
		this.fieldSpecs = fieldSpecs;
	}

	public ExternalSystem getExternalSystem() {
		return externalSystem;
	}

	public void setExternalSystem(ExternalSystem externalSystem) {
		this.externalSystem = externalSystem;
	}

	public List<MappingScheme> getMappingSchemes() {
		return mappingSchemes;
	}

	public void setMappingSchemes(List<MappingScheme> mappingSchemes) {
		this.mappingSchemes = mappingSchemes;
	}

	public List<ScoreCalculation> getScoreCalculations() {
		return scoreCalculations;
	}

	public void setScoreCalculations(List<ScoreCalculation> scoreCalculations) {
		this.scoreCalculations = scoreCalculations;
	}

	@Override
	public String toString() {
		return id + " : " + name;
	}

	@Transient
	public Object getModelId() {
		return getId();
	}

}
