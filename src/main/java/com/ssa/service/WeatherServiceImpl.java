package com.ssa.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ssa.model.Weather;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Override
	public Weather lookupWeather(String state, String city) {
		// TODO Auto-generated method stub
		final String uri = "http://api.wunderground.com/api/5dcb2a5567c89129/conditions/q/"+state+"/"+city +".json";
		RestTemplate restTemplate = new RestTemplate();
		
		return restTemplate.getForObject(uri, Weather.class);
		
	}

}
