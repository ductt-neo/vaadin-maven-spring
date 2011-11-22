package com.bpc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

@Entity
@Table(name = "SCORING_FACTOR")
public class Factor implements EntityBean {



	private Long id;

	private String name;

    private List<ScoringRule> scoringRules;

    public Factor(){}
    public Factor(Long id){
    	this.id = id;
    }

	@TableGenerator(name = "FACTOR_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", pkColumnValue = "FACTOR_SEQUENCE")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "FACTOR_TABLE_GENERATOR")
	@Column(name = "FACTOR_ID")
	public Long getId() {
		return id;
	}
	@OneToMany( mappedBy = "factor")
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

    public String toString(){
        return this.name;
    }

}
