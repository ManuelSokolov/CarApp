package com.ford.handlers;

import com.ford.domain.CatStore;
import com.ford.domain.Store;
import com.ford.domain.cars.CarFactory;

public class FabricarCarrosHandler {
	
	public void fabricarCarros(String locationStore) {
		Store st = CatStore.getStore(locationStore);
		CarFactory.getInstance().sendCarsToStore(st);
		System.out.println("Carros Fabricados");
	}

}
