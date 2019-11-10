package com.ricardo.RestAPI.services;

import java.util.List;
import java.util.Optional;

import com.ricardo.RestAPI.models.Product;

public interface ProductService {

	public List<Product> findAll();

	public Optional<Product> find(Long id);

	public Product create(Product product);

	public Product update(Product product, Long id);

	public void delete(Long id);

}
