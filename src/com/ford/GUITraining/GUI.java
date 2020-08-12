package com.ford.GUITraining;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener{
	
	int count=0;
	private JFrame frame;
	private JLabel label;
	private JPanel panel;

	public GUI() {
		frame = new JFrame();
		JButton button = new JButton("Click me!");
		button.addActionListener(this);
		
		label = new JLabel("Number of clicks: 0");
		
		panel = new JPanel();
	
		
	
		panel.setBorder(BorderFactory.createEmptyBorder(100,100,50,50));
		panel.setLayout(new GridLayout(0,1));
		panel.add(button);
		panel.add(label);
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Ford");
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String [] args) {
		 new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		count ++;
		label.setText("Number of clicks: "+  count);
		
	}

	
}
