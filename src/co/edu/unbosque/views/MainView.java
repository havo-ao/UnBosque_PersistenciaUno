package co.edu.unbosque.views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class MainView extends JFrame {

	public MainView() {
		setTitle("Buscador de palabras");
		setSize(600, 800);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		inicializarComponentes();

		getContentPane().setLayout(new BorderLayout(5, 5));
		getContentPane().setBackground(new Color(255, 255, 255));

	}

	private void inicializarComponentes() {
		// TODO Auto-generated method stub

	}
}
