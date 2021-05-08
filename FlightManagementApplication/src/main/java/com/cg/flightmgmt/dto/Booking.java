package com.cg.flightmgmt.dto;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Booking {
	@Id
	private BigInteger bookingId;
	private LocalDate bookingDate;
	private double ticketCost;
	private int noOfPassangers;
	private Boolean bookingState;
	@ManyToOne
	private User userId;
	@OneToMany(mappedBy = "booking")
	private List<Passenger> passengerList;
	@OneToOne
	private ScheduledFlight schFlight;

	public BigInteger getBookingId() {
		return bookingId;
	}

	public void setBookingId(BigInteger bookingId) {
		this.bookingId = bookingId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public double getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}

	public ScheduledFlight getSchFlight() {
		return schFlight;
	}

	public void setSchFlight(ScheduledFlight schFlight) {
		this.schFlight = schFlight;
	}

	public int getNoOfPassangers() {
		return noOfPassangers;
	}

	public void setNoOfPassangers(int noOfPassangers) {
		this.noOfPassangers = noOfPassangers;
	}

	public Boolean getBookingState() {
		return bookingState;
	}

	public void setBookingState(Boolean bookingState) {
		this.bookingState = bookingState;
	}

}
