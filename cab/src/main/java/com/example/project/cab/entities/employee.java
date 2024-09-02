package com.example.project.cab.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "employee")
public class employee {

		@Id
		@Column(name = "employeeId")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int employeeId;
		@Column(name = "employeename")
		private String employeename;
		@Column(name = "address")
		private int address;
	
		@OneToMany(fetch = FetchType.EAGER)
		@JoinTable(name="cab")
		@Column(name = "bookedcab")
		private String bookedcab;

		public String getEmployeename() {
			return employeename;
		}

		public void setEmployeename(String employeename) {
			this.employeename = employeename;
		}

		public employee(String employeename, int address, String bookedcab) {
			super();
			this.employeename = employeename;
			this.address = address;
			this.bookedcab = bookedcab;
		}

		@Override
		public String toString() {
			return "employee [employeeId=" + employeeId + ", employeename=" + employeename + ", address=" + address
					+ ", bookedcab=" + bookedcab + "]";
		}

		public int getAddress() {
			return address;
		}

		public void setAddress(int address) {
			this.address = address;
		}

		public String getBookedcab() {
			return bookedcab;
		}

		public void setBookedcab(String bookedcab) {
			this.bookedcab = bookedcab;
		}
}
