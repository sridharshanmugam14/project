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
import org.springframework.web.bind.annotation.RequestMethod;

import com.BookingSystem.Entity.Driver;
import com.BookingSystem.Repository.DriverRepository;
import com.BookingSystem.Service.DriverService;

@Controller
@RequestMapping("/driver")
public class DriverController {
	@Autowired
	DriverService driverService;
	@Autowired
	DriverRepository driverRepository;

	@RequestMapping("/drivers")
	public String getAllDrivers(Model model) {
		List<Driver> drivers = (List<Driver>) driverService.getAllDrivers();
		model.addAttribute("driver_details", drivers);

		return "DriverList";
	}

	@RequestMapping(path = "/createdriver", method = RequestMethod.POST)
	public String insertDriver(Model model, Driver driver) {

		driverService.insertDriver(model, driver);
		List<Driver> Cab1 = (List<Driver>) driverService.getAllDrivers();
		model.addAttribute("cab_details", Cab1);

		return "DriverList";
	}

	@RequestMapping(path = { "/adddriver", "/adddriver/{driverId}" })
	public String insertDriver(Model model, @PathVariable("driverId") Optional<Integer> driverId) {
		if (driverId.isPresent()) {
			model.addAttribute("driver_details");
		} else {
			model.addAttribute(new Driver());
		}
		return "AddDriver";

	}

	@GetMapping("/driver/get/{driverId}")
	public ResponseEntity<Driver> getAllDrivers(@PathVariable int driverId) {
		if (driverRepository.findById(driverId).isPresent())
			return new ResponseEntity<>(driverRepository.findById(driverId).get(), HttpStatus.OK);
		else
			return null;
	}

	@DeleteMapping("/driver/delete/{driverId}")
	public ResponseEntity<Object> deleteAbstractUser(@PathVariable int driverId) {
		if (driverRepository.findById(driverId).isPresent()) {
			driverRepository.deleteById(driverId);
			if (driverRepository.findById(driverId).isPresent())
				return ResponseEntity.unprocessableEntity().body("Failed to delete the specified Driver");
			else
				return ResponseEntity.ok("Successfully deleted the specified Driver");
		} else
			return ResponseEntity.unprocessableEntity().body("Specified Driver not present");
	}

	@PutMapping("/updatederiver/{driverId}")
	public ResponseEntity<Object> updateDriver(@PathVariable int driverId, @RequestBody Driver driver) {
		return driverService.updateDriver(driverId, driver);
	}

}
