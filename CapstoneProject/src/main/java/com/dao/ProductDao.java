package com.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer>{

	List<Product> findByProductNameContaining(String searchTerm);
}
