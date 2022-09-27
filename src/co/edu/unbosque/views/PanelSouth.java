package co.edu.unbosque.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelSouth extends JPanel {
	private JLabel label;
	private JButton search;
	private JTextField text1;
	private JSeparator separator;
	private Color color1;

	public PanelSouth() {
		setLayout(new GridLayout(4, 0));
		color1 = new Color(135, 185, 176, 255);
		setBackground(color1);
		setBorder(new TitledBorder(""));
		initializeComponents();
	}

	private void initializeComponents() {

		label = new JLabel("...Write a word... ");
		label.setFont(new Font("arial", Font.BOLD, 25));
		add(label);

		text1 = new JTextField(30);
		text1.setFont(new Font("arial", Font.BOLD, 20));
		setOpaque(false);
		text1.setBorder(null);
		add(text1);

		separator = new JSeparator();
		separator.setBounds(20, 20, 20, 20);
		;
		add(separator);

		search = new JButton("Search");
		search.setActionCommand("searching");
		search.setFont(new Font("arial", Font.PLAIN, 20));
		search.setBackground(color1);
		search.setBorder(null);
		add(search);

	}

	public JTextField getText1() {
		return text1;
	}

	public void setText(JTextField text) {
		this.text1 = text;
	}

	public JButton getSearch() {
		return search;
	}

	public void setSearch(JButton search) {
		this.search = search;
	}
}
