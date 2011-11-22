/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bpc.model;

import java.util.List;

import javax.persistence.Basic;
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
 * @author truong_ht
 */
@Entity
@Table(name = "MAPPING_SCHEME")
@NamedQueries({
    @NamedQuery(name = "MappingScheme.findAll", query = "SELECT m FROM MappingScheme m"),
    @NamedQuery(name = "MappingScheme.findByMappingSchemeId", query = "SELECT m FROM MappingScheme m WHERE m.mappingSchemeId = :mappingSchemeId"),
    @NamedQuery(name = "MappingScheme.findByName", query = "SELECT m FROM MappingScheme m WHERE m.name = :name"),
    @NamedQuery(name = "MappingScheme.findByCode", query = "SELECT m FROM MappingScheme m WHERE m.code = :code"),
    @NamedQuery(name = "MappingScheme.findByCodeAndSpec", query = "SELECT m FROM MappingScheme m WHERE m.code = :code and m.applicationSpecification = :appSpec")})
public class MappingScheme implements EntityBean {


    private Long mappingSchemeId;

    private String name;

    private String code;

    private List<ScoreCalculation> scoreCalculationList;

    private ScoringScheme scoringScheme;

    private ApplicationSpecification applicationSpecification;

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
    @Id
    @TableGenerator(name = "MAPPING_SCHEME_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", pkColumnValue = "MAPPING_SCHEME_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MAPPING_SCHEME_TABLE_GENERATOR")
    @Basic(optional = false)
    @Column(name = "MAPPING_SCHEME_ID")
    public Long getMappingSchemeId() {
        return mappingSchemeId;
    }

    public void setMappingSchemeId(Long mappingSchemeId) {
        this.mappingSchemeId = mappingSchemeId;
    }
    @Basic(optional = false)
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Basic(optional = false)
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @Transient
    public List<ScoreCalculation> getScoreCalculationList() {
        return scoreCalculationList;
    }

    public void setScoreCalculationList(List<ScoreCalculation> scoreCalculationList) {
        this.scoreCalculationList = scoreCalculationList;
    }
    @JoinColumn(name = "SCORING_SCHEME_ID", referencedColumnName = "SCHEME_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    public ScoringScheme getScoringScheme() {
        return scoringScheme;
    }

    public void setScoringScheme(ScoringScheme scoringScheme) {
        this.scoringScheme = scoringScheme;
    }
    @JoinColumn(name = "APP_SPEC_ID", referencedColumnName = "APP_SPEC_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    public ApplicationSpecification getApplicationSpecification() {
        return applicationSpecification;
    }

    public void setApplicationSpecification(ApplicationSpecification applicationSpecification) {
        this.applicationSpecification = applicationSpecification;
    }
    @Transient
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

    public String toString(){
        return this.name;
    }

}
