package com.example.project.cab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.cab.entities.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer>{

}
