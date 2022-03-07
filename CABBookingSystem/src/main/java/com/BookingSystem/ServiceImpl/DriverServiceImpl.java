package com.BookingSystem.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.BookingSystem.Entity.Driver;
import com.BookingSystem.Repository.DriverRepository;
import com.BookingSystem.Service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
	@Autowired
	DriverRepository driverRepository;

	public List<Driver> getAllDrivers() {
		// TODO Auto-generated method stub
		List<Driver> drivers = new ArrayList<>();
		try {
			drivers = (List<Driver>) driverRepository.findAll();
		} catch (Exception e) {

			// TODO: handle exception
			e.printStackTrace();
		}

		return drivers;
	}

	@Transactional
	public String insertDriver(Model model, Driver driver) {
		// TODO Auto-generated method stub
		Driver drivers = new Driver();

		drivers.setLicenceNo(driver.getLicenceNo());

		drivers.setRating(driver.getRating());

		Driver savedOrg = driverRepository.save(driver);
		if (driverRepository.findById(savedOrg.getDriverId()).isPresent())
			return "savedOrg";
		else
			return "Failed to create the organization specified.";

	}

	public ResponseEntity<Object> updateDriver(Integer driverId, Driver driver) {
		if (driverRepository.findById(driverId).isPresent()) {
			Driver drivers = driverRepository.findById(driverId).get();
			drivers.setLicenceNo(driver.getLicenceNo());
			drivers.setRating(driver.getRating());
			Driver saveDriver = driverRepository.save(drivers);
			if (driverRepository.findById(saveDriver.getDriverId()).isPresent())
				return ResponseEntity.ok().body("sucessful upadete the driver");
			else
				return ResponseEntity.ok().body("faild upadate the driver");
		} else {
			return ResponseEntity.ok().body("Driver not found");
		}
	}

}
