package com.bpc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

/**
 *
 * @author tang_hn
 */
@Entity
@Table(name = "EXTERNAL_SYSTEM")
@NamedQueries({
    @NamedQuery(name = "ExternalSystem.findAll", query = "SELECT e FROM ExternalSystem e"),
    @NamedQuery(name = "ExternalSystem.findByExternalSystemId", query = "SELECT e FROM ExternalSystem e WHERE e.id = :externalSystemId"),
        @NamedQuery(name = "ExternalSystem.findByName", query = "SELECT e FROM ExternalSystem e WHERE e.name = :name"),
        @NamedQuery(name = "ExternalSystem.findByCode", query = "SELECT e FROM ExternalSystem e WHERE e.code = :code") })
public class ExternalSystem implements EntityBean {
    

	
    private Long id;
    private String name;
    private String code;
    private List<ApplicationSpecification> specifications;

    @TableGenerator(name = "SYSTEM_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", pkColumnValue = "EXTERNAL_SYSTEM_SEQUENCE")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SYSTEM_TABLE_GENERATOR")
	@Column(name = "EXTERNAL_SYSTEM_ID")
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

    @Transient
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
