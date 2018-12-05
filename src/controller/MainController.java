package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Berechnung;
import view.MainView;

public class MainController {

	public static void main(String[] args) {
		
		new MainController();

	}
	
	public MainController() {
		
		MainView view = new MainView("Taschenrechner");
		
		// Sehr schön ich habe meinen aufrug für die Rechnung in der View, was natürlich flasch ist
		view.addResultBtnActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String message;
				Berechnung calc1 = new Berechnung(view.getOperandOneValue(), view.getOperandTwoValue(), view.getOperatorChar());
				if (calc1.berechne() == 1E14) {
					message = "Division durch 0";
				}else if(calc1.berechne() == 1E-14) {
					message = "Ungültiger Operator, bitte beim Programmierer melden!";
				}else {
					message = Double.toString(calc1.berechne());
				}
				view.showResultDialog(message);
				
			}
		});
		
		view.setVisible(true);
		
		
	}

}
