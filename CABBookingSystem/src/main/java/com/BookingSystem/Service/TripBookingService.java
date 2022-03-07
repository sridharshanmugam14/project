package com.BookingSystem.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import com.BookingSystem.Entity.TripBooking;

public interface TripBookingService {
	public List<TripBooking> getAllTrip();
	
	public String createTrip(Model model, TripBooking booking);
	 public ResponseEntity<Object> updateTrip(Integer tripBookingId, TripBooking booking);

}
