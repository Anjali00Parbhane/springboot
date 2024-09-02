package com.example.project.cab.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cab")
public class Cab {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cabNo;
	@Column(name = "seatsBooked")
	private int seatsBooked;
	@Column(name = "nextAvailableAt")
	private int nextAvailableAt;
	@Column(name = "route")
	private String route;

	@Override
	public String toString() {
		return "Cab [cabNo=" + cabNo + ", seatsBooked=" + seatsBooked + ", nextAvailableAt=" + nextAvailableAt
				+ ", route=" + route + "]";
	}

	public Cab() {

	}

	public Cab(int seatsBooked, int nextAvailableAt, String route) {
		super();
		
		this.seatsBooked = seatsBooked;
		this.nextAvailableAt = nextAvailableAt;
		this.route = route;
	}

	public int getCabNo() {
		return cabNo;
	}

	public void setCabNo(int cabNo) {
		this.cabNo = cabNo;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public int getNextAvailableAt() {
		return nextAvailableAt;
	}

	public void setNextAvailableAt(int nextAvailableAt) {
		this.nextAvailableAt = nextAvailableAt;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}
}
