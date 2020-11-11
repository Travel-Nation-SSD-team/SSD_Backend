package com.ssdgroupc.app.repository;
import org.springframework.data.repository.CrudRepository;

import com.ssdgroupc.app.entity.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
	
	
}
