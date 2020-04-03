package com.hackerrank.WheatherApi.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.WheatherApi.model.Weather;
import com.hackerrank.WheatherApi.repository.WeatherRepository;
@Service
@Transactional
public class WheatherService {
	@Autowired
	WeatherRepository weatherRepository;
	@Autowired
	EntityManager em;
	public void delete() {
		
		weatherRepository.deleteAll();

		
	}
	
	public void deleteRange(LocalDate localDate1,LocalDate localDate2) {
		try {
	    List<Weather> findByDater = weatherRepository.findByDater(localDate1,localDate2);
		weatherRepository.deleteAll(findByDater);
		}catch (Exception e) {
        e.printStackTrace();
		}

		
	}
	public List<Weather> findAll() {
		
		return  weatherRepository.findAll();


		
	}
	
	public Weather insert(Weather wheather) throws Exception {
		Weather save;
		Optional<Weather> findById = weatherRepository.findById(wheather.getId());
		if(findById.isPresent()){
			throw new Exception("User is already present");
		} else {
			 save = weatherRepository.save(wheather);
		}
		return save;


		
	}
}
