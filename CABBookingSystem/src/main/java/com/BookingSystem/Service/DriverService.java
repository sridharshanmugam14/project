package com.BookingSystem.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import com.BookingSystem.Entity.Driver;

public interface DriverService {
	public List<Driver> getAllDrivers();

	public String insertDriver(Model model, Driver driver);
	public ResponseEntity<Object> updateDriver(Integer driverId, Driver driver);

	

}
