package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;
import com.cg.flightmgmt.service.IFlightService;

@RestController
@RequestMapping("/fms/flight/v1")
public class FlightController {
	@Autowired IFlightService service;
	
	@PostMapping("/addFlight")
	public ResponseEntity<String> addFlight(@RequestBody Flight flight){
		String flightData=service.addFlight(flight);
		return new ResponseEntity<String>(flightData,HttpStatus.OK);
	}
	
	@GetMapping("/viewFlight/{id}")
	public ResponseEntity<Flight> viewFlight(@PathVariable BigInteger id) throws FlightNotFoundException{
		Flight flight=service.viewFlight(id);
		if(flight==null) {
			throw new FlightNotFoundException();
		}
		return new ResponseEntity<Flight>(flight,HttpStatus.OK);	
	}
	
	@GetMapping("/viewAllFlights")
	public ResponseEntity<Set<Flight>> viewAllFlights(){
		Set<Flight> flightList=service.viewAllFlights();
		return new ResponseEntity<Set<Flight>>(flightList,HttpStatus.OK);	
	}
	
	@PutMapping("/updateFlight")
	public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight) throws FlightNotFoundException {
		Flight flightData = service.updateFlight(flight);
		if(flightData==null) {
			 throw new FlightNotFoundException();
		}
		return new ResponseEntity<Flight>(flightData, HttpStatus.OK);
	}
	
	@DeleteMapping("/removeFlight/{id}")
	  public ResponseEntity<Flight> removeFlight(@PathVariable BigInteger id){
	  Flight flightData=service.removeFlight(id);
	 return new ResponseEntity<Flight>(flightData,HttpStatus.OK);
	}
}
