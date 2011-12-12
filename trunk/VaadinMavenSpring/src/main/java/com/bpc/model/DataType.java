package com.bpc.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DATA_TYPE")
@NamedQueries({
		@NamedQuery(name = "DataType.findAll", query = "SELECT d FROM DataType d"),
		@NamedQuery(name = "DataType.findByDataTypeId", query = "SELECT d FROM DataType d WHERE d.id = :dataTypeId"),
		@NamedQuery(name = "DataType.findByDescription", query = "SELECT d FROM DataType d WHERE d.description = :description"),
		@NamedQuery(name = "DataType.findByCode", query = "SELECT d FROM DataType d WHERE d.code = :code") })
public class DataType implements EntityBean {

	public static final String STRING_TYPE = "String";

	public static final String INT_TYPE = "Integer";

	public static final String DOUBLE_TYPE = "Double";

	public static final String DATE_TYPE = "Date";

	@Id
	@Column(name = "DATA_TYPE_ID")
	@SequenceGenerator(name = "SEQ_DATA_TYPE", sequenceName = "SEQ_DATA_TYPE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DATA_TYPE")
	private Long id;

	private String description;

	private String code;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "dataType")
	private List<ApplicationFieldSpec> fieldSpecs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<ApplicationFieldSpec> getFieldSpecs() {
		return fieldSpecs;
	}

	public void setFieldSpecs(List<ApplicationFieldSpec> fieldSpecs) {
		this.fieldSpecs = fieldSpecs;
	}

	@Override
	public String toString() {
		return id + " : " + description + " : " + code;
	}

	@Transient
	public Object getModelId() {
		return getId();
	}

}
