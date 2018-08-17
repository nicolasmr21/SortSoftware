package model;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel implements ActionListener {

	private AppFrame frame; 
	private JLabel labBanner;
	private JButton butInsert;
	private JButton butGenerate;
	private JButton butSort;
	
	
	public MenuPanel(AppFrame a) {

		frame = a;
		
		setLayout(new FlowLayout());
		setAlignmentX(CENTER_ALIGNMENT);
		setBackground(Color.black);

		
		labBanner = new JLabel(new ImageIcon("image/banner.jpg"));
		labBanner.setAlignmentX(CENTER_ALIGNMENT);
		add(labBanner);
		labBanner.setLayout(new BoxLayout(labBanner, BoxLayout.PAGE_AXIS));
		labBanner.add(Box.createVerticalStrut(250));
		butInsert = new JButton("Insertar Manuelmente");
		butInsert.setForeground(Color.WHITE);
		butInsert.setFont(new Font("Serif", Font.BOLD, 60));
		butInsert.addActionListener(this);
		butInsert.setActionCommand("INSERTAR");
		butInsert.setBorder(null);
		butInsert.setContentAreaFilled(false);
		butInsert.setAlignmentX(CENTER_ALIGNMENT);
		labBanner.add(butInsert);
		
		labBanner.add(Box.createVerticalStrut(80));
		butGenerate = new JButton ("Generar Aleatoriamente ");
		butGenerate.setForeground(Color.WHITE);
		butGenerate.setFont(new Font("Serif", Font.BOLD, 60));
		butGenerate.addActionListener(this);
		butGenerate.setActionCommand("GENERAR");
		butGenerate.setBorder(null);
		butGenerate.setContentAreaFilled(false);
		butGenerate.setAlignmentX(CENTER_ALIGNMENT);
		labBanner.add(butGenerate); 
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		if(command.equals("INSERTAR")) {
			frame.startInsertion();
		}
		if(command.equals("GENERAR")) {
			frame.startSortDialog();
		}
		
	}
	
	

}
