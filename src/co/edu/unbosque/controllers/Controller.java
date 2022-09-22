package co.edu.unbosque.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.views.ConsoleView;

public class Controller implements ActionListener {

	ConsoleView consoleView;

	public Controller() {

	}

	public void start() {
		consoleView.print("Running controller...");

		addListeners();
	}

	private void addListeners() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void setConsoleView(ConsoleView consoleView) {
		this.consoleView = consoleView;
	}

}
