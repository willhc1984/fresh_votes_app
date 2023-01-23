package com.freshvotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freshvotes.model.Product;
import com.freshvotes.model.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByUser(User user);
	
	List<Product> findByName(String name);

}
