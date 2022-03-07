package com.BookingSystem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BookingSystem.Entity.TripBooking;
import com.BookingSystem.Repository.TripBookingRepository;
import com.BookingSystem.Service.TripBookingService;

@Controller
@RequestMapping("/tripBooking")
public class TripBookingController {
	@Autowired
	TripBookingService tripBookingService;

	@Autowired
	TripBookingRepository tripBookingRepository;

	@RequestMapping("/trips")
	public String getAllTrip(Model model) {
		List<TripBooking> trip = (List<TripBooking>) tripBookingService.getAllTrip();
		model.addAttribute("TripBooking_table", trip);

		return "TripBookingList";
	}

	@RequestMapping("/cretatetrip")
	public String insertTrip(Model model, TripBooking booking) {
		tripBookingService.createTrip(model, booking);
		List<TripBooking> trip = (List<TripBooking>) tripBookingService.getAllTrip();
		model.addAttribute("TripBooking_table", trip);
		return "TripBookingList";
	}

	@RequestMapping(path = { "/inserttrip", "/edit/{tripBookingId}" })
	public String insettrip(Model model, @PathVariable("tripBookingId") Optional<Integer> tripBookingId) {
		if (tripBookingId.isPresent()) {
			model.addAttribute("TripBooking_table");
		} else {
			model.addAttribute(new TripBooking());
		}
		return "AddTripBooking";

	}

	@GetMapping("/cab/get/{tripBookingId}")
	public ResponseEntity<TripBooking> getAllTrip(@PathVariable Integer tripBookingId) {
		if (tripBookingRepository.findById(tripBookingId).isPresent())
			return new ResponseEntity<>(tripBookingRepository.findById(tripBookingId).get(), HttpStatus.OK);
		else
			return null;
	}

	@DeleteMapping("/trip/delete/{tripBookingId}")
	public ResponseEntity<Object> deleteTrip(@PathVariable Integer tripBookingId) {
		if (tripBookingRepository.findById(tripBookingId).isPresent()) {
			tripBookingRepository.deleteById(tripBookingId);
			if (tripBookingRepository.findById(tripBookingId).isPresent())
				return ResponseEntity.unprocessableEntity().body("Failed to delete the specified tripBooking");
			else
				return ResponseEntity.ok("Successfully tripBooking the specified Driver");
		} else
			return ResponseEntity.unprocessableEntity().body("Specified tripBooking not present");
	}

	@PutMapping("/updatetrip/{tripBookingId}")
	public ResponseEntity<Object> updateTrip(@PathVariable Integer tripBookingId,
			@RequestBody TripBooking tripBooking) {
		return tripBookingService.updateTrip(tripBookingId, tripBooking);
	}

}
