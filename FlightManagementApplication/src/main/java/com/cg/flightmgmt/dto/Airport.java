package com.cg.flightmgmt.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
// Airport Class
public class Airport {
	@Id
	private int airportid;
	private String airportName;
	private String airportLocation;

	public int getAirportid() {
		return airportid;
	}

	public void setAirportid(int airportid) {
		this.airportid = airportid;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportLocation() {
		return airportLocation;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}

}
