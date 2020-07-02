package com.shop.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shop.model.Sales;
import com.shop.service.SalesService;

@RestController
@RequestMapping("/api")
public class SalesController {
	
	@Autowired
	private SalesService salesService;
	
	@GetMapping("/sale")
	public List<Sales> get(){
		return salesService.getAll();
	}
	
	@GetMapping("/sale/{id}")
	public Optional<Sales> get(@PathVariable int id) {
		Optional<Sales> saleObj = salesService.findById(id);
		if(saleObj == null) {
			throw new RuntimeException("Record not found for the Id:"+id+"!");
		}
		return saleObj;
	}
	
	@PostMapping("/sale")
	public Sales save(@RequestBody Sales saleObj) {
		salesService.save(saleObj);
		return saleObj;
	}
	
	@PutMapping("/sale")
	public Sales update(@RequestBody Sales saleObj) {
		salesService.update(saleObj);
		return saleObj;
	}
	
	@DeleteMapping("/sale/{id}")
	public String delete(@PathVariable int id) {
		salesService.delete(id);
		return "Record has been deleted with id:"+id;
	}
}
