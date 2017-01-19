package com.sh.map.restful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sh.map.data.SFMoviesResponse;
import com.sh.map.data.SFMoviesTitleResponse;
import com.sh.map.repository.MovieServiceDataAccess;
import com.sh.map.repository.SFMovieRepository;
import com.sh.map.repository.SFMovieTitleRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sfmovie")
public class SFMovieService{

	@Autowired
	SFMovieRepository movieRepo;

	@Autowired
	SFMovieTitleRepository movieTitleRepo;
	
	@Autowired
	MovieServiceDataAccess movieData;
	
	private static Logger logger = LoggerFactory.getLogger(SFMovieService.class);
	
	//This is used for UI lookup (containing match)
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/titles",
		    method = RequestMethod.GET) 
	@ApiOperation(value = "Find list of movie title containing search term",
    	response = SFMoviesTitleResponse.class)
	public SFMoviesTitleResponse findTitles(@RequestParam("searchTerm") String searchTerm) {
		logger.info("/titles " + searchTerm);
		if (searchTerm == null || searchTerm.isEmpty()) {
			return new SFMoviesTitleResponse();
		}
		return new SFMoviesTitleResponse(movieData.findByTitleContainingIgnoreCase(searchTerm));
	}
	
	//This is used for finding all location from an title (exact match)
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/titleLocations",
			method = RequestMethod.GET)
	@ApiOperation(value = "Find list of movie locations matching the exact tile",
		response = SFMoviesResponse.class)
	public SFMoviesResponse findTitleLocations(@RequestParam("title") String title) {
		logger.info("/titleLocations " + title);
		if (title == null || title.isEmpty()) {
			return new SFMoviesResponse();
		}
		return new SFMoviesResponse(movieData.findByTitle(title));
	}
}
