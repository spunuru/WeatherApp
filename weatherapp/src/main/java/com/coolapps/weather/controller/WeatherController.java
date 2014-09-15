package com.coolapps.weather.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.coolapps.weather.domain.WeatherForecast;

@RestController

/**
 *
 * Provides Weather forecast for 7 days starting with today in JSON format. 
 * Retrieves weather from {code}http://openweathermap.org/api{/code}
 * Call format - GET http://localhost:port/weather?city=Baltimore,MD,USA
 * 
 * @author spunuru
 *
 */
public class WeatherController {

    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);
        
    @Value("${weather.api.url}")
    private String weatherApiUrl;
    
    //RestTemplate is thread safe. Single RestTemplate instance can be used by all requests.
	private final RestTemplate restTemplate = new RestTemplate(); 

    
    @RequestMapping("/weather")    
    public WeatherForecast getWeather(@RequestParam(required=true) String city) {
    	    	
        Map<String, String> params = new HashMap<String, String>(1);
        params.put("city", city);
        WeatherForecast weatherForecast = restTemplate.getForObject(weatherApiUrl, WeatherForecast.class, params);  	
        return weatherForecast;
    }

}	