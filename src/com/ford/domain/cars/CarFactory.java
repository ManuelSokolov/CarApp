package com.ford.domain.cars;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import com.ford.domain.CatStore;
import com.ford.domain.Store;

//singleton!!!
public class CarFactory {
	
	
	private List<Car> cars = new ArrayList<>();
	
	private static CarFactory INSTANCE = new CarFactory();
	
	public static CarFactory getInstance() {
		return INSTANCE;
	}
	
	protected CarFactory() {
		Random rd = new Random();
		Properties prop = new Properties();
		int maxCars=0;
		try {
			prop.load(new FileInputStream(new File("config.properties")));
			maxCars = Integer.parseInt(prop.getProperty("maxCars"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i<maxCars ;i++) {
			int n = rd.nextInt(3);
			if(n==0) 
				cars.add(new Punto("Punto 1.0",Color.BLACK, 230, 50000.00,i));
			if(n==1)
				cars.add(new Venom("Venom 1.0",Color.BLACK, 230, 50000.00,i));
			if(n==2)
				cars.add(new Xpto("Xpto 1.0",Color.BLACK, 230, 50000.00,i));
						
		}	
	}
	
	public List<Car> getCars(){
		return cars;
	}
	
	public void sendCarsToStore(Store st) {
		Store store = CatStore.getStore(st.getLocation());
		for(Car c: cars) {
			store.addCar(c);
		}
		
	}
	

}
