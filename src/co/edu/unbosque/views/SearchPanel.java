package co.edu.unbosque.views;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class SearchPanel extends JPanel {
	private JTextArea fileTxtArea;

	public SearchPanel() {
		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Archivo: "));

		initializeComponent();
	}

	private void initializeComponent() {
		fileTxtArea = new JTextArea();
		fileTxtArea.setEditable(false);

		JScrollPane aux = new JScrollPane(fileTxtArea);
		add(aux, BorderLayout.CENTER);

	}

	public JTextArea getFileTxtArea() {
		return fileTxtArea;
	}

	public void setFileTxtArea(JTextArea fileTxtArea) {
		this.fileTxtArea = fileTxtArea;
	}

}
