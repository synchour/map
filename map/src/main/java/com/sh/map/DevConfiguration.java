package com.sh.map;

import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ResourceLoader;

import com.sh.map.data.SFMovie;
import com.sh.map.preprocess.SFMovieCSVUtil;
import com.sh.map.repository.MovieServiceDataAccess;

@Configuration
@Profile("dev")
public class DevConfiguration {
	
	private static Logger logger = LoggerFactory.getLogger(DevConfiguration.class);
	
	@Autowired
	ResourceLoader loader;
	
	@Autowired
	MovieServiceDataAccess dataAccess;
	
	@Bean
	CommandLineRunner initData() {
		return args -> {
			logger.info("loading data ");
			InputStream stream = loader.getResource("classpath:SF_Processed_Small.csv").getInputStream();
			List<SFMovie> moviesLoaded = SFMovieCSVUtil.readObjects(stream);
			logger.info(moviesLoaded.size() + " entities loaded, saving to repo");
			
			for (SFMovie m : moviesLoaded) {
				if (m.getLatitude() != 0 && m.getLongitude() != 0) {
					dataAccess.Save(m);
				}
			}
			
			logger.info("Done saving");
		};
	}
}
