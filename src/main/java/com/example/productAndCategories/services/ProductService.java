package com.example.productAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.productAndCategories.models.Product;
import com.example.productAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	public final ProductRepository productRepository;
	public ProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	//create Product
	public Product createProduct(Product p) {
		return productRepository.save(p);
	}
	//show all Products
	public List<Product>allProduct(){
		return productRepository.findAll();
	}
	//find One product
	public Product getOneProduct(Long id) {
		Optional<Product>product=productRepository.findById(id);
		return product.isPresent()?product.get():null;
	}
	//save Product
	public Product saveProduct(Product p) {
		return productRepository.save(p);
	}
}
