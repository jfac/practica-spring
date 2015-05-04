package com.spring.mvc.domain.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.spring.mvc.domain.Producto;

public class ProductTest {
	
	private Producto product;
	
	@Before
	public void setUp() throws Exception{
		product = new Producto();
	}
	
	@Test
	public void testSetAndGetDescription(){
		String testDescription = "aDescription";
		assertNull(product.getDescrption());
		product.setDescrption(testDescription);
		assertEquals(testDescription, product.getDescrption());
	}
	
	@Test
	public void testSEtAndGetPrice(){
		double testPrice = 100.00;
		assertEquals(0, 0,0);
		product.setPrice(testPrice);
		assertEquals(testPrice, product.getPrice(),0);
	}
}
