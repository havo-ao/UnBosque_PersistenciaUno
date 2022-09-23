package co.edu.unbosque.controllers;

import co.edu.unbosque.views.ConsoleView;
import co.edu.unbosque.views.MainView;

public class MainApp {

	private ConsoleView consoleView;
	private MainView mainView;
	private Controller controller;

	public static void main(String[] args) {
		new MainApp().start();
	}

	private void start() {
		initializeModels();
		initializeControllers();

		setViewsToControllers();
		setModelsToControllers();

		controller.start();
	}

	private void initializeModels() {

	}

	private void initializeControllers() {
		controller = new Controller();
	}

	private void setViewsToControllers() {
		controller.setMainView(mainView);
	}

	private void setModelsToControllers() {

	}

}
