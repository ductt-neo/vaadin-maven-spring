package com.bpc.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SCORING_SCHEME")
@NamedQueries({
		@NamedQuery(name = "ScoringScheme.findAll", query = "SELECT s FROM ScoringScheme s"),
		@NamedQuery(name = "ScoringScheme.findBySchemeId", query = "SELECT s FROM ScoringScheme s WHERE s.id = :schemeId"),
		@NamedQuery(name = "ScoringScheme.findBySchemeName", query = "SELECT s FROM ScoringScheme s WHERE s.name = :schemeName") })
public class ScoringScheme implements EntityBean {

	@Id
	@Column(name = "SCHEME_ID")
	@SequenceGenerator(name = "SEQ_SCORING_SCHEME", sequenceName = "SEQ_SCORING_SCHEME")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SCORING_SCHEME")
	private Long id;

	private String name;

	@Transient
	private List<ScoringRule> rules;

	@Transient
	private List<MappingScheme> mappingSchemeList;

	public ScoringScheme() {
	}

	public ScoringScheme(Long id) {
		this.id = id;
	}

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

	public List<ScoringRule> getRules() {
		return rules;
	}

	public void setRules(List<ScoringRule> rules) {
		this.rules = rules;
	}

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

	public boolean equals(Object scheme) {
		return (scheme instanceof ScoringScheme) ? name.equalsIgnoreCase(((ScoringScheme) scheme).getName()) : false;
	}

	public int hashCode() {
		return name.hashCode();
	}

}
