package com.bpc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author do_th
 */
@Entity
@Table(name = "SCORING_SCHEME")
@NamedQueries({
        @NamedQuery(name = "ScoringScheme.findAll", query = "SELECT s FROM ScoringScheme s"),
        @NamedQuery(name = "ScoringScheme.findBySchemeId", query = "SELECT s FROM ScoringScheme s WHERE s.id = :schemeId"),
        @NamedQuery(name = "ScoringScheme.findBySchemeName", query = "SELECT s FROM ScoringScheme s WHERE s.name = :schemeName")})
public class ScoringScheme implements EntityBean {

    private Long id;

    private String name;

    private List<ScoringRule> rules;

    private List<MappingScheme> mappingSchemeList;

    public ScoringScheme() {
    }

    public ScoringScheme(Long id) {
        this.id = id;
    }

    @TableGenerator(name = "SCHEME_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", pkColumnValue = "SCHEME_SEQUENCE")
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SCHEME_TABLE_GENERATOR")
    @Column(name = "SCHEME_ID")
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

    @Transient
    public List<ScoringRule> getRules() {
        return rules;
    }

    public void setRules(List<ScoringRule> rules) {
        this.rules = rules;
    }

    @Transient
    public List<MappingScheme> getMappingSchemeList() {
        return mappingSchemeList;
    }

    public void setMappingSchemeList(List<MappingScheme> mappingSchemeList) {
        this.mappingSchemeList = mappingSchemeList;
    }

    @Transient
    public Object getModelId() {
        return getId();
    }

    @Override
    public String toString() {
        return name;
    }

}
