package com.BookingSystem.Entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driver_details")
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;
	private String licenceNo;
	private float rating;

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(driverId, licenceNo, rating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		return driverId == other.driverId && Objects.equals(licenceNo, other.licenceNo)
				&& Float.floatToIntBits(rating) == Float.floatToIntBits(other.rating);
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", licenceNo=" + licenceNo + ", rating=" + rating + "]";
	}

	public Driver(int driverId, String licenceNo, float rating) {
		super();
		this.driverId = driverId;
		this.licenceNo = licenceNo;
		this.rating = rating;
	}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

}
