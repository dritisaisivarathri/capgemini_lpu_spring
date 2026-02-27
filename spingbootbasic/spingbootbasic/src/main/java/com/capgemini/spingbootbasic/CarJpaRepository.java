package com.capgemini.spingbootbasic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface CarJpaRepository extends JpaRepository <Car, Integer>{
	
	public Car getByPrice(double price); 
	
	//write own custom query
	@Modifying
	@Transactional
	@Query("delete from Car c where c.brand=:carbrand")
	public int deleteByBrand(@Param("carbrand") String brand);

}
