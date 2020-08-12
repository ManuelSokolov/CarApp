package com.ford;

import com.ford.domain.Utilizador;
import com.ford.handlers.ComprarCarroHandler;

public class Session {
	
	private Utilizador user;
	
	public Session(Utilizador user) {
		this.user=user;
	}
	
	public ComprarCarroHandler comprarHandler() {
		return new ComprarCarroHandler(user);
		
	}

}
