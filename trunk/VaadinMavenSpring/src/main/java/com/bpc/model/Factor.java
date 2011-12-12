package com.bpc.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SCORING_FACTOR")
public class Factor implements EntityBean {

	@Id
	@Column(name = "FACTOR_ID")
	@SequenceGenerator(name = "SEQ_SCORING_FACTOR", sequenceName = "SEQ_SCORING_FACTOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SCORING_FACTOR")
	private Long id;

	@Column(name = "NAME")
	private String name = "";

	@OneToMany(mappedBy = "factor")
	private List<ScoringRule> scoringRules;

	public Factor() {
	}

	public Factor(Long id) {
		this.id = id;
	}

	public Factor(String name) {
		id = 0L;
		this.name = name;
	}

	public Factor(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public List<ScoringRule> getScoringRules() {
		return scoringRules;
	}

	public void setScoringRules(List<ScoringRule> scoringRules) {
		this.scoringRules = scoringRules;
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
	public Object getModelId() {
		return getId();
	}

	public String toString() {
		return this.name;
	}

	public int hashCode() {
		return name.hashCode();
	}

	public boolean equals(Object factor) {
		return (factor instanceof Factor) ? name.equalsIgnoreCase(((Factor) factor).getName()) : false;
	}
}
