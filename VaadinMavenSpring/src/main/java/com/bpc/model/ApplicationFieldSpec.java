package com.bpc.model;

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
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

/**
 *
 * @author tang_hn
 */
@Entity
@Table(name = "APPLICATION_FIELD_SPEC")
@NamedQueries({
    @NamedQuery(name = "ApplicationFieldSpec.findAll", query = "SELECT a FROM ApplicationFieldSpec a"),
    @NamedQuery(name = "ApplicationFieldSpec.findByName", query = "SELECT a FROM ApplicationFieldSpec a WHERE a.name = :name"),
    @NamedQuery(name = "ApplicationFieldSpec.findByFormatPattern", query = "SELECT a FROM ApplicationFieldSpec a WHERE a.formatPattern = :formatPattern"),
    @NamedQuery(name = "ApplicationFieldSpec.findByAppFieldSpecId", query = "SELECT a FROM ApplicationFieldSpec a WHERE a.id = :appFieldSpecId")})
public class ApplicationFieldSpec implements EntityBean {

    private Long id;
    private String name;
    private String formatPattern;
    private DataType dataType;
    private ApplicationSpecification specification;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "FORMAT_PATTERN")
    public String getFormatPattern() {
        return formatPattern;
    }

    public void setFormatPattern(String formatPattern) {
        this.formatPattern = formatPattern;
    }

    @TableGenerator(name = "FIELD_SPECIFICATION_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", pkColumnValue = "FIELD_SPECIFICATION_SEQUENCE")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "FIELD_SPECIFICATION_TABLE_GENERATOR")
	@Column(name = "APP_FIELD_SPEC_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JoinColumn(name = "DATA_TYPE_ID", referencedColumnName = "DATA_TYPE_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    @JoinColumn(name = "APP_SPEC_ID", referencedColumnName = "APP_SPEC_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
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
