package com.bpc.model;

import javax.persistence.*;

@Entity
@Table(name = "SCORING_AUTHORITY")
public class ScoringUserAuthority implements EntityBean {

	@Id
	@Column(name = "USERNAME")
	@SequenceGenerator(name = "SEQ_SCORING_AUTHORITY", sequenceName = "SEQ_SCORING_AUTHORITY")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SCORING_AUTHORITY")
	private String userName;

	@Column(name = "AUTHORITY")
	private String authority;

	public ScoringUserAuthority() {
	}

	public ScoringUserAuthority(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Transient
	public Object getModelId() {
		return getUserName();
	}
}
