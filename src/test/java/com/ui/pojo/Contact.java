package com.ui.pojo;

public class Contact {
	private String foreName;
	private String surName;
    private String email;
    private String telephone;
    private String message;
    
    public Contact(String foreName, String surName, String email, String telephone, String message) {
		super();
		this.foreName = foreName;
		this.surName = surName;
		this.email = email;
		this.telephone = telephone;
		this.message = message;
	}
	public String getForeName() {
		return foreName;
	}
	public void setForeName(String foreName) {
		this.foreName = foreName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
    public String toString() {
        return "Contact{" +
                "foreName='" + foreName + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
    
    

}
