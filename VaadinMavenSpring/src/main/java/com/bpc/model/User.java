package com.bpc.model;

public class User {
	private Integer personId;
	private String login;
	private String name;

	public User() {
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return this.getPersonId() + "|" + this.getLogin() + "|" + this.getName();
	}
}
