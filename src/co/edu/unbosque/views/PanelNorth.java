package co.edu.unbosque.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelNorth extends JPanel{

	private JButton loadFileBtn;
	private Color Color1 = new Color(76,114,115,255);
	public PanelNorth() {
	setLayout(new BorderLayout());
	setBackground(Color1);
	setBorder(new TitledBorder("...WORD SEARCH..."));
	setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
	initializeComponents();
	setVisible(true);
	}

	private void initializeComponents() {
		
		loadFileBtn = new JButton("LOAD FILE");
		loadFileBtn.setActionCommand("LOAD");
		loadFileBtn.setBackground(Color1);
		loadFileBtn.setFont(new Font("arial", Font.BOLD, 15));
		loadFileBtn.setBorder(null);
		add(loadFileBtn, BorderLayout.CENTER);
		
	}

	public JButton getLoadFileBtn() {
		return loadFileBtn;
	}

	public void setLoadFileBtn(JButton loadFileBtn) {
		this.loadFileBtn = loadFileBtn;
	}

	public Color getColor1() {
		return Color1;
	}

	public void setColor1(Color color1) {
		Color1 = color1;
	}
	
	
}
