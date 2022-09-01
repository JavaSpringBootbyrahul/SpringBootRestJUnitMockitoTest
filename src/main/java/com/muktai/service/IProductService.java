package com.muktai.service;

import com.muktai.model.Product;

import java.util.List;

public interface IProductService {
	public int save(Product p);
	public List<Product> getALL();
	public Product getOneProduct(int id);
}
