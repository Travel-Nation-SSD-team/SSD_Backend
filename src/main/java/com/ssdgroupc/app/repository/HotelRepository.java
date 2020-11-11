package com.ssdgroupc.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.ssdgroupc.app.entity.Hotel;


public interface HotelRepository extends CrudRepository<Hotel, Integer> {

}
