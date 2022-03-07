package com.BookingSystem.Service;

import java.util.List;

import org.springframework.ui.Model;

import com.BookingSystem.Entity.Cab;

public interface CabService {
	
	public List<Cab> viewCabsAllTypes();

	public String insetCab(Model model,Cab cab);
	public String updateCab(Integer cabId, Cab cab);
	
	

}
