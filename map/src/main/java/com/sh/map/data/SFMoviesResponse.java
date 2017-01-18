package com.sh.map.data;

import java.util.ArrayList;
import java.util.Collection;

public class SFMoviesResponse {
	private Collection<SFMovie> movieLocations;

	public SFMoviesResponse() {
		this.movieLocations = new ArrayList<SFMovie>();
	}
	public SFMoviesResponse(Collection<SFMovie> movieLocations) {
		this.movieLocations = movieLocations;
	}
	
	public Collection<SFMovie> getMovieLocations() {
		return movieLocations;
	}

	public void setMovieLocations(Collection<SFMovie> movieLocations) {
		this.movieLocations = movieLocations;
	}
}
