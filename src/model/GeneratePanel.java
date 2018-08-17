package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GeneratePanel extends JPanel implements ActionListener{

	private AppFrame frame; 
	private JLabel labValues;
	private JTextArea txtValues;
	private JButton butSort;
	private JButton butBack;
	
	
	public GeneratePanel(AppFrame a) {
		
		frame = a;
		
		setSize(800, 800);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setAlignmentX(CENTER_ALIGNMENT);
		setBackground(Color.black);
		
		add(Box.createVerticalStrut(10));
		labValues = new JLabel("Valores generados Aleatoriamente");
		labValues.setForeground(Color.WHITE);
		labValues.setAlignmentX(CENTER_ALIGNMENT);
		labValues.setFont(new Font("Serif", Font.BOLD, 40));
		add(labValues); 
		
		add(Box.createVerticalStrut(50));
		txtValues = new JTextArea(5, 20);
		txtValues.setLineWrap(true);
		txtValues.setFont(new Font("Serif", Font.PLAIN, 15));
		txtValues.setBackground(Color.WHITE);
		txtValues.setForeground(Color.blue);
		txtValues.setWrapStyleWord(true);
		txtValues.setAlignmentX(CENTER_ALIGNMENT);
		JScrollPane scroll = new JScrollPane(txtValues);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll);
		
		add(Box.createVerticalStrut(40));
		butSort = new JButton("Ordenar");
		butSort.setFont(new Font("Serif", Font.BOLD, 30));
		butSort.setAlignmentX(CENTER_ALIGNMENT);
		butSort.setBackground(Color.BLUE);
		butSort.setForeground(Color.WHITE);
		butSort.addActionListener(this);
		butSort.setActionCommand("ORDENAR");
		add(butSort);
		
		add(Box.createVerticalStrut(10));
		butBack = new JButton("Salir");
		butBack.setFont(new Font("Serif", Font.BOLD, 10));
		butBack.setAlignmentX(CENTER_ALIGNMENT);
		butBack.addActionListener(this);
		butBack.setBackground(Color.BLUE);
		butBack.setForeground(Color.WHITE);
		butBack.setActionCommand("SALIR");
		add(butBack);
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		
		if(command.equals("SALIR")) {
			frame.startMenu();
		}
		
	}
	
	
}
