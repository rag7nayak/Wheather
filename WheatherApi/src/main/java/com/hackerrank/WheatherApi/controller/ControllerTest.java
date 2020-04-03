package com.hackerrank.WheatherApi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.WheatherApi.model.Location;
import com.hackerrank.WheatherApi.model.Weather;
import com.hackerrank.WheatherApi.service.LocationService;
import com.hackerrank.WheatherApi.service.WheatherService;

@RestController
public class ControllerTest {

	@GetMapping("/list")
	public List getList() {
		return Arrays.asList("a","b");
	
}
	
	@Autowired
	WheatherService wheatherService;
	
	@Autowired
	LocationService locationService;
	
	@DeleteMapping("/wheather/erase")
	public void deleteWheather() {
		wheatherService.delete();
	}
	
	@DeleteMapping("/wheather/erase/ragne")
	public void deleteWheatherWithRange(@RequestParam(name = "start")String startDate,@RequestParam(name = "end")String endDate) {
		
		Date startdate=null;
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date enddate=null;
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		try {
		startdate=df.parse(startDate);
		enddate=df.parse(endDate);
		}catch (Exception e) {
			// TODO: handle exception
		}
		Instant instant1 = startdate.toInstant();
		Instant instant2 = startdate.toInstant();
		
		//Converting the Date to LocalDate
		LocalDate localDate1 = instant1.atZone(defaultZoneId).toLocalDate();
		LocalDate localDate2 = instant2.atZone(defaultZoneId).toLocalDate();
		
		wheatherService.deleteRange(localDate1, localDate2);
	}
	
	@GetMapping("/wheather/all")
	public List<Weather> getWheather() {
		return wheatherService.findAll();
	}
	
	@PostMapping("/wheather")
	public ResponseEntity<Weather> create(@RequestBody Weather weather) throws Exception {
		Location loc = locationService.insert(weather.getLocation());
		Weather whe = wheatherService.insert(weather);
		
		return new ResponseEntity<Weather>(HttpStatus.CREATED);
	}
}
