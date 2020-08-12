package com.ford.events;

import com.ford.domain.Utilizador;

import utils.observer.Event;

public class LoginEfetuadoEvent extends Event{
	
	private Utilizador u;
	
	public LoginEfetuadoEvent(Utilizador u) {
		this.u = u;
	}
	
	public Utilizador getUser() {
		return u;
	}

	

}
