package com.example.project.cab.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.cab.entities.Booking;
import com.example.project.cab.entities.Cab;
import com.example.project.cab.services.CabService;

@RestController
@CrossOrigin("*")
public class Controller {
	@Autowired
	CabService cabService;
	@PostMapping("cab")
	public void save(@RequestBody Cab cab) {
		cabService.addCab(cab);
	}
	@GetMapping("cabs")
	public List<Cab> dummyCustomer() {
		
		return cabService.getAllCabs();
	}
	@GetMapping("cab/{cabNo}")
	public Cab getCabByCabNo(@PathVariable("cabNo") int cabNo) {
		return cabService.getCabByCabNo(cabNo);
	}
	@GetMapping("cab/place/{place}")
	public List<Cab> getCabByPlace(@PathVariable("place") String place) {
		return cabService.getCabsByPlace(place);
	}
	@GetMapping("cab/available/{time}")
	public List<Cab> getCabsByAvailability(@PathVariable("time") int time){
		return cabService.getCabsByAvailability(time);
	}
	@GetMapping("cab/booked")
	public List<Cab> getBookedCabs(){
		return cabService.getBookedCabs();
	}
	@PutMapping("cab")
	public void update(@RequestBody Cab cab) {
		cabService.updateCab(cab);
	}
	@PutMapping("cab/book/{cabNo}/{numOfSeats}")
	public Map<String, Integer> bookCab(@PathVariable("cabNo") int cabNo, @PathVariable("numOfSeats") int numOfSeats ) {
		
		return cabService.bookCab(cabNo, numOfSeats);
		
	}
	@DeleteMapping("cab/{cabNo}")
	public void deleteCabById(@PathVariable("cabNo") int cabNo) {
		cabService.deleteCabById(cabNo);
	}
	@GetMapping("bookings")
	public List<Booking> getBookings(){
		return cabService.getBookings();
	}
	
}
