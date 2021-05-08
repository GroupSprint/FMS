package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.service.IFlightBookingService;

@RestController
@RequestMapping("/flightBooking")
public class IFlightBookingController {
	@Autowired
	IFlightBookingService fbService;
	@PostMapping("/addBooking")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking)
	{
		Booking newBooking = fbService.addBooking(booking);

		return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/cancelBooking/{bookingId}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable BigInteger bookingId) throws BookingNotFoundException
	{
		Booking newBooking = fbService.cancelBooking(bookingId);
		newBooking = null;
		return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
	}
	
	
	
	  @GetMapping("/viewBooking/{bookingId}") public ResponseEntity<Booking>
	  viewBooking(@PathVariable BigInteger bookingId) throws
	  BookingNotFoundException { Booking newBooking =
	  fbService.viewBooking(bookingId); return new
	  ResponseEntity<Booking>(newBooking, HttpStatus.OK); }
	 
	 
	
	@GetMapping("/viewBookingByDate")
	public ResponseEntity<List<Booking>> viewBookingByDate(
			@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
		List<Booking> list = fbService.viewBookingList(date);
		return new ResponseEntity<List<Booking>>(list, HttpStatus.OK);
	}
	
	@PutMapping("/updateBooking")
	public ResponseEntity<Booking> updateBooking( @RequestBody Booking booking) throws BookingNotFoundException {
		Booking newBooking = fbService.updateBooking(booking);
		return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
	}
	
	@GetMapping("/viewBookingHistory")
    public ResponseEntity<List<Booking>> viewBookingHistory(@PathVariable BigInteger userid){
        List<Booking> list = fbService.viewBookingHistory(userid);
        return new ResponseEntity<List<Booking>>(list, HttpStatus.OK);
    }
}
