package com.sh.map.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// This handles all the query operations
@Component
public class MovieServiceDataAccess {
	
	@Autowired
	private SFMovieRepository movieRepo;
	
	@Autowired
	private SFMovieTitleRepository movieTitleRepo;
	
	public void Save() {
		
	}
	
	
}
