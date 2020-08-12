package com.ford.domain;

import java.util.ArrayList;
import java.util.List;

import com.ford.domain.cars.Car;

public class Store {

	private String location;
	
	private double moneyMade;
	
	private List<Car> carsToSell= new ArrayList<>();

	public Store(String location, List<Car> carsToSell) {
		this.location = location;
		this.moneyMade = 0.0;
		this.carsToSell = carsToSell;
	}
	public Store(String location) {
		this.location=location;
		this.moneyMade=0.0;
	}
	
	public void addCar(Car car) {
		carsToSell.add(car);
	}
	
	public boolean sellCar(int id) {
		Car c = null;
		for(Car car : carsToSell) {
			if(car.getID() == id)
				c = car;	
		}
		if(c == null)
			return false;
		if(carsToSell.contains(c)) {
			carsToSell.remove(c);
			moneyMade += c.getPrice();
			return true;
		}
		return false;
		
	}
	
	public Car getCar(int id) {
		for(Car c : carsToSell) {
			if(c.getID()==id)
				return c;
		}
		return null;//exception
		
	}
	
	public String getLocation() {
		return this.location;
	}
	
	
	public List<Car> getCarsToSell(){
		return new ArrayList<>(carsToSell);
	}
	public void addMoney(double price) {
		moneyMade+=price;
		
	}
	
	
	
	
}
