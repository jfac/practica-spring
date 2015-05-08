package com.spring.mvc.repository.test;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.mvc.domain.Producto;
import com.spring.mvc.repository.ProductDAO;

public class JPAProductoDAOTests {
	
	private ApplicationContext context; 
    private ProductDAO productDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        productDao = (ProductDAO) context.getBean("productDAO");
    }

    @Test
    public void testGetProductList() {
        List<Producto> products = productDao.getProductList();
        assertEquals(products.size(), 3, 0);	   
    }

    @Test
    public void testSaveProduct() {
        List<Producto> products = productDao.getProductList();

        Producto p = products.get(0);
        Double price = p.getPrice();
        p.setPrice(200.12);
        productDao.saveProduct(p);

        List<Producto> updatedProducts = productDao.getProductList();
        Producto p2 = updatedProducts.get(0);
        assertEquals(p2.getPrice(), 200.12, 0);

        p2.setPrice(price);
        productDao.saveProduct(p2);
    }

}
