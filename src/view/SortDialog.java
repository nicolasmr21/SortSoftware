package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class SortDialog extends JDialog implements ActionListener{

	private AppFrame frame;
	
	private JPanel settings;
	private JPanel selection;
	
	private JLabel labSize;
	private JSpinner size;
	private JLabel labInterval;
	private JSpinner from;
	private JSpinner to;
	private JCheckBox checkRepeat;
	private JCheckBox checkSorted;
	private JCheckBox checkInvSorted;
	private JCheckBox checkRamdon;
	private JCheckBox checkPercentSorted;
	private JButton butGenerate;


	
	public SortDialog(AppFrame a) {
		
		frame = a;
		setSize(600, 500);
		setTitle("Dialogo");
		setLocationRelativeTo(frame);
		setLayout(new BorderLayout());
		
		settings = new JPanel();
		TitledBorder border = BorderFactory.createTitledBorder("Restricciones");
		border.setTitleColor(Color.blue);
		settings.setBorder (border);
		settings.setLayout(new BoxLayout(settings, BoxLayout.X_AXIS));
		settings.setBackground(Color.WHITE);
		
		labSize = new JLabel("Numero de Elementos: ");
		labSize.setFont(new Font("Serif", Font.PLAIN, 15));
		settings.add(labSize);
		size = new JSpinner();
		settings.add(size);
		
		settings.add(Box.createHorizontalStrut(40));
		labInterval = new JLabel("Intervalo de ");
		labInterval.setFont(new Font("Serif", Font.PLAIN, 15));
		settings.add(labInterval);
		from = new JSpinner();
		settings.add(from);
		JLabel h = new JLabel(" hasta ");
		h.setFont(new Font("Serif", Font.PLAIN, 15));
		settings.add(h);
		to = new JSpinner();
		settings.add(to);


		settings.add(Box.createHorizontalStrut(40));
		checkRepeat = new JCheckBox("Numeros repetidos");
		checkRepeat.setBackground(Color.WHITE);
		checkRepeat.setFont(new Font("Serif", Font.PLAIN, 15));
		settings.add(checkRepeat);

		
		add(settings, BorderLayout.NORTH);
		
		
		selection = new JPanel();
		selection.setLayout(new BoxLayout(selection, BoxLayout.Y_AXIS));
		selection.setBackground(Color.WHITE);
		
		
		selection.add(Box.createVerticalStrut(30));
		checkSorted = new JCheckBox("Valores ya ordenados");
		checkSorted.setBackground(Color.WHITE);
		checkSorted.setForeground(Color.blue);
		checkSorted.setFont(new Font("Serif", Font.PLAIN, 30));
		checkSorted.setAlignmentX(CENTER_ALIGNMENT);
		selection.add(checkSorted);
		
		selection.add(Box.createVerticalStrut(30));
		checkInvSorted = new JCheckBox("Valores inversamente ordenados");
		checkInvSorted.setBackground(Color.WHITE);
		checkInvSorted.setForeground(Color.blue);
		checkInvSorted.setFont(new Font("Serif", Font.PLAIN, 30));
		checkInvSorted.setAlignmentX(CENTER_ALIGNMENT);
		selection.add(checkInvSorted);
		
		selection.add(Box.createVerticalStrut(30));
		checkRamdon = new JCheckBox("Orden Aleatorio");
		checkRamdon.setBackground(Color.WHITE);
		checkRamdon.setForeground(Color.blue);
		checkRamdon.setFont(new Font("Serif", Font.PLAIN, 30));
		checkRamdon.setAlignmentX(CENTER_ALIGNMENT);
		selection.add(checkRamdon);
		
		selection.add(Box.createVerticalStrut(30));
		checkPercentSorted = new JCheckBox("Valores ordenados en un porcentaje");
		checkPercentSorted.setBackground(Color.WHITE);
		checkPercentSorted.setForeground(Color.blue);
		checkPercentSorted.setFont(new Font("Serif", Font.PLAIN, 30));
		checkPercentSorted.setAlignmentX(CENTER_ALIGNMENT);
		selection.add(checkPercentSorted);

		
		selection.add(Box.createVerticalStrut(30));
		butGenerate = new JButton("GENERAR");
		butGenerate.setAlignmentX(CENTER_ALIGNMENT);
		butGenerate.setFont(new Font("Serif", Font.PLAIN, 20));
		butGenerate.addActionListener(this);
		butGenerate.setActionCommand("GENERAR");
		butGenerate.setBackground(Color.BLUE);
		butGenerate.setForeground(Color.WHITE);
		
		selection.add(butGenerate);

		
		
		
		add(selection, BorderLayout.CENTER);

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		int n = Integer.parseInt(size.getValue().toString()); 
		int nfrom = Integer.parseInt(from.getValue().toString());
		int nto = Integer.parseInt(to.getValue().toString());
		
		if(command.equals("GENERAR")) {
			
			if(n>0) {
				
				if(nto>0) {
					
					if(!checkRepeat.isSelected()&&nto-nfrom+1<n) {
						JOptionPane.showMessageDialog(this, "El numero de elementos es muy grande para el intervalov"
								+ " ya que no se pueden repetir lo numeros");
					}
					else {
						
						if(checkSorted.isSelected()&&!checkInvSorted.isSelected()
						&&!checkPercentSorted.isSelected()&&!checkRamdon.isSelected()) {
							
							frame.generateAlreadyOrdered(n, nfrom, nto);
							
							
						}
						else if(!checkSorted.isSelected()&&checkInvSorted.isSelected()
								&&!checkPercentSorted.isSelected()&&!checkRamdon.isSelected()) {
							
							frame.generateInvOrderer(n, nfrom, nto);
							
						}
						else if(!checkSorted.isSelected()&&!checkInvSorted.isSelected()
								&&checkPercentSorted.isSelected()&&!checkRamdon.isSelected()) {
									
							try {
							String s = JOptionPane.showInputDialog(this, "Introduzca el porcentaje de desorden requerido en enteros");
							int percent = Integer.parseInt(s.trim());
							if(percent>0&&percent<=100) {
							frame.generatePercentOrdered(n, nfrom, nto, percent/100);
							}
							else {
								JOptionPane.showMessageDialog(this, "Porcentaje no valido");	
							}
							}
							catch(Exception s1){
								JOptionPane.showMessageDialog(this, "Escriba un numero valido");
							}
									
						}
						else if(!checkSorted.isSelected()&&!checkInvSorted.isSelected()
								&&!checkPercentSorted.isSelected()&&checkRamdon.isSelected()) {
							
							frame.generateRandom(n, nfrom, nto);
							
						}
						else {
							JOptionPane.showMessageDialog(this, "Elija solo una opcion");
						}
						
					}
					
				}
				else {
					JOptionPane.showMessageDialog(this, "Introduzca un intervalo de elementos minimo de tamaño 1");
				}
				
			}
			else {
				JOptionPane.showMessageDialog(this, "Introduzca un numero de elementos valido");
			}
			
			
			
		}
		
	}



	public JCheckBox getCheckRepeat() {
		return checkRepeat;
	}



	
	
}
