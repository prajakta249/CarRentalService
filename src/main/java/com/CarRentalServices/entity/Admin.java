package com.CarRentalServices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="admin_credentials")
public class Admin {
	
	@Id
	@Column(name="admin_id")
	private int id;
	@Column(name="admin_firstname")
	private String firstname;
	@Column(name="admin_lastname")
	private String lastname;
	@Column(name="admin_contact_number")
	private String contactNumber;
	@Column(name="admin_username")
	private String username;
	@Column(name="admin_password")
	private String password;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public Admin(int id, String firstname, String lastname, String contactNumber, String username, String password) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.contactNumber = contactNumber;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		contactNumber = contactNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", ContactNumber="
				+ contactNumber + ", username=" + username + ", password=" + password + "]";
	}

	
}
