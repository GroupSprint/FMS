package com.cg.flightmgmt.dto;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Flight {
	@Id
	private BigInteger flightId;
	private String carrierName;
	private String flightModel;
	private int seatCapacity;
	private Boolean flightState;
	@OneToOne(mappedBy = "flight", cascade = CascadeType.ALL)
	private ScheduledFlight schFlight;

	public BigInteger getFlightId() {
		return flightId;
	}

	public void setFlightId(BigInteger flightId) {
		this.flightId = flightId;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public Boolean getFlightState() {
		return flightState;
	}

	public void setFlightState(Boolean flightState) {
		this.flightState = flightState;
	}

	public ScheduledFlight getSchFlight() {
		return schFlight;
	}

	public void setSchFlight(ScheduledFlight schFlight) {
		this.schFlight = schFlight;
	}

}
