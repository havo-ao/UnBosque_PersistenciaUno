package co.edu.unbosque.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainView extends JFrame {
	private PanelCenter Pcenter;
	private PanelSouth PSouth;
	private PanelNorth PNorth;

	public MainView() {
		setTitle("Buscador de palabras");
		setSize(600, 800);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.white);
		getContentPane().setLayout(new BorderLayout(5, 5));
		getContentPane().setBackground(new Color(255, 255, 255));

		initializeComponents();

		setVisible(true);
	}

	private void initializeComponents() {

		Pcenter = new PanelCenter();
		getContentPane().add(Pcenter, BorderLayout.CENTER);
		
		PSouth = new PanelSouth();
		getContentPane().add(PSouth, BorderLayout.SOUTH);
		
		PNorth = new PanelNorth();
		getContentPane().add(PNorth, BorderLayout.NORTH);

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

	public PanelCenter getPcenter() {
		return Pcenter;
	}

	public void setPcenter(PanelCenter pcenter) {
		Pcenter = pcenter;
	}

	public PanelSouth getPSouth() {
		return PSouth;
	}

	public void setPSouth(PanelSouth pSouth) {
		PSouth = pSouth;
	}

	public PanelNorth getPNorth() {
		return PNorth;
	}

	public void setPNorth(PanelNorth pNorth) {
		PNorth = pNorth;
	}

	/**
	 * @return the loadFileBtn
	 */
	
}
