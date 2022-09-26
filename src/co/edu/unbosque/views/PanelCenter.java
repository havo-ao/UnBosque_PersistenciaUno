package co.edu.unbosque.views;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

public class PanelCenter extends JPanel {
	private JTextPane fileTxtArea;

	public PanelCenter() {
		setLayout(new BorderLayout());
		setBorder(new TitledBorder("...FILE..."));
		initializeComponent();
		setVisible(true);
		
	}

	private void initializeComponent() {
		fileTxtArea = new JTextPane();
		fileTxtArea.setEditable(false);

		JScrollPane aux = new JScrollPane(fileTxtArea);
		add(aux, BorderLayout.CENTER);

	}

	public JTextPane getFileTxtArea() {
		return fileTxtArea;
	}

	public void setFileTxtArea(JTextPane fileTxtArea) {
		this.fileTxtArea = fileTxtArea;
	}

}
