package com.freshvotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freshvotes.model.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long>{

}
