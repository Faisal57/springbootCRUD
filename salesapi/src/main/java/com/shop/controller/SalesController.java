package com.shop.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shop.exception.UserNotFoundException;
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
		if(!saleObj.isPresent()) {
			throw new UserNotFoundException("Record not found for the Id:"+id+"!");
		}
		return saleObj;
	}
	
	@PostMapping("/sale")
	public ResponseEntity<Object> save(@Valid @RequestBody Sales saleObj) {
		Sales savedSale = salesService.save(saleObj);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedSale.getId()).toUri();

		return ResponseEntity.created(location).build();
		
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
