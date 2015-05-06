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
	public void setUp() throws Exception{
		context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		productDao = (ProductDAO) context.getBean("productDAO");
	}
	
	@Test
	public void testGetProductList(){
		List<Producto> products = productDao.getProductoList();
		assertEquals(products.size(),3,0);
	}
	
	@Test
	public void testSaveProducto(){
		List<Producto> products = productDao.getProductoList();
		
		Producto p = products.get(0);
		Double price = p.getPrice();
		p.setPrice(200.12);
		productDao.saveProduct(p);
		
		List<Producto> updateProducts = productDao.getProductoList();
		Producto pd = updateProducts.get(0);
		assertEquals(pd.getPrice(), 200.12,0);
		
		pd.setPrice(price);
		productDao.saveProduct(pd);
	}

}
