package com.sh.map.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sh.map.data.SFMoviesResponse;

@RestController
@CrossOrigin
@RequestMapping("/sfmovie")
public class SFMovieService{

	private static Logger logger = LoggerFactory.getLogger(SFMovieService.class);
	
	@RequestMapping("/titles") 
	public SFMoviesResponse findTitles(String searchTerm) {
		logger.info("/titles " + searchTerm);
		return new SFMoviesResponse();
	}
	
	@RequestMapping("/titleLocations") 
	public SFMoviesResponse findTitleLocations(String title) {
		logger.info("/titleLocations " + title);
		return new SFMoviesResponse();
	}
}
