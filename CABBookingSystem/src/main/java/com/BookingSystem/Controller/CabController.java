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

import com.BookingSystem.Entity.Cab;
import com.BookingSystem.Repository.CabRepository;
import com.BookingSystem.Service.CabService;

@Controller
//@RestController
@RequestMapping("/cab")
public class CabController {

	@Autowired
	CabService cabService;
	@Autowired
	CabRepository cabRepository;

	@RequestMapping("/cabs")
	public String viewCabsAllTypes(Model model) {
		List<Cab> cabs = (List<Cab>) cabService.viewCabsAllTypes();
		model.addAttribute("cab_details", cabs);

		return "CabList";
	}

	@RequestMapping(path = "/createcab", method = RequestMethod.POST)
	public String insetCab(Model model, Cab cab) {

		cabService.insetCab(model, cab);
		List<Cab> Cab1 = (List<Cab>) cabService.viewCabsAllTypes();
		model.addAttribute("cab_details", Cab1);

		return "CabList";
	}

	@RequestMapping(path = { "/insertcab", "/edit/{cabId}" })
	public String insetCab(Model model, @PathVariable("cabId") Optional<Integer> cabId) {
		if (cabId.isPresent()) {
			model.addAttribute("cab_details");
		} else {
			model.addAttribute(new Cab());
		}
		return "AddCab";

	}

	@DeleteMapping("/delete/{cabId}")
	public String deleteCab(@PathVariable Integer cabId) {
		if (cabRepository.findById(cabId).isPresent()) {
			cabRepository.deleteById(cabId);
			if (cabRepository.findById(cabId).isPresent())
				return "CabList";
			else
				return "Successfully ";
		} else
			return " not";
	}

	@PutMapping("/cab/update/{cabId}")
	public String ubdateCab(@PathVariable Integer cabId, @RequestBody Cab cab, Model model) {
		model.addAttribute("cab_details");
		return "cabList";
	}

	@GetMapping("/cab/get/{cabId}")
	public ResponseEntity<Cab> viewCabsAllTypes(@PathVariable Integer cabId) {
		if (cabRepository.findById(cabId).isPresent())
			return new ResponseEntity<>(cabRepository.findById(cabId).get(), HttpStatus.OK);
		else
			return null;
	}

}
