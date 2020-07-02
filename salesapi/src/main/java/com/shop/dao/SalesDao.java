package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.model.Sales;

@Repository
public interface SalesDao extends JpaRepository<Sales, Integer> {
	

}
