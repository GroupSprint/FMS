package com.cg.flightmgmt.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.dto.Booking;
@Repository
public interface IFlightBookingRepository extends JpaRepository<Booking, BigInteger>{

	@Query(value="SELECT b FROM Booking b WHERE b.bookingDate IN (:bookingdate)")
	List<Booking> viewBookingList(Date bookingdate);
	
	@Query(value = "select b from Booking b where b.userId in (:userid)")
	List<Booking> viewBookingHistory(BigInteger userid);

}
