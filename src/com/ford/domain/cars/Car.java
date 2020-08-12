package com.ford.domain.cars;

import java.awt.Color;

public abstract class Car {

	private int id;
	
	private String model;

	private Color color;
	
	private int maxSpeed;
	
	private double price;
	
	public Car(String model, Color color, int maxSpeed, double price, int id) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.price = price;
		this.id=id;
	}

	@Override
	public String toString() {
		return this.model +" " + colorToString(color);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + maxSpeed;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj instanceof Car) {
			Car c = (Car) obj;
			return c.model.equals(this.model) && c.color.equals(this.color) 
					&& c.maxSpeed == this.maxSpeed && Math.abs(c.price - this.price) <= 0.001;
		}
		return false;
	}
	
	private String colorToString(Color c) {
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		if(r == 0 && g == 0 && b == 0 ) {
			return "Preto";
		}
		return c.toString();
		
	}
	
	
	public double getPrice() {
		return this.price;
		
	}

	public int getID() {
		
		return this.id;
	}
	
	

	
	
}
