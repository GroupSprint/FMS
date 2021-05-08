package com.cg.flightmgmt.service;

import java.time.LocalDateTime;
import java.util.List;
import com.cg.flightmgmt.dto.ScheduledFlight;

public interface IScheduledFlightService {
	
//	public Flight addFlightSchedule(Flight flight);
//	public Flight viewFlightSchedule(BigInteger flightno);
//	public Flight removeFlightSchedule(BigInteger flightno);
//	public Flight updateFlightSchedule(ScheduledFlight flight);
//	public List<ScheduledFlight> viewAllScheduledFlights();
//	public List<ScheduledFlight> viewAllScheduledFlights(Date arrivaldate);
//	public List<ScheduledFlight> viewAllScheduledFlights(Date date1,Date date2);
	public ScheduledFlight addFlightSchedule(ScheduledFlight scheduledFlight);
	public ScheduledFlight viewFlightSchedule(int id) ;
	public ScheduledFlight removeFlightSchedule(int id) ;
	public ScheduledFlight updateFlightSchedule(ScheduledFlight flight);
	public List<ScheduledFlight> viewAllScheduledFlights();
	public List<ScheduledFlight> viewAllScheduledFlights(LocalDateTime arrivaldate);
}
