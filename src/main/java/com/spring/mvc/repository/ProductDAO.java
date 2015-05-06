package com.spring.mvc.repository;

import java.util.List;

import com.spring.mvc.domain.Producto;

public interface ProductDAO {
	
	public List<Producto> getProductoList();
	
	public void saveProduct(Producto prod);
}
