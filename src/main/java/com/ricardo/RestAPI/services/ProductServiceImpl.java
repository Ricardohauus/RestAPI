package com.ricardo.RestAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.RestAPI.models.Product;
import com.ricardo.RestAPI.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> find(Long id) {
		return this.productRepository.findById(id);
	}

	@Override
	public Product create(Product product) {
		this.productRepository.save(product);
		return product;
	}

	@Override
	public Product update(Product product, Long id) {
		if (productRepository.findById(id) != null) {
			product.setId(id);			
			this.productRepository.save(product);
			return product;
		} else {			
			return null;
		}

	}

	@Override
	public void delete(Long id) {
		if (productRepository.findById(id) != null) {
			this.productRepository.deleteById(id);
		} else {
			System.out.println("Não excluiu");
		}
	}

}
