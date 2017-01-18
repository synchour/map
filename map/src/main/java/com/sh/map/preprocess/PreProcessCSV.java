package com.sh.map.preprocess;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.sh.map.data.SFMovie;

//@Component
public class PreProcessCSV {
	
	@Autowired
	ResourceLoader loader;
	
	@Autowired
	MapPreprocessor mapProcessor;
	
	@Bean
	@Profile("dev-mapprocess")
	CommandLineRunner initSFMoviesData() {
		return args -> {
			InputStream stream = loader.getResource("classpath:Film_Locations_in_San_Francisco.csv").getInputStream();
			List<SFMovie> movies = SFMovieCSVUtil.readObjects(stream);
			System.out.println("===============movies " + movies.size());
			for (SFMovie m : movies) {
				mapProcessor.GeoCodeFromGoogle(m);								
			}
			File file = new File("Processed.csv");
			SFMovieCSVUtil.writeCSV(movies, file);
			System.out.println("===============done writing " + movies.size());
		};
	}
}
