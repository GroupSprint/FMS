package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.repository.IFlightBookingRepository;
import com.cg.flightmgmt.repository.IFlightRepository;

@Service
public class IFlightBookingServiceImpl implements IFlightBookingService{
	@Autowired
	IFlightBookingRepository bookingRepository;
	@Autowired
	IFlightRepository flrepository;
	
	@Override
	public Booking addBooking(Booking booking) {
		Booking booking1 = bookingRepository.save(booking);
		return booking1;
	}

	@Override
	public Booking cancelBooking(BigInteger bookingid) throws BookingNotFoundException {
		Booking booking=bookingRepository.findById(bookingid).orElse(null);
		if(booking==null) {
			return null;
		}
		booking.setPassengerList(null);
		booking.setSchFlight(null);
		bookingRepository.deleteById(bookingid);
		return booking;
	}

	@Override
	public Booking viewBooking(BigInteger bookingid) throws BookingNotFoundException {
		Optional<Booking> booking = bookingRepository.findById(bookingid);
		if(booking.isPresent())
		{
			return booking.get();
		}
		else
		{
			throw new BookingNotFoundException();
		}
	}

	@Override
	public List<Booking> viewBookingList(Date bookingdate) {
		List<Booking> list=bookingRepository.viewBookingList(bookingdate);
		return list;
	}

	@Override
	public List<Booking> viewBookingList(BigInteger flightid) {
		
        return null;
	}

	@Override
	public List<Booking> viewBookingHistory(BigInteger userid) {
		return bookingRepository.viewBookingHistory(userid);
	}

	@Override
	public Booking updateBooking(Booking booking) {
		Booking booking1 = bookingRepository.save(booking);
		return booking1;
	}

}
