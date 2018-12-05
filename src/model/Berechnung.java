package model;

public class Berechnung {

	private double a;
	private double b;
	private char operator;
	
	public Berechnung(double a, double b, char operator) {
		this.a = a;
		this.b = b;
		this.operator = operator;
	}
	
	public double berechne() {
		switch (operator) {
		case '+':
			return a + b;
			
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if(b != 0) {
				return a / b;
			}else {
				return 1E14;
			}
		default:
			return 1E-14;

		
		}
	}
}
