package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.sql.Template;

@Entity
@Table(name="User_Service")
public class User {
	@Column
	@Id
	@GeneratedValue
	private Integer userId;
	@Column
	private String userName;
	@Column
	private String userSurname;
	@Column
	private Integer userPincode;
	@Column
	@Temporal(TemporalType.DATE)

	private Date userDob;
	@Column
	@Temporal(TemporalType.DATE)

	private Date userDoj;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSurname() {
		return userSurname;
	}
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	public Integer getUserPincode() {
		return userPincode;
	}
	public void setUserPincode(Integer userPincode) {
		this.userPincode = userPincode;
	}
	
	public Date getUserDob() {
		return userDob;
	}
	public void setUserDob(Date userDob) {
		this.userDob = userDob;
	}
	public Date getUserDoj() {
		return userDoj;
	}
	public void setUserDoj(Date userDoj) {
		this.userDoj = userDoj;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userSurname=" + userSurname + ", userPincode="
				+ userPincode + ", userDob=" + userDob + ", userDoj=" + userDoj + "]";
	}
	
	
}
	
	
	