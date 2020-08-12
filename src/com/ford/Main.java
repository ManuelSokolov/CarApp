package com.ford;

import java.awt.Color;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import com.ford.domain.cars.Car;
import com.ford.domain.cars.CarFactory;

public class Main {
	
	public static void main(String[] args) {
		
		String className = "com.ford.domain.cars.CarFactory";
		List<Car> cars = CarFactory.getInstance().getCars();
		for(Car c : cars) {
			System.out.println(c.toString());
		}
		try {
			Class<?> klass = Class.forName(className);
			
			System.out.println(klass.getName());
			//nao e possivel ir buscar os construtores
			Method[] metodos = klass.getDeclaredMethods();
			System.out.println(metodos[0]);
			//CarFactory carFact= null ;
			// metodos[0].invoke(carFact, null);
			//List<Car> carros = carFact.getCars();
			//System.out.print(carros.isEmpty());
			
			// e impossivel referenciar aquele metodo CarFactory getInstance() getCars devido ao 
			// singleton !
			// nao e possivel invocar os metodos ??
			
			//vamos agora tentar construir um carro com Reflection
			Class<?> klass2 = Class.forName("com.ford.domain.cars.Punto");
			
			//ir buscar o construtor com string, color, int  e double
			Constructor c1 = klass2.getConstructor(String.class, Color.class , int.class, double.class);
			
			
			//criar nova instancia
			Car car = (Car) c1.newInstance("Punto 1.0",Color.BLACK ,100,20000.20);
			
			System.out.println(car.toString()); // imprime o carro selecionado
						
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("nao existe");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
