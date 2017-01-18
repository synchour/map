package com.sh.map.data;

import java.util.ArrayList;
import java.util.Collection;

public class SFMoviesTitleResponse {
	
	public SFMoviesTitleResponse() {
		this.movieLocations = new ArrayList<SFMovieTitle>();
	}
	
	public SFMoviesTitleResponse(Collection<SFMovieTitle> movieLocations) {
		if (movieLocations == null) {
			this.movieLocations = new ArrayList<SFMovieTitle>();
		} else {
			this.movieLocations = movieLocations;
		}
	}
	
	private Collection<SFMovieTitle> movieLocations;

	public Collection<SFMovieTitle> getMovieLocations() {
		return movieLocations;
	}

	public void setMovieLocations(Collection<SFMovieTitle> movieLocations) {
		this.movieLocations = movieLocations;
	}
}
