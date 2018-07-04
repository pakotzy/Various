package com.pakotzy.ncube.crm.entities;

import java.io.File;
import java.time.LocalDate;

public class Member {
	private String id;
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private Integer zipCode;
	private File photo;

	public Member() {
	}

	public Member(String id, String firstName, String lastName, LocalDate birthday, Integer zipCode, File photo) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.zipCode = zipCode;
		this.photo = photo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}
}
