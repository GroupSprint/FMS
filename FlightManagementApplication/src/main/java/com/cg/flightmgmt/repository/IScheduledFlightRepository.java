package com.cg.flightmgmt.repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.flightmgmt.dto.ScheduledFlight;

@Repository
public interface IScheduledFlightRepository extends JpaRepository<ScheduledFlight, Integer> {

	@Query(value = "select s from ScheduledFlight s where s.schedule.scheduleId IN (select ap.scheduleId from Schedule ap where ap.airrivalTime in (:arrivaldate))")
	public List<ScheduledFlight> findAllBySchedule(LocalDateTime arrivaldate);

	@Query(value = "select s from ScheduledFlight s where s.schedule.scheduleId IN (select ap.scheduleId from Schedule ap where ap.airrivalTime between (:date1) and (:date2))")
	public List<ScheduledFlight> viewAllScheduledFlights(Date date1, Date date2);
}
