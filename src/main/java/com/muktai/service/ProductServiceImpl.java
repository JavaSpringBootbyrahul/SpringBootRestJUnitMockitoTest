package com.muktai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muktai.execpHandler.ProductNotFoundException;
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
	@Override
	public List<Product> getALL() 
	{
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public Product getOneProduct(int id) {
		return repo.findById(id).orElseThrow
									(
										()->
										{
											throw new ProductNotFoundException("Product Not Found Exception");
										}
									);
		
//		Optional<Product> op=repo.findById(id);
//		if(op.isPresent())
//			return op.get();
//		else
//			throw new ProductNotFoundException("Product Not there");
	}
	
	
}
