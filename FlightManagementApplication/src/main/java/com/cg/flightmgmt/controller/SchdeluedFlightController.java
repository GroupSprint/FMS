package com.cg.flightmgmt.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.service.IScheduledFlightService;

@RestController
@RequestMapping("/fms/Flight")
public class SchdeluedFlightController 
{ 
	@Autowired 
	IScheduledFlightService scheduleService;
 
	@PostMapping("/addScheduledFlight")
	public ResponseEntity<ScheduledFlight> addFlightSchedule(ScheduledFlight flight)
	{  
		ScheduledFlight scheduledFlight = scheduleService.addFlightSchedule(flight);
		 return  new ResponseEntity<ScheduledFlight>(scheduledFlight , HttpStatus.OK); 
		
	}
	
	
	@DeleteMapping("/deleteScheduledFlightById/{id}")
	public ResponseEntity<ScheduledFlight> deleteScheduledFlightById(@PathVariable int id){
			ScheduledFlight scheduleFlightData=scheduleService.removeFlightSchedule(id);
			if(scheduleFlightData==null) {
				return new ResponseEntity("Sorry! Flight not available!", HttpStatus.NOT_FOUND);
			}
			scheduleFlightData=null;
		return new ResponseEntity<ScheduledFlight>(scheduleFlightData,HttpStatus.OK);
	}
	
	
	@PutMapping("/updateScheduledFlight")
	public ResponseEntity<ScheduledFlight> updateScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
		ScheduledFlight scheduledFlightData=scheduleService.updateFlightSchedule(scheduledFlight);
		if(scheduledFlightData==null) {
			return new ResponseEntity("Sorry! Flight not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ScheduledFlight>(scheduledFlightData,HttpStatus.OK);
	}
	
	
	@GetMapping("/viewScheduledFlightById/{id}")
	public ResponseEntity<ScheduledFlight> viewScheduledFlightById(@PathVariable int id){
		ScheduledFlight scheduledFlightData=scheduleService.viewFlightSchedule(id);
		if(scheduledFlightData==null) {
			return new ResponseEntity("Sorry! Flight not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ScheduledFlight>(scheduledFlightData,HttpStatus.OK);
	}
	
	@GetMapping("/viewAllScheduledFlight")
    public ResponseEntity<List<ScheduledFlight>> viewAllScheduledFlight(){
        List<ScheduledFlight> scheduledFlightData=scheduleService.viewAllScheduledFlights();
        return new ResponseEntity<List<ScheduledFlight>>(scheduledFlightData,HttpStatus.OK);
    }
    
    @GetMapping("/viewAllScheduleByDate")
    public ResponseEntity<List<ScheduledFlight>> viewAllScheduled(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){
        List<ScheduledFlight> scheduledFlightData=scheduleService.viewAllScheduledFlights(date);
        return new ResponseEntity<List<ScheduledFlight>>(scheduledFlightData,HttpStatus.OK);
    }
	
}
