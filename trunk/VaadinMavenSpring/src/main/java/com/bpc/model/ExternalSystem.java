package com.bpc.model;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "EXTERNAL_SYSTEM")
@NamedQueries({
		@NamedQuery(name = "ExternalSystem.findAll", query = "SELECT e FROM ExternalSystem e"),
		@NamedQuery(name = "ExternalSystem.findByExternalSystemId", query = "SELECT e FROM ExternalSystem e WHERE e.id = :externalSystemId"),
		@NamedQuery(name = "ExternalSystem.findByName", query = "SELECT e FROM ExternalSystem e WHERE e.name = :name"),
		@NamedQuery(name = "ExternalSystem.findByCode", query = "SELECT e FROM ExternalSystem e WHERE e.code = :code") })
public class ExternalSystem implements EntityBean {

	@Id
	@Column(name = "EXTERNAL_SYSTEM_ID")
	@SequenceGenerator(name = "SEQ_EXTERNAL_SYSTEM", sequenceName = "SEQ_EXTERNAL_SYSTEM")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EXTERNAL_SYSTEM")
	private Long id;

	private String name;

	private String code;

	@Transient
	private List<ApplicationSpecification> specifications;

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

	public List<ApplicationSpecification> getSpecifications() {
		return specifications;
	}

	public void setSpecifications(List<ApplicationSpecification> specifications) {
		this.specifications = specifications;
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
