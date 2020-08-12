package com.ford;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Timer;

import com.ford.GUI.GUILogin;
import com.ford.domain.CatStore;
import com.ford.domain.CatUtilizadores;
import com.ford.domain.Utilizador;
import com.ford.events.LoginEfetuadoEvent;
import com.ford.handlers.FabricarCarrosHandler;

import utils.observer.Event;
import utils.observer.Observable;
import utils.observer.Observer;



public class AppFord implements Observer{
	
	private CatStore catStore = new CatStore();
	private CatUtilizadores catUti = new CatUtilizadores();
	private List<Observable> classesObserved = new ArrayList<>();
	private boolean login;
	
	public AppFord() {
		FabricarCarrosHandler fb= new FabricarCarrosHandler();
		GUILogin guiLogin = new GUILogin();
		guiLogin.addObserver(this);
		guiLogin.inicializeGuiLogin();
		classesObserved.add(guiLogin);
		System.out.println("Waiting...");
		
		//wait for login (um dia usar wait)
		while(!login ) {
			
			
		}
		fb.fabricarCarros("Lisboa");
		fb.fabricarCarros("Porto");
		fb.fabricarCarros("Algarve");
	}
	


	public CatStore getCatStore() {
		return catStore;
	}
	
	
	@Override
	public void update(Event e) {
		if(e instanceof LoginEfetuadoEvent) {
			LoginEfetuadoEvent ev = (LoginEfetuadoEvent) e;
			Utilizador user = ev.getUser();
			login = true;
			System.out.println("App notificada do login de " + user.toString());
			//user.map(user -> new Sessao(user));
		}
		
	}

	
	

}
