package com.ford.GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.ford.domain.Utilizador;
import com.ford.events.LoginEfetuadoEvent;
import com.ford.handlers.EfetuarLoginHandler;

import utils.observer.Event;
import utils.observer.Observable;
import utils.observer.Observer;

public class GUILogin implements ActionListener,Observable {
	
	private JFrame frame;
	private JPanel panel;
	private JLabel label;
	private JLabel pwLabel;
	private JTextField usernameTextField;
	private JPasswordField pwField;
	
	private Button button;
	private Button cancelar;
	private Observer notificarApp;
	private Utilizador user;
	
	
	public void inicializeGuiLogin() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel("Username");
		pwLabel = new JLabel("Password");
		
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
		frame.add(panel);
		panel.setLayout(null);
		
		label.setBounds(25,20 ,80,25);
		panel.add(label);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(100,20,165,25);
		panel.add(usernameTextField);
		
		pwLabel.setBounds(25, 50, 80, 25);
		panel.add(pwLabel);
		
		pwField = new JPasswordField();
		pwField.setBounds(100,50,165,25);
		panel.add(pwField);

		
	    button = new Button("Confirm");
		button.setBounds(200, 130, 165, 25);
		button.setBackground(Color.GREEN);
		//button.setForeground(Color.GREEN);
		button.addActionListener(this);
	
		panel.add(button);
		
	    cancelar = new Button("Reset");
		cancelar.setBounds(25, 130, 165, 25);
		cancelar.setBackground(Color.RED);
		cancelar.addActionListener(this);
		panel.add(cancelar);
		
		
		frame.setVisible(true);	
		
		//centrar frame
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
	}
	

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		Button b = (Button) e.getSource();
	
		if(b.equals(button)) {
			EfetuarLoginHandler handlerLogin = new EfetuarLoginHandler();
			Optional<Utilizador> ut = handlerLogin.efetuarLogin(usernameTextField.getText(), pwField.getText());
			
			if(ut.isPresent()) {
				//fechar este frame
				this.user=ut.get();
				notifyObservers(new LoginEfetuadoEvent(user));
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				
			}
		}else if (b.equals(cancelar)){
					
			usernameTextField.setText("");
			pwField.setText("");
			
		}
	
		
	}


	@Override
	public void addObserver(Observer observer) {
		this.notificarApp = observer;
		
	}

	@Override
	public void removeObserver(Observer observer) {
		//Does nothing
		
	}


	@Override
	public void notifyObservers(Event e) {
		notificarApp.update(e);
		
		
	}
	
	

}
