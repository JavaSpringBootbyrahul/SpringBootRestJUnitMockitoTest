package com.muktai.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.muktai.model.Product;
import com.muktai.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductRestController {
	@Autowired
	private IProductService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> savePro(@RequestBody Product p)
	{
		int id=service.save(p);
		return ResponseEntity.ok("Product Created "+id);
		
	}
}
