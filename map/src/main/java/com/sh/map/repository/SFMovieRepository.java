package com.sh.map.repository;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.repository.CrudRepository;

import com.sh.map.data.SFMovie;

public interface SFMovieRepository extends CrudRepository<SFMovie, Long> {

	List<SFMovie> findByTitleContainingIgnoreCase(String title);
	
	List<SFMovie> findByTitle(String title);
	
	List<SFMovie> findByGeoLocationNear(Point location, Distance distance);
}