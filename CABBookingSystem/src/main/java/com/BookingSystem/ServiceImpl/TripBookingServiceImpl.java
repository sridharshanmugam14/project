package com.BookingSystem.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.BookingSystem.Entity.TripBooking;
import com.BookingSystem.Repository.TripBookingRepository;
import com.BookingSystem.Service.TripBookingService;

@Service
public class TripBookingServiceImpl implements TripBookingService {
	@Autowired
	TripBookingRepository tripBookingRepository;

	public List<TripBooking> getAllTrip() {
		// TODO Auto-generated method stub
		List<TripBooking> trip = new ArrayList<>();
		try {
			trip = (List<TripBooking>) tripBookingRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return trip;
	}

	@Transactional
	public String createTrip(Model model, TripBooking booking){

		TripBooking savetrip = tripBookingRepository.save(booking);
		if (tripBookingRepository.findById(savetrip.getTripBookingId()).isPresent())
			return "trip sucessfuly booking";
		else {
			return "faild trip booking";
		}

	}

	public ResponseEntity<Object> updateTrip(Integer tripBookingId, TripBooking booking) {
		if (tripBookingRepository.findById(tripBookingId).isPresent()) {
			TripBooking trips = tripBookingRepository.findById(tripBookingId).get();

			trips.setCustomerId(booking.getCustomerId());
			trips.setFromLocation(booking.getFromLocation());
			trips.setToLocation(booking.getToLocation());
			trips.setToDateTime(booking.getFromDateTime());
			trips.setToDateTime(booking.getToDateTime());
			trips.setStatus(booking.isStatus());
			trips.setBill(booking.getBill());
			trips.setDistanceInKm(booking.getDistanceInKm());
			trips.setBill(booking.getBill());

			TripBooking savetrip = tripBookingRepository.save(trips);
			if (tripBookingRepository.findById(savetrip.getCustomerId()).isPresent())
				return ResponseEntity.ok().body("sucessful upadete the driver");
			else
				return ResponseEntity.ok().body("faild upadate the driver");
		} else {
			return ResponseEntity.ok().body("Driver not found");
		}
	}
}
