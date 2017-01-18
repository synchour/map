package com.sh.map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class MapApplication {	

	public static void main(String[] args) {
		
		String profileName = System.getenv("MAP_PROFILE");
		if (StringUtils.isEmpty(profileName)) {
			profileName = "dev";
		}
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, profileName);
		SpringApplication.run(MapApplication.class, args);
	}
}
