package com.BookingSystem.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.BookingSystem.Entity.Cab;
import com.BookingSystem.Repository.CabRepository;
import com.BookingSystem.Service.CabService;

@Service
public class CabServiceImpl implements CabService {

	@Autowired
	CabRepository cabRepository;

//	public List<Cab> viewCabsAllTypes() {
//		List<Cab> cab = new ArrayList<>();
//		try {
//			cab = (List<Cab>) cabRepository.findAll();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//		return cab;
//
//	}
	@Override
	public List<Cab> viewCabsAllTypes() {
		// TODO Auto-generated method stub
		return cabRepository.findAll();
	}

	@Transactional
	public String insetCab(Model model, Cab cab) {
		Cab car = new Cab();

		car.setCarType(cab.getCarType());
		car.setPerKmRate(cab.getPerKmRate());

		Cab savedOrg = cabRepository.save(car);
		if (cabRepository.findById(savedOrg.getCabId()).isPresent())
			return "savedOrg";
		else
			return "false";
	}

	@Override
//	public Object insetCab(Model model, Cab cab) {
//		// TODO Auto-generated method stub
//		 cabRepository.save(cab);
//	}
	@Transactional
	public String updateCab(Integer cabId, Cab cab) {

		if (cabRepository.findById(cabId).isPresent()) {
			Cab car = cabRepository.findById(cabId).get();
			car.setPerKmRate(cab.getPerKmRate());
			car.setCarType(cab.getCarType());
			Cab saveUser = cabRepository.save(car);
			if (cabRepository.findById(saveUser.getCabId()).isPresent())
				return "suessfuly upate the cab ";
			else
				return "faild upate the cab ";
		} else
			return "the specified cab not found";

	}

}
