package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.util.Set;

import javax.swing.JFrame;

import model.Coprocessor;
import model.Generator;

//Hellow
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
		startMenu();
		coprocessor = new Coprocessor();
		coprocessor.setGenerator(new Generator(29, 14, 43, true));
		coprocessor.getGenerator().imprimir(coprocessor.getGenerator().randomOrdered());
		
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



	public static void main(String[] args) {
		
		AppFrame app = new AppFrame();
		app.setVisible(true);
		
	}

}
