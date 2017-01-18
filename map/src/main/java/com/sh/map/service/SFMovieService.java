package com.sh.map.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sh.map.data.SFMoviesResponse;

@RestController
@CrossOrigin
@RequestMapping("/sfmovie")
public class SFMovieService{

	@RequestMapping("/titles") 
	public SFMoviesResponse findTitles(String searchTerm) {
		return new SFMoviesResponse();
	}
	
	@RequestMapping("/titleLocations") 
	public SFMoviesResponse findTitleLocations(String title) {
		return new SFMoviesResponse();
	}
}
