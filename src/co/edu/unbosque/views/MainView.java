package co.edu.unbosque.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainView extends JFrame {
	private SearchPanel searchPanel;
	private JButton loadFileBtn; // Dummy btn for testing

	public MainView() {
		setTitle("Buscador de palabras");
		setSize(600, 800);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(5, 5));
		getContentPane().setBackground(new Color(255, 255, 255));

		initializeComponents();

		setVisible(true);
	}

	private void initializeComponents() {
		JPanel aux = new JPanel();
		loadFileBtn = new JButton("Cargar archivo");
		loadFileBtn.setActionCommand("LOAD");
		aux.add(loadFileBtn);
		getContentPane().add(aux, BorderLayout.NORTH);
		
		searchPanel = new SearchPanel();
		getContentPane().add(searchPanel, BorderLayout.CENTER);

	}
	
	public File openFileFromFileSystem() {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("Selected file: " + chooser.getSelectedFile().getName());
			return chooser.getSelectedFile();
		}
		return null;
	}
	
	public void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void showInfoMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.INFORMATION_MESSAGE);
	}

	public SearchPanel getSearchPanel() {
		return searchPanel;
	}

	public void setSearchPanel(SearchPanel searchPanel) {
		this.searchPanel = searchPanel;
	}

	/**
	 * @return the loadFileBtn
	 */
	public JButton getLoadFileBtn() {
		return loadFileBtn;
	}

	/**
	 * @param loadFileBtn the loadFileBtn to set
	 */
	public void setLoadFileBtn(JButton loadFileBtn) {
		this.loadFileBtn = loadFileBtn;
	}
}
