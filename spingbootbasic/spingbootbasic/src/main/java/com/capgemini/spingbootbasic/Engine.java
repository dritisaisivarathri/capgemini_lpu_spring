package com.capgemini.spingbootbasic;

import jakarta.persistence.Embeddable;

@Embeddable
public class Engine {
	
	private String fueltype;
	private double cc;
	public String getFueltype() {
		return fueltype;
	}
	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
	public double getCc() {
		return cc;
	} 
	public void setCc(double cc) {
		this.cc = cc;
	}
	public Engine(String fueltype, double cc) {
		super();
		this.fueltype = fueltype;
		this.cc = cc;
	}
	@Override
	public String toString() {
		return "Engine [fueltype=" + fueltype + ", cc=" + cc + "]";
	}
	

}
