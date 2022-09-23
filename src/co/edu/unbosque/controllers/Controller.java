package co.edu.unbosque.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.views.ConsoleView;
import co.edu.unbosque.views.MainView;

public class Controller implements ActionListener {

	private ConsoleView consoleView;
	private MainView mainView;

	public Controller() {

	}

	public void start() {
		mainView = new MainView();
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

	public MainView getMainView() {
		return mainView;
	}

	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}

}
