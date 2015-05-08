package com.spring.mvc.repository;

import java.util.List;

import com.spring.mvc.domain.Producto;

public class InMemoryProductDao implements ProductDAO {
	
	private List<Producto> productList;

    public InMemoryProductDao(List<Producto> productList) {
        this.productList = productList;
    }

    public List<Producto> getProductList() {
        return productList;
    }

    public void saveProduct(Producto prod) {
    }

}
