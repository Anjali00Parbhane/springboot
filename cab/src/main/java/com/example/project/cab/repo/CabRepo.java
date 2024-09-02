package com.example.project.cab.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.project.cab.entities.Cab;


public interface CabRepo extends JpaRepository<Cab, Integer> {


    @Query("SELECT u FROM Cab u WHERE u.route LIKE %:place%")
    List<Cab> getCabsByPlace(@Param("place") String place);
    
    ///cab/available
    @Query("SELECT u from Cab u WHERE u.seatsBooked < 4 AND u.nextAvailableAt >= :time")
    List<Cab> getCabsByAvailability(@Param("time") int time);
    
    ///cab/booked
    @Query("SELECT u FROM Cab u WHERE u.seatsBooked = 4")
    List<Cab> getBookedCabs();
    
}
