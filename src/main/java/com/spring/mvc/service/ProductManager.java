package com.spring.mvc.service;

import com.spring.mvc.domain.Producto;

import java.io.Serializable;
import java.util.List;

public interface ProductManager extends Serializable {
	
	public void increasePrice(int percentage);
	
	public List<Producto> getProducts();
	
}
