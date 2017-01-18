package com.sh.map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sh.map.repository.SFMovieRepository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapApplicationRepoTests {
	@Autowired
	SFMovieRepository movieRepo;
	
	@Before
	@After
	public void clearDB() {
		//movieRepo.deleteAll();
	}
	
	@Test
	public void testRepo() {
		//Assert.assertEquals(0, movieRepo.count());
	}
}
