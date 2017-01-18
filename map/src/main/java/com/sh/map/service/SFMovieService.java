package com.sh.map.service;


import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
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
		return null;
	}
	
	@RequestMapping("/titleLocations") 
	public SFMoviesResponse findTitleLocations(String title) {
		return null;
	}
}
