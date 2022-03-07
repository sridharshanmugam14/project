package com.BookingSystem.Entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_type")
public class UserType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userTypeId;
	private String userType; 
	

	public UserType(int userTypeId, String userType) {
		super();
		this.userTypeId = userTypeId;
		this.userType = userType;
	}

	public UserType() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [userTypeId=" + userTypeId + ", userType=" + userType + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(userType, userTypeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserType other = (UserType) obj;
		return Objects.equals(userType, other.userType) && userTypeId == other.userTypeId;
	}

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	

}
