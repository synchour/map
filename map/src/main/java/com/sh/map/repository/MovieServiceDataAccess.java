package com.sh.map.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sh.map.data.SFMovie;
import com.sh.map.data.SFMovieTitle;

// This handles all the query operations
@Component
public class MovieServiceDataAccess {
	
	@Autowired
	private SFMovieRepository movieRepo;
	
	@Autowired
	private SFMovieTitleRepository movieTitleRepo;
	
	public void Save(SFMovie movie) {
		movie.updateGeoLocation();
		movieRepo.save(movie);
		movieTitleRepo.save(new SFMovieTitle(movie.getTitle()));
	}
	
	public Collection<SFMovieTitle> findByTitleContainingIgnoreCase(String search) {
		return movieTitleRepo.findByTitleContainingIgnoreCase(search);
	}
	
	public Collection<SFMovie> findByTitle(String title) {
		return movieRepo.findByTitle(title);
	}
}
