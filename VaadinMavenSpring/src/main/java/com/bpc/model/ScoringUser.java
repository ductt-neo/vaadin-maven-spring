package com.bpc.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SCORING_USER")
public class ScoringUser implements EntityBean {

	@Id
	@Column(name = "USER_ID")
	@SequenceGenerator(name = "SEQ_SCORING_USER", sequenceName = "SEQ_SCORING_USER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SCORING_USER")
	private Long userId;
	
	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ENABLED")
	private String enabled;

	/*@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private List<ScoringUserRole> authorities;*/

	public ScoringUser() {
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public ScoringUser(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	/*public List<ScoringUserRole> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<ScoringUserRole> authorities) {
		this.authorities = authorities;
	}*/

	@Transient
	public Object getModelId() {
		return getUserName();
	}
}
