package com.ford;

import com.ford.GUI.GUILogin;
import com.ford.domain.CatStore;


public class Cliente {
	
	public static void main(String[] args) {
		AppFord app = new AppFord();
		
		
		

		
		//java funcional ftw
		CatStore.getStore("Lisboa").getCarsToSell().forEach(Car ->{
			System.out.println("-" + Car.toString()+"-");
		});
		
		System.out.println("-------------------------------");
		
		CatStore.getStore("Porto").getCarsToSell().forEach(Car ->{
			System.out.println("-" + Car.toString()+"-");
		});
		
		
		if (CatStore.getStore("Porto").getCarsToSell().isEmpty()) 
			System.out.println("Vazio");
		else 
			System.out.println("nao esta vazio");
		
	}

}
