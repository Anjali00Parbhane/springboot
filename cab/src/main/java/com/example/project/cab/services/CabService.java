package com.example.project.cab.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.cab.entities.Booking;
import com.example.project.cab.entities.Cab;
import com.example.project.cab.exceptions.BookedCabDeletionException;
import com.example.project.cab.exceptions.MaxRoutesExceededException;
import com.example.project.cab.exceptions.SeatAvailabiltyException;
import com.example.project.cab.repo.BookingRepo;
import com.example.project.cab.repo.CabRepo;
@Service
public class CabService {
@Autowired
CabRepo cabRepo;
@Autowired
BookingRepo bookingRepo;

public List<Cab> getAllCabs(){
	return cabRepo.findAll();
	
}
public Cab getCabByCabNo(int cabNo) {
	return cabRepo.findById(cabNo).get();
}
public void addCab(Cab cab) {
	
	if(cab.getRoute().split(",").length > 5) {
		throw new MaxRoutesExceededException("Number of routes cannot exceed 5");
		
	}
	
	cabRepo.save(cab);
}
public List<Cab> getCabsByPlace(String place) {
	// TODO Auto-generated method stub
	return cabRepo.getCabsByPlace(place);
}

public List<Cab> getCabsByAvailability(int time) {
	// TODO Auto-generated method stub
	return cabRepo.getCabsByAvailability(time);
}
public List<Cab> getBookedCabs(){
	return cabRepo.getBookedCabs();
}
public void updateCab(Cab cab) {
	// TODO Auto-generated method stub
	Cab toUpdate=cabRepo.findById(cab.getCabNo()).get();
	if(toUpdate != null) {
		cabRepo.save(cab);
	}
	
}
public Map<String, Integer> bookCab(int cabNo, int numOfSeats) {
	// TODO Auto-generated method stub
	Cab toBook=cabRepo.findById(cabNo).get();
	int bookedAt=-1;
	if(toBook != null) {
		if(numOfSeats<=(4-toBook.getSeatsBooked())) {
			toBook.setSeatsBooked(toBook.getSeatsBooked()+numOfSeats);
			Booking newBooking= new Booking(cabNo, toBook.getNextAvailableAt(), numOfSeats);
			bookingRepo.save(newBooking);
			bookedAt=toBook.getNextAvailableAt();
			if(toBook.getSeatsBooked()==4) {
				toBook.setNextAvailableAt(toBook.getNextAvailableAt()+1);
			}
			cabRepo.save(toBook);
			
		}
		else {
			throw new SeatAvailabiltyException("Number of Seats desired aren't available");
		}
		
	}
	Map<String, Integer> map = new HashMap<>();
	map.put("Cab No", cabNo);
	map.put("Cab Time", bookedAt);
	map.put("Number of seats booked", numOfSeats);
	return map;
	/*
	String result="{";
	result +=cabNo+","+toBook.getNextAvailableAt()+","+numOfSeats+"}";
	return result;
	*/
	
}
public void deleteCabById(int cabNo) {
	// TODO Auto-generated method stub
	Cab toDelete=cabRepo.findById(cabNo).get();
	if(toDelete.getSeatsBooked()==0) {
		cabRepo.deleteById(cabNo);
	}
	else {
		throw new BookedCabDeletionException("Cab cannot be delete as it has been booked");
	}
	
}
public List<Booking> getBookings(){
	return	bookingRepo.findAll();
}

}
