package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InsertPanel extends JPanel implements ActionListener{

	private AppFrame frame;
	private JLabel labValues;
	private JSpinner txtNum;
	private JButton butAgregar;
	private JTextArea txtValues;
	private JButton butSort;
	private JButton butBack;
	
	
	public InsertPanel(AppFrame a) {
		
		frame = a;
		
		setSize(800, 800);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setAlignmentX(CENTER_ALIGNMENT);
		setBackground(Color.WHITE);
		
		add(Box.createVerticalStrut(10));
		labValues = new JLabel("Digite los valores a ordenar");
		labValues.setForeground(Color.blue);
		labValues.setAlignmentX(CENTER_ALIGNMENT);
		labValues.setFont(new Font("Serif", Font.BOLD, 65));
		JLabel ins = new JLabel("Los numeros deben ir separados por un guion");
		ins.setForeground(Color.WHITE);
		ins.setAlignmentX(CENTER_ALIGNMENT);
		ins.setFont(new Font("Serif", Font.BOLD, 25));
		add(labValues); add(ins);
		
		JPanel aux = new JPanel();
		aux.setLayout(new BoxLayout(aux, BoxLayout.X_AXIS));
		aux.setBackground(Color.WHITE);
		txtNum = new JSpinner();
		txtNum.setFont(new Font("Serif", Font.BOLD, 90));
		txtNum.setBounds(new Rectangle(100, 100, 50, 50));
		txtNum.setPreferredSize(new Dimension(50, 50));
		aux.add(Box.createHorizontalStrut(300));
		aux.add(txtNum); aux.add(Box.createHorizontalStrut(300));
		add(aux);

		add(Box.createVerticalStrut(5));
		butAgregar = new JButton("AGREGAR");
		butAgregar.setFont(new Font("Serif", Font.BOLD, 10));
		butAgregar.setAlignmentX(CENTER_ALIGNMENT);
		butAgregar.addActionListener(this);
		butAgregar.setBackground(Color.BLUE);
		butAgregar.setForeground(Color.WHITE);
		butAgregar.setActionCommand("AGREGAR");
		add(butAgregar);
		
		
		
		add(Box.createVerticalStrut(50));
		txtValues = new JTextArea(5, 20);
		txtValues.setLineWrap(true);
		txtValues.setEditable(false);
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
		butSort.addActionListener(this);
		butSort.setBackground(Color.BLUE);
		butSort.setForeground(Color.WHITE);
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
		else if(command.equals("AGREGAR")) {
			String s = txtNum.getValue().toString();
			int n = Integer.parseInt(s);
			txtValues.setText(txtValues.getText()+n+"-");
		}
		else if(command.equals("ORDENAR")) {
			String[] ar = txtValues.getText().split("-");
			int [] values = new int[ar.length];
			for (int i = 0; i < ar.length; i++) {
				values[i] = Integer.parseInt(ar[i]);
			}
		}
		
	}
	
}
