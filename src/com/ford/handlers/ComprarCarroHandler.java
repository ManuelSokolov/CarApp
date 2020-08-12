package com.ford.handlers;

import com.ford.domain.CatStore;
import com.ford.domain.Store;
import com.ford.domain.Utilizador;
import com.ford.domain.cars.Car;

public class ComprarCarroHandler {
	
	private Utilizador user;
	private Store store;

	public ComprarCarroHandler(Utilizador user) {
		this.user=user;
	}
	
	
	public Store selectStore(String location) {
		this.store = CatStore.getStore(location);
		return store;
	}
	
	public Car chooseCar(int id) {
		Car c = store.getCar(id);
		store.sellCar(id);
		store.addMoney(c.getPrice());
		return c;
		
		
	}
	

}
