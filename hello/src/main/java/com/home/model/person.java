package com.home.model;

 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity

public class person{
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)

private int Id;

private String Username;

private String Password;

private String CPassword;

private String Email;

private String Phone;

private String Location;

private int Role = 1;

private boolean Active = true;

public int getId() {
	return Id;
}

public void setId(int id) {
	Id = id;
}

@NotEmpty(message="This field is mandatory")
public String getUsername() {
	return Username;
}

public void setUsername(String username) {
	Username = username;
}

@NotEmpty(message="This field is mandatory")
public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}

@NotEmpty(message="This field is mandatory")
public String getCPassword() {
	return CPassword;
}

public void setCPassword(String cPassword) {
	CPassword = cPassword;
}

@NotEmpty(message="This field is mandatory")
@Email(message="Invalid email format")
public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

@Pattern(message="Phone Number must be a valid 10 Digit Mobile Number",regexp="^[987][0-9]{9}$")
@NotEmpty(message="This field is mandatory")
public String getPhone() {
	return Phone;
}

public void setPhone(String phone) {
	Phone = phone;
}

@NotEmpty(message="This field is mandatory")
public String getLocation() {
	return Location;
}

public void setLocation(String location) {
	Location = location;
}

public int getRole() {
	return Role;
}

public void setRole(int role) {
	Role = role;
}

public boolean isActive() {
	return Active;
}

public void setActive(boolean active) {
	Active = active;
}




}


