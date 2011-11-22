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
@Table(name = "DATA_TYPE")
@NamedQueries({
    @NamedQuery(name = "DataType.findAll", query = "SELECT d FROM DataType d"),
    @NamedQuery(name = "DataType.findByDataTypeId", query = "SELECT d FROM DataType d WHERE d.id = :dataTypeId"),
    @NamedQuery(name = "DataType.findByDescription", query = "SELECT d FROM DataType d WHERE d.description = :description"),
    @NamedQuery(name = "DataType.findByCode", query = "SELECT d FROM DataType d WHERE d.code = :code")})
public class DataType implements EntityBean {

    public static final String STRING_TYPE = "String";
    public static final String INT_TYPE = "Integer";
    public static final String DOUBLE_TYPE = "Double";
    public static final String DATE_TYPE = "Date";
    
    private Long id;
    private String description;
    private String code;
    private List<ApplicationFieldSpec> fieldSpecs;

    @TableGenerator(name = "DATA_TYPE_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", pkColumnValue = "DATA_TYPE_SEQUENCE")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "DATA_TYPE_TABLE_GENERATOR")
	@Column(name = "DATA_TYPE_ID")
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

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "dataType")
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
