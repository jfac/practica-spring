package com.spring.mvc.service;

import java.util.List;

import com.spring.mvc.domain.Producto;
public class SimpleProductManager implements ProductManager {
	
	private static final long serialVersionUID = 1L;
	
	private List<Producto> products;
	
	public List<Producto> getProducts() {
		return products;
	}
	
	public void increasePrice(int percentage){
		if(products != null){
			for (Producto product : products){
				double newPrice = product.getPrice().doubleValue() * 
						(100 + percentage)/100;
				product.setPrice(newPrice);
			}
		}
	}
	
	public void setProductos(List<Producto> products){
		this.products = products;
	}
	

}
