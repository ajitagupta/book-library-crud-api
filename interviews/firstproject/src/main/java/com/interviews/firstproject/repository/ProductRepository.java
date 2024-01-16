package com.interviews.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interviews.firstproject.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	

	
	default java.util.List<Product> getAllProducts()	{
		return findAll();
	}

}
