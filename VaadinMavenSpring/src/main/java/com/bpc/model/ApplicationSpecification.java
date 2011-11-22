package com.bpc.model;

import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

/**
 *
 * @author tang_hn
 */
@Entity
@Table(name = "APPLICATION_SPECIFICATION")
@NamedQueries({
    @NamedQuery(name = "ApplicationSpecification.findAll", query = "SELECT a FROM ApplicationSpecification a"),
    @NamedQuery(name = "ApplicationSpecification.findByAppSpecId", query = "SELECT a FROM ApplicationSpecification a WHERE a.id = :appSpecId"),
        @NamedQuery(name = "ApplicationSpecification.findByName", query = "SELECT a FROM ApplicationSpecification a WHERE a.name = :name"),
        @NamedQuery(name = "ApplicationSpecification.findByCodeAndSystem", query = "SELECT a FROM ApplicationSpecification a WHERE a.code = :code and a.externalSystem = :extSys") })
public class ApplicationSpecification implements EntityBean {

    
    private Long id;
    private String name;
    private String code;
    private List<ApplicationFieldSpec> fieldSpecs;
    private ExternalSystem externalSystem;
    private List<MappingScheme> mappingSchemes;
	private List<ScoreCalculation> scoreCalculations;

    @TableGenerator(name = "SPECIFICATION_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", pkColumnValue = "SPECIFICATION_SEQUENCE")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "SPECIFICATION_TABLE_GENERATOR")
	@Column(name = "APP_SPEC_ID")
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
    public List<ApplicationFieldSpec> getFieldSpecs() {
        return fieldSpecs;
    }

    public void setFieldSpecs(List<ApplicationFieldSpec> fieldSpecs) {
        this.fieldSpecs = fieldSpecs;
    }

    @JoinColumn(name = "EXTERNAL_SYSTEM_ID", referencedColumnName = "EXTERNAL_SYSTEM_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    public ExternalSystem getExternalSystem() {
        return externalSystem;
    }

    public void setExternalSystem(ExternalSystem externalSystem) {
        this.externalSystem = externalSystem;
    }
    
    @Transient
    public List<MappingScheme> getMappingSchemes() {
		return mappingSchemes;
	}

	public void setMappingSchemes(List<MappingScheme> mappingSchemes) {
		this.mappingSchemes = mappingSchemes;
	}
	
	@Transient
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
