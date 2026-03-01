package com.capgemini.assignment4_28feb.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assignment4_28feb.entity.UrlMapping;


public interface UrlMappingRepository
        extends JpaRepository<UrlMapping,Long>{

    Optional<UrlMapping> findByShortCode(String shortCode);

    boolean existsByShortCode(String shortCode);
}
