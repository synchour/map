package com.sh.map.restful;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sh.map.data.SFMovie;
import com.sh.map.data.SFMoviesResponse;
import com.sh.map.repository.SFMovieRepository;

@RestController
@CrossOrigin
@RequestMapping("/sfmovie")
public class SFMovieService{

	@Autowired
	SFMovieRepository movieRepo;
	
	private static Logger logger = LoggerFactory.getLogger(SFMovieService.class);
	
	@RequestMapping("/titles") 
	public SFMoviesResponse findTitles(String searchTerm) {
		logger.info("/titles " + searchTerm);
		if (searchTerm == null) {
			return new SFMoviesResponse(null);
		}
		List<SFMovie> movies = movieRepo.findByTitleContainingIgnoreCase(searchTerm);
		return new SFMoviesResponse(movies);
	}
	
	@RequestMapping("/titleLocations") 
	public SFMoviesResponse findTitleLocations(String title) {
		logger.info("/titleLocations " + title);
		List<SFMovie> movies = movieRepo.findByTitleContainingIgnoreCase(title);
		return new SFMoviesResponse(movies);
	}
}
