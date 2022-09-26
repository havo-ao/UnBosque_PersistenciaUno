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
		consoleView = new ConsoleView();
		addListeners();
	}

	private void addListeners() {
		mainView.getPNorth().getLoadFileBtn().addActionListener(this);
		mainView.getPSouth().getSearch().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("LOAD")) {
			consoleView.print("Loading file ...");
			try {
				file = new FileLoader(mainView.openFileFromFileSystem());
				String ext = file.getFile().getName().split("\\.")[1];
				if (ext.equals("txt") || ext.equals("TXT")) {
					String fileText = file.readFile();
					mainView.getPcenter().getFileTxtArea().setText(fileText);
				} else {
					mainView.showErrorMessage("Invalid file extension. Must be txt file.");
				}
			} catch (IOException IOEx) {
				IOEx.printStackTrace();
				mainView.showErrorMessage("Unable to read the selected file.");
			} catch (NullPointerException NPEx) {
				NPEx.printStackTrace();
				mainView.showInfoMessage("No file was selected.");
			} catch (IndexOutOfBoundsException IOBEx) {
				IOBEx.printStackTrace();
				mainView.showInfoMessage("Unable to get file extension.");
			}
		} else if (command.equals("searching")) {
			consoleView.print("Searching string in file...");
			try {
				if (file.getFileText() == null) {
					mainView.showErrorMessage("No file was selected. Please choose a file before seaching for a text.");
				} else {
					String searchText = mainView.getPSouth().getText1().getText();

					// PUT SEARCH LOGIC HERE

					consoleView.print("Text to search: " + searchText);
					consoleView.print("Filetext from search btn: \n" + file.getFileText());
				}
			} catch (NullPointerException e2) { // ADD REQUIRED EXCEPTIONS
				e2.printStackTrace();
				mainView.showErrorMessage("No file has been chosen. Please, select a file before searching for a text");
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
