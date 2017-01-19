package com.sh.map.repository;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.repository.CrudRepository;

import com.sh.map.data.SFMovie;

public interface SFMovieRepository extends CrudRepository<SFMovie, Long> {
	List<SFMovie> findByTitle(String title);
	
	// This is not used in SFMovie, however 2d spatial search can be done this way easily
	List<SFMovie> findByGeoLocationNear(Point location, Distance distance);
}