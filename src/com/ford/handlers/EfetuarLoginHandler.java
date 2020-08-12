package com.ford.handlers;

import java.awt.event.WindowEvent;
import java.util.Optional;

import javax.swing.JOptionPane;

import com.ford.domain.CatUtilizadores;
import com.ford.domain.Utilizador;
import com.ford.exceptions.UtilizadorNaoEncontradoException;
import com.ford.exceptions.WrongPasswordException;

public class EfetuarLoginHandler {
	
	public Optional<Utilizador> efetuarLogin(String username, String password) {
		Utilizador ut = null;
		try {
			ut = CatUtilizadores.getUser(username);
			if(ut.passwordEquals(password)) {
				JOptionPane.showConfirmDialog(null, "Login efetuado com sucesso!",null, JOptionPane.PLAIN_MESSAGE);
				//fechar este frame
				return Optional.of(ut);
			}
			
		} catch (UtilizadorNaoEncontradoException e ) {
			JOptionPane.showConfirmDialog(null, "Utilizador não encontrado!", null, JOptionPane.PLAIN_MESSAGE);
		} catch (NullPointerException e2) {
			JOptionPane.showConfirmDialog(null, "Utilizador não encontrado!", null, JOptionPane.PLAIN_MESSAGE);
		} catch (WrongPasswordException e) {
			JOptionPane.showConfirmDialog(null, "Password errada!", null, JOptionPane.PLAIN_MESSAGE);
		}
		
		return Optional.empty();
		
		
	}

}
