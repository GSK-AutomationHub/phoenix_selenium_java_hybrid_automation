package com.ui.pojo;

public class CustomerDetailsPojo {
	private String name;
	private String contactNo;
	private String emailId;
	public CustomerDetailsPojo(String name, String contactNo, String emailId) {
		super();
		this.name = name;
		this.contactNo = contactNo;
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "CustomerDetails [name= " + name + ", contactNo= " + contactNo + ", emailId= " + emailId + "]";
	}
	

	
}
