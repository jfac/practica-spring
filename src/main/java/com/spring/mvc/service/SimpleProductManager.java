package com.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.mvc.domain.Producto;
import com.spring.mvc.repository.ProductDAO;

@Component
public class SimpleProductManager implements ProductManager {
	
	private static final long serialVersionUID = 1L;

    @Autowired
    private ProductDAO productDao;

    public void setProductDao(ProductDAO productDao) {
        this.productDao = productDao;
    }
    
    public List<Producto> getProducts() {
    	return productDao.getProductList();
    }

    public void increasePrice(int percentage) {
    	List<Producto> products = productDao.getProductList();
        if (products != null) {
            for (Producto product : products) {
                double newPrice = product.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                product.setPrice(newPrice);
                productDao.saveProduct(product);
            }
        }  
    }
}
