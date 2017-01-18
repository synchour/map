package com.sh.map.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sh.map.data.SFMovieTitle;

public interface SFMovieTitleRepository extends CrudRepository<SFMovieTitle, String>{
	List<SFMovieTitle> findByTitleContainingIgnoreCase(String search);
}
