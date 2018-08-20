package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.util.Set;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import model.Coprocessor;
import model.Generator;

public class AppFrame extends JFrame {
	
	private MenuPanel menu;
	private InsertPanel insertion;
	private GeneratePanel generator;
	private SortDialog dialog;
	private Coprocessor coprocessor;
	
	public AppFrame()  {
		
		setTitle("Coprocessor Sort Software");
		setSize(800, 700);
		setLocationRelativeTo(null);
		setBackground(Color.black);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		startMenu();
		coprocessor = new Coprocessor();
		
	}
	
	
	public void startMenu() {
		menu = new MenuPanel(this);
		add(menu);
		menu.setVisible(true);	
		if(insertion!=null) {
		insertion.setVisible(false);}
		if(generator!=null) {
		generator.setVisible(false);}
	}
	
	public void startInsertion() {
	
		if(menu!=null) {
		menu.setVisible(false);}
		if(generator!=null) {
		generator.setVisible(false);}
		insertion = new InsertPanel(this);
		add(insertion);
		insertion.setVisible(true);	
	}
	
	public void startSortDialog() {		
		dialog = new SortDialog(this);
		dialog.setVisible(true);
	}

	public void startGenerator() {
		
		if(menu!=null) {
		menu.setVisible(false);}
		if(insertion!=null) {
		insertion.setVisible(false);}
		
		generator = new GeneratePanel(this);
		add(generator);
		generator.setVisible(true);	
		
	}
	
	
	
	public void generateAlreadyOrdered(int nElements, int floor, int roof) {
		coprocessor.setGenerator(new Generator(nElements, floor, roof));
		
		if(dialog.getCheckRepeat().isSelected()) {
			coprocessor.getGenerator().setArray(coprocessor.getGenerator().alreadyOrderedRepeated());
		}
		else {
			coprocessor.getGenerator().setArray(coprocessor.getGenerator().alreadyOrdered());	
		}
		dialog.setVisible(false);
		startGenerator();
	}
	
	public void generateInvOrderer(int nElements, int floor, int roof) {
		coprocessor.setGenerator(new Generator(nElements, floor, roof));
		
		if(dialog.getCheckRepeat().isSelected()) {
			coprocessor.getGenerator().setArray(coprocessor.getGenerator().reverseOrderedRepeated());
		}
		else {	
			coprocessor.getGenerator().setArray(coprocessor.getGenerator().reverseOrdered());
		}
		dialog.setVisible(false);
		startGenerator();
	}
	
	public void generateRandom(int nElements, int floor, int roof) {
		coprocessor.setGenerator(new Generator(nElements, floor, roof));
		
		if(dialog.getCheckRepeat().isSelected()) {
			coprocessor.getGenerator().setArray(coprocessor.getGenerator().randomOrderedRepeated());
		}
		else {
			coprocessor.getGenerator().setArray(coprocessor.getGenerator().randomOrdered());
		}
		dialog.setVisible(false);
		startGenerator();
	}
	
	public void generatePercentOrdered(int nElements, int floor, int roof, double percent) {
		coprocessor.setGenerator(new Generator(nElements, floor, roof));
		
		if(dialog.getCheckRepeat().isSelected()) {
			coprocessor.getGenerator().setArray(coprocessor.getGenerator().percentOrderRepeated(((double)percent)/100));
		}
		else {
			coprocessor.getGenerator().setArray(coprocessor.getGenerator().percentOrder(((double)percent)/100));
		}
		dialog.setVisible(false);
		startGenerator();
	}


	public static void main(String[] args) {
		AppFrame app = new AppFrame();
		app.setVisible(true);
	}


	public Coprocessor getCoprocessor() {
		return coprocessor;
	}
	
	

}
