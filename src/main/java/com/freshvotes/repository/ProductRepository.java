package com.freshvotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freshvotes.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	

}
