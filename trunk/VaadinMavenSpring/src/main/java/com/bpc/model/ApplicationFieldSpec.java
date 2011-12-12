package com.bpc.model;

import javax.persistence.*;

@Entity
@Table(name = "APPLICATION_FIELD_SPEC")
@NamedQueries({
		@NamedQuery(name = "ApplicationFieldSpec.findAll", query = "SELECT a FROM ApplicationFieldSpec a"),
		@NamedQuery(name = "ApplicationFieldSpec.findByName", query = "SELECT a FROM ApplicationFieldSpec a WHERE a.name = :name"),
		@NamedQuery(name = "ApplicationFieldSpec.findByFormatPattern", query = "SELECT a FROM ApplicationFieldSpec a WHERE a.formatPattern = :formatPattern"),
		@NamedQuery(name = "ApplicationFieldSpec.findByAppFieldSpecId", query = "SELECT a FROM ApplicationFieldSpec a WHERE a.id = :appFieldSpecId") })
public class ApplicationFieldSpec implements EntityBean {

	@Id
	@Column(name = "APP_FIELD_SPEC_ID")
	@SequenceGenerator(name = "SEQ_APPLICATION_FIELD_SPEC", sequenceName = "SEQ_APPLICATION_FIELD_SPEC")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_APPLICATION_FIELD_SPEC")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "FORMAT_PATTERN")
	private String formatPattern;

	@JoinColumn(name = "DATA_TYPE_ID", referencedColumnName = "DATA_TYPE_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private DataType dataType;

	@JoinColumn(name = "APP_SPEC_ID", referencedColumnName = "APP_SPEC_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private ApplicationSpecification specification;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormatPattern() {
		return formatPattern;
	}

	public void setFormatPattern(String formatPattern) {
		this.formatPattern = formatPattern;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public ApplicationSpecification getSpecification() {
		return specification;
	}

	public void setSpecification(ApplicationSpecification specification) {
		this.specification = specification;
	}

	@Override
	public String toString() {
		return id + " : " + name + " : " + formatPattern;
	}

	@Transient
	public Object getModelId() {
		return getId();
	}

}
