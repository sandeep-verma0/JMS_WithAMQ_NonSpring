package com.learnbycoding.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 100L;
	private int id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	public int getId() {
		return id;
	}
	
	public Employee(int id, String firstName , String lastName , Date dateOfBirth){
		this.id= id;
		this.firstName= firstName;
		this.lastName= lastName;
		this.dateOfBirth= dateOfBirth;
	}
	
	public void setId(int id) {
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Override
	public String toString(){
		return "ID  : '" + this.id + "'. firstName :  '"+ firstName+ "'. lastName : '" + "'. DOB : '" + dateOfBirth+"'.";
		
	}
}
