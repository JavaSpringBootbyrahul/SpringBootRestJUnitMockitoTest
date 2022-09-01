package com.muktai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.muktai.model.Product;
import com.muktai.repo.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService 
{
	@Autowired
	private ProductRepository repo;
	@Override
	public int save(Product p) 
	{
		Product p1=repo.save(p);
		return p1.getPid();
	}

}
