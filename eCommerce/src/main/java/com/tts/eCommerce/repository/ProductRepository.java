package com.tts.eCommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.eCommerce.model.Product;

@Repository
public interface ProductRepository
    extends CrudRepository<Product, Long> {
  List<Product> findProductsByCategory(String category);
  List<Product> findProductsByBrand(String brand);
  Product findByModel(String model);
  Product findByName(String name);
  
}
