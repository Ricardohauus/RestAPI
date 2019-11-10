package com.ricardo.RestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardo.RestAPI.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
	
}
