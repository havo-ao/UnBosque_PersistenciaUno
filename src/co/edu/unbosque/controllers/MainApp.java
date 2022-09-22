package co.edu.unbosque.controllers;

import co.edu.unbosque.views.ConsoleView;

public class MainApp {

	private ConsoleView consoleView;

	private Controller controller;

	public static void main(String[] args) {
		new MainApp().start();
	}

	private void start() {
		initializeViews();
		initializeModels();
		initializeControllers();

		setViewsToControllers();
		setModelsToControllers();

		controller.start();
	}

	private void initializeViews() {
		consoleView = new ConsoleView();
	}

	private void initializeModels() {

	}

	private void initializeControllers() {
		controller = new Controller();
	}

	private void setViewsToControllers() {
		controller.setConsoleView(consoleView);
	}

	private void setModelsToControllers() {

	}

}
