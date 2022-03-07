package com.BookingSystem.Entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TripBooking_table")
public class TripBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tripBookingId;
	private int customerId;
	private String fromLocation;
	private String toLocation;
	private String fromDateTime;
	private String toDateTime;
	private boolean status;
	private float distanceInKm;
	private float bill;

	public int getTripBookingId() {
		return tripBookingId;
	}

	public void setTripBookingId(int tripBookingId) {
		this.tripBookingId = tripBookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getFromDateTime() {
		return fromDateTime;
	}

	public void Date(String fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public String getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(String toDateTime) {
		this.toDateTime = toDateTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public float getDistanceInKm() {
		return distanceInKm;
	}

	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bill, customerId, distanceInKm, fromDateTime, fromLocation, status, toDateTime, toLocation,
				tripBookingId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TripBooking other = (TripBooking) obj;
		return Float.floatToIntBits(bill) == Float.floatToIntBits(other.bill) && customerId == other.customerId
				&& Float.floatToIntBits(distanceInKm) == Float.floatToIntBits(other.distanceInKm)
				&& Objects.equals(fromDateTime, other.fromDateTime) && Objects.equals(fromLocation, other.fromLocation)
				&& status == other.status && Objects.equals(toDateTime, other.toDateTime)
				&& Objects.equals(toLocation, other.toLocation) && tripBookingId == other.tripBookingId;
	}

	@Override
	public String toString() {
		return "TripBooking [tripBookingId=" + tripBookingId + ", customerId=" + customerId + ", fromLocation="
				+ fromLocation + ", toLocation=" + toLocation + ", fromDateTime=" + fromDateTime + ", toDateTime="
				+ toDateTime + ", status=" + status + ", distanceInKm=" + distanceInKm + ", bill=" + bill + "]";
	}

	public TripBooking(int tripBookingId, int customerId, String fromLocation, String toLocation, String fromDateTime,
			String toDateTime, boolean status, float distanceInKm, float bill) {
		super();
		this.tripBookingId = tripBookingId;
		this.customerId = customerId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.status = status;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}

	public TripBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

}
