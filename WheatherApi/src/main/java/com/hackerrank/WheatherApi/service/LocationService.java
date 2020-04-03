package com.hackerrank.WheatherApi.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.WheatherApi.model.Location;
import com.hackerrank.WheatherApi.repository.LocationRepository;

@Service
@Transactional
public class LocationService {

	@Autowired
	LocationRepository locationRepository;
	
	public Location insert(Location location) {
		return locationRepository.save(location);	
	}

}
