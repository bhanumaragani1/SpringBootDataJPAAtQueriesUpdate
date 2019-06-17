package com.starter.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.starter.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Modifying
	@Transactional
	@Query("update Product p set p.prodCost=:pcost where p.prodId=:pid")
	public int updatePordCost(Double pcost,Integer pid);
	
	@Modifying
	@Transactional
	@Query("delete from Product p where p.prodId=:pid")
	public int deleteProdId(Integer pid);
}
