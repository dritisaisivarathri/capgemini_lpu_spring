package com.capgemini.spingbootbasic;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car { 
	
	@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private String brand;
	private double price;
	
	private Engine engine;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Car(String brand, double price) {
		super();
		this.brand = brand;
		this.price = price;
	}
	public Engine getEngine() {
		return engine; 
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + ", engine=" + engine + "]";
	}
	Car(){
		
	}
	
	
	

}
