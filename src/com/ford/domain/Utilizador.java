package com.ford.domain;

import com.ford.exceptions.WrongPasswordException;

public class Utilizador {

	private String username;
	private String password;

	public Utilizador(String username, String pw) {
		this.username= username;
		this.password= pw;	
	}
	
	public boolean passwordEquals(String pw) throws WrongPasswordException{
		if(this.password.contentEquals(pw))
			return true;
		throw new WrongPasswordException();
	}

	@Override
	public String toString() {
		return this.username;
	}
	
	

}
