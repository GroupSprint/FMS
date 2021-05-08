package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.repository.IFlightRepository;
@Service
public class IFlightServiceImpl implements IFlightService{
	@Autowired IFlightRepository flightRepository;
	
	@Override
	public String addFlight(Flight flight) {
		ScheduledFlight schf = flight.getSchFlight();
		schf.setFlight(flight);
		flight.setSchFlight(schf);
		Flight flight1 = flightRepository.save(flight);
		
		return "done";
	}

	@Override
	public Flight viewFlight(BigInteger flightno) throws FlightNotFoundException {
		Optional<Flight> flight = flightRepository.findById(flightno);
		if(flight.isPresent())
		{
			return flight.get();
		}
		else
		{
			throw new FlightNotFoundException();
		}
	}

	@Override
	public Set<Flight> viewAllFlights() {
		Set<Flight> flight=new HashSet<Flight>();
		List<Flight> flightList=new ArrayList<Flight>(flight);
		flightRepository.findAll().forEach(flight1->flight.add(flight1));
		return flight;	
	}

	@Override
	public Flight removeFlight(BigInteger flightno) {
		Optional<Flight> flight = flightRepository.findById(flightno);
		if(flight.isPresent())
		{
			flightRepository.deleteById(flightno);
		}
		return flight.get();
	}

	@Override
	public Flight updateFlight(Flight flight) {
		Flight flight1 = flightRepository.save(flight);
		return flight1;
	}

}
