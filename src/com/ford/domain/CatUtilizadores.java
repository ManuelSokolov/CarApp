package com.ford.domain;

import java.util.HashMap;

import com.ford.exceptions.UtilizadorNaoEncontradoException;

public class CatUtilizadores {
	
	private static HashMap<String, Utilizador> users =  new HashMap<>();
	
	public CatUtilizadores() {
		
		users.put("Manuel", new Utilizador ("Manuel","123"));
		users.put("Anna", new Utilizador ("Anna","123"));
		
	}
	
	
	public static Utilizador getUser(String name) throws UtilizadorNaoEncontradoException {
		
		if(!users.containsKey(name)) {
			throw new UtilizadorNaoEncontradoException();
		}
		return users.get(name);		
	}
	

}
