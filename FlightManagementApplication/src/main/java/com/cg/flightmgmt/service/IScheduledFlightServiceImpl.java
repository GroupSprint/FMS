package com.cg.flightmgmt.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.repository.IScheduledFlightRepository;

@Service
public class IScheduledFlightServiceImpl implements IScheduledFlightService {

	@Autowired IScheduledFlightRepository iScheduledFlightRepository;

	@Override
	public ScheduledFlight addFlightSchedule(ScheduledFlight scheduledFlight) {
		return iScheduledFlightRepository.save(scheduledFlight);
	}

	@Override
	public ScheduledFlight viewFlightSchedule(int id) {

		Optional<ScheduledFlight> scheduledFlight = iScheduledFlightRepository.findById(id);

		if (scheduledFlight.isPresent()) {
			return scheduledFlight.get();
		} else {
			return null;
		}
	}

	@Override
	public ScheduledFlight removeFlightSchedule(int id) {
		Optional<ScheduledFlight> scheduledFlight = iScheduledFlightRepository.findById(id);
		if (scheduledFlight.isPresent()) {
			iScheduledFlightRepository.delete(scheduledFlight.get());
		}
		return null;
	}

	@Override
	public ScheduledFlight updateFlightSchedule(ScheduledFlight flight) {
		int id = flight.getScheduleFlightId();
		ScheduledFlight flightData = iScheduledFlightRepository.findById(id).orElse(null);
		if (flightData == null) {
			return null;
		}
		return iScheduledFlightRepository.save(flight);
	}

	@Override
	public List<ScheduledFlight> viewAllScheduledFlights() {
		List<ScheduledFlight> list = iScheduledFlightRepository.findAll();
		return list;
	}

	@Override
	public List<ScheduledFlight> viewAllScheduledFlights(LocalDateTime arrivaldate) {
		System.out.println(arrivaldate);
		List<ScheduledFlight> list = iScheduledFlightRepository.findAllBySchedule(arrivaldate);
		return list;
	}
}
