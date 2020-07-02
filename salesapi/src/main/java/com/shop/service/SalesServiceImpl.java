package com.shop.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.SalesDao;
import com.shop.model.Sales;

@Service
public class SalesServiceImpl implements SalesService {
	
	@Autowired
	private SalesDao salesDao;
	
	@Override
	public List<Sales> getAll() {
		return salesDao.findAll();
	}
	
	@Override
	public Optional<Sales> findById(int id){
		return salesDao.findById(id);
	}
	
	@Override
	public Sales update(Sales sale) {
		Optional<Sales> salesUpdate = salesDao.findById(sale.getId());
		
		if(salesUpdate.isPresent()) {
			Sales salesUpdateNew = salesUpdate.get();
			salesUpdateNew.setId(sale.getId());
			salesUpdateNew.setName(sale.getName());
			salesUpdateNew.setPrice(sale.getPrice());
			salesUpdateNew.setQuantity(sale.getQuantity());
			
			salesUpdateNew = salesDao.save(sale);
			return salesUpdateNew;
		}
		else {
			sale = salesDao.save(sale);
			return sale;
		}
	}

	@Override
	public Sales save(Sales sale) {
		return salesDao.save(sale);
	}
	
	@Override
	public void delete(int id) {
		salesDao.deleteById(id);
	}

}
