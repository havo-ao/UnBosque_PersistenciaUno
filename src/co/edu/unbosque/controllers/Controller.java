package co.edu.unbosque.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import co.edu.unbosque.models.BoyerMoore;
import co.edu.unbosque.models.FileLoader;
import co.edu.unbosque.views.ConsoleView;
import co.edu.unbosque.views.MainView;

public class Controller implements ActionListener {

	private ConsoleView consoleView;
	private MainView mainView;
	private FileLoader file;
	private BoyerMoore boyerMoore;
	private int numberOfTextRepetitions = 0;

	public Controller() {

	}

	public void start() {
		mainView = new MainView();
		consoleView = new ConsoleView();
		boyerMoore = new BoyerMoore();

		addListeners();
	}

	private void addListeners() {
		mainView.getPNorth().getLoadFileBtn().addActionListener(this);
		mainView.getPSouth().getSearch().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		String fileText;

		if (command.equals("LOAD")) {
			consoleView.print("Loading file ...");
			file = new FileLoader(mainView.openFileFromFileSystem());

			try {
				fileText = file.readFile();

				mainView.getPcenter().getFileTxtArea().setText(fileText);
				consoleView.print(fileText);

			} catch (IOException IOEx) {

				IOEx.printStackTrace();
				mainView.showErrorMessage("Unable to read the selected file.");

			} catch (NullPointerException NPEx) {

				NPEx.printStackTrace();
				mainView.showInfoMessage("No file was selected.");
			}

		} else if (command.equals("searching")) {

			try {

				if (file.getFileText() == null) {
					mainView.showErrorMessage("No file was selected. Please choose a file before seaching for a text.");
				} else {
					String searchText = mainView.getPSouth().getText1().getText();

					if (searchText.length() == 0) {
						mainView.showErrorMessage("Por favor ingrese un valor");

					} else {
						findText(file.getFileText(), searchText);

						// consoleView.print("Text to search: " + searchText);
						// consoleView.print("Filetext from search btn: \n" + file.getFileText());
						consoleView.print("Number of text repetitions: " + numberOfTextRepetitions);
						mainView.showInfoMessage("Coincidencias encontradas: " + numberOfTextRepetitions);
					}

				}

			} catch (NullPointerException e2) { // ADD REQUIRED EXCEPTIONS
				e2.printStackTrace();
				mainView.showErrorMessage("No file has been chosen. Please, select a file before searching for a text");

			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}

	}

	public void findText(String completeText, String textToFind) throws BadLocationException {
		char[] text = completeText.toCharArray();
		char[] pattern = textToFind.toCharArray();

		mainView.getPcenter().getFileTxtArea().getHighlighter().removeAllHighlights();

		DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(
				Color.CYAN);

		int textLength = text.length;
		int patternLength = pattern.length;
		int numberRepetitions = 0;

		int absoluteIndex = 0;

		boolean isActiveSearch = true;

		int initialPosition = 0;

		do {

			int pos = boyerMoore.indexOf(text, pattern);

			if (pos == -1) {
				isActiveSearch = false;

			} else {

				absoluteIndex += pos;

				int newTextLength = textLength - pos - patternLength;
				char[] newText = new char[newTextLength];
				int newTextIndex = 0;

				for (int index = 0; index < textLength; index++) {
					if (index > pos + patternLength) {
						newText[newTextIndex] = text[index];
						newTextIndex += 1;

						initialPosition = absoluteIndex + (patternLength * numberRepetitions) + numberRepetitions;

						mainView.getPcenter().getFileTxtArea().getHighlighter().addHighlight(initialPosition,
								initialPosition + patternLength, highlightPainter);

					}
				}

				text = newText;
				textLength = newTextLength;
				consoleView.print("Pattern found at position : " + pos);
				numberRepetitions += 1;

			}

		} while (isActiveSearch);

		if (numberRepetitions > 0)
			numberOfTextRepetitions = numberRepetitions;

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
