package com.cg.flightmgmt.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Schedule {
	@Id
	private Integer scheduleId;
	private LocalDateTime airrivalTime;
	private LocalDateTime departureTime;
	@OneToOne
	private Airport sourceAirport;
	@OneToOne
	private Airport destinationAirport;

	public Airport getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public LocalDateTime getAirrivalTime() {
		return airrivalTime;
	}

	public void setAirrivalTime(LocalDateTime airrivalTime) {
		this.airrivalTime = airrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

}
