package com.hackerrank.WheatherApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.WheatherApi.service.WheatherService;

@Controller
public class WeatherApiRestController {
	
	@Autowired
	WheatherService wheatherService;
	
	@DeleteMapping(name="/wheather")
	public void deleteWheather() {
		wheatherService.delete();
	}
}
