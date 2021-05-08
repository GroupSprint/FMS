package com.cg.flightmgmt.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ScheduledFlight {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer scheduleFlightId;
	private double fares;
	private Boolean scheduleFlightState;
	private int availableSeats;
	@OneToOne
	private Flight flight;
//	@OneToOne
//	private Schedule schedule;

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

//	public Schedule getSchedule() {
//		return schedule;
//	}
//
//	public void setSchedule(Schedule schedule) {
//		this.schedule = schedule;
//	}

	public double getFares() {
		return fares;
	}

	public void setFares(double fares) {
		this.fares = fares;
	}

	public Integer getScheduleFlightId() {
		return scheduleFlightId;
	}

	public void setScheduleFlightId(Integer scheduleFlightId) {
		this.scheduleFlightId = scheduleFlightId;
	}

	public Boolean getScheduleFlightState() {
		return scheduleFlightState;
	}

	public void setScheduleFlightState(Boolean scheduleFlightState) {
		this.scheduleFlightState = scheduleFlightState;
	}
}
