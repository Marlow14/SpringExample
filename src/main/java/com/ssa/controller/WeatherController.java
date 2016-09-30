package com.ssa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import com.ssa.model.Weather;
import com.ssa.service.WeatherService;

@Controller
@RequestMapping("/weather")
public class WeatherController {

	final WeatherService service;
	
	@Autowired
	public WeatherController(WeatherService service){
		this.service = service;
	}
	
	@RequestMapping("")
	
	public View home(){
		return new InternalResourceView("html/weather.html");
	}
	
	@RequestMapping("local")
	@ResponseBody
	public ResponseEntity<Map<String, Object>>local(){
//		Weather columbiaWeather = this.service.lookupWeather("MD", "Columbia");
//		Map<String,Object>response = new HashMap<>();
//		response.put("success", columbiaWeather);
//		return ResponseEntity.ok(response);
		return dynamicLookup("MD", "Columbia");
	}
	
	//User enters info
	@RequestMapping("{state}/{city}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> dynamicLookup(@PathVariable String state, @PathVariable String city){
		Weather weather = this.service.lookupWeather(state, city);
		Map<String,Object>response = new HashMap<>();
		response.put("success", weather);
		return ResponseEntity.ok(response);	
	}
	
	
}
