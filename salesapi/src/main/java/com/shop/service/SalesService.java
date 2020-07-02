package com.shop.service;

import java.util.*;

import com.shop.model.Sales;

public interface SalesService {
	
	List <Sales> getAll();
	
	Optional<Sales> findById(int id);

	Sales save(Sales sale);
	
	Sales update(Sales sale);
	
	void delete(int id); 
}
