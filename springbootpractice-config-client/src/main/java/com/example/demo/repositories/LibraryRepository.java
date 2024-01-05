package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, String>{
	
	
	List<Library> findByName(String libraryName);
	

}
