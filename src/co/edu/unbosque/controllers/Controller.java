package co.edu.unbosque.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import co.edu.unbosque.models.FileLoader;
import co.edu.unbosque.views.ConsoleView;
import co.edu.unbosque.views.MainView;

public class Controller implements ActionListener {

	private ConsoleView consoleView;
	private MainView mainView;
	private FileLoader file;

	public Controller() {

	}

	public void start() {
		mainView = new MainView();
		addListeners();
	}

	private void addListeners() {
		mainView.getPNorth().getLoadFileBtn().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals("LOAD")) {
			System.out.println("Loading file ...");
			file = new FileLoader(mainView.openFileFromFileSystem());
			try {
				String fileText = file.readFile();
				mainView.getPcenter().getFileTxtArea().setText(fileText);
				System.out.println(fileText);
			} catch (IOException IOEx) {
				IOEx.printStackTrace();
				mainView.showErrorMessage("Unable to read the selected file.");
			} catch (NullPointerException NPEx) {
				NPEx.printStackTrace();
				mainView.showInfoMessage("No file was selected.");
			}
		}

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
