package com.EmployeeManagementSystem.model;

import com.EmployeeManagementSystem.dao.EmployeeDao;

public class Employee_Detail {
	private String employee_Name;
	private long citizen_Number;
	private String address;
	private long contact_Number;
	private String job_Location;
	private String designation;
	private String email;
	private String password;
	private String image;
	private  String london_MetId="LM2022C100";
	
	
	
	
	public void setId(String london_MetId )
	{
		this.london_MetId=london_MetId;
	}
	public String getId()
	{
		return this.london_MetId;
	}
	public Employee_Detail()
	{}
	public Employee_Detail(String employee_Name, long citizen_Number, String address, long contact_Number,
			String job_Location, String designation, String email, String password, String image) {
		super();
		this.employee_Name = employee_Name;
		this.citizen_Number = citizen_Number;
		this.address = address;
		this.contact_Number = contact_Number;
		this.job_Location = job_Location;
		this.designation = designation;
		this.email = email;
		this.password = password;
		this.image = image;
		
	}
	public String getEmployee_Name() {
		return employee_Name;
	}
	public void setEmployee_Name(String employee_Name) {
		this.employee_Name = employee_Name;
	}
	public long getCitizen_Number() {
		return citizen_Number;
	}
	public void setCitizen_Number(long citizen_Number) {
		this.citizen_Number = citizen_Number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContact_Number() {
		return contact_Number;
	}
	public void setContact_Number(long contact_Number) {
		this.contact_Number = contact_Number;
	}
	public String getJob_Location() {
		return job_Location;
	}
	public void setJob_Location(String job_Location) {
		this.job_Location = job_Location;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	@Override
	public String toString() {
		return "Employee_Form [getEmployee_Name()=" + getEmployee_Name() + ", getCitizen_Number()="
				+ getCitizen_Number() + ", getAddress()=" + getAddress() + ", getContact_Number()="
				+ getContact_Number() + ", getJob_Location()=" + getJob_Location() + ", getDesignation()="
				+ getDesignation() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getImage()="
				+ getImage() + ", getLondon_MetId()=" + getId() + "]";
	}
	
	
	

}
