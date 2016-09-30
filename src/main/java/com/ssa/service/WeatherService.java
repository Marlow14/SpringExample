package com.ssa.service;

import com.ssa.model.Weather;

public interface WeatherService {

	Weather lookupWeather(String state, String city);
	
}
