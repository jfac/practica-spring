package com.spring.mvc.domain;

import java.io.Serializable;

public class Producto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String descrption;
	private Double price;
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("descrption: ").append(descrption).append(";");
		buffer.append("price: ").append(price).append(";");
		return buffer.toString();
	}
	
}
