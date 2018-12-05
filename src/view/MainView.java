package view;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;



public class MainView extends JFrame {
	
	private JSpinner operandOneSpinner;
	private JSpinner operandTwoSpinner;
	private JComboBox<Character> operatorBox;
	private JButton resultBtn;
	private JButton closeBtn;
	//private JOptionPane resultDialog;
	private JLabel imageLabel;
	private ImageIcon image;
	DefaultComboBoxModel<Character> operatorBoxModel;

	public MainView(String title) {
		
		this.setTitle(title);
		//this.setMinimumSize(new Dimension(600, 400));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setResizable(false);
		
		
		
		
		
		
		
		image = new ImageIcon("assets/math_de.jpg");
		imageLabel = new JLabel(image);
		
		
		//imagePanel.setBackground(Color.BLUE);
		
		this.add(imageLabel, BorderLayout.CENTER);
		
		
		JPanel bottomPanel = new JPanel();
		
		bottomPanel.setLayout(new BorderLayout());
		
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		
		JPanel calculatorPanel = new JPanel();
		
		calculatorPanel.setBorder(createTitledBorder("Rechnung"));
		//calculatorPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		bottomPanel.add(calculatorPanel, BorderLayout.NORTH);
		
		/*Double value = 0.1;
		Double minimum = -1000.0;
		Double maximum = 1000.0;
		Double stepSize = 0.1;*/
		operandOneSpinner = new JSpinner(new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1));
		operandTwoSpinner = new JSpinner(new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1));
		
		
		resultBtn = new JButton("Ergebnis");
		
		operatorBoxModel = new DefaultComboBoxModel<>();
		operatorBoxModel.addElement('+');
		operatorBoxModel.addElement('-');
		operatorBoxModel.addElement('*');
		operatorBoxModel.addElement('/');
		operatorBox = new JComboBox<>(operatorBoxModel);
		
		calculatorPanel.add(operandOneSpinner);
		calculatorPanel.add(operatorBox);
		calculatorPanel.add(operandTwoSpinner);
		calculatorPanel.add(resultBtn);
		
		
		
		
		
		
		JPanel etcPanel = new JPanel();
		
		
		etcPanel.setBorder(createTitledBorder("Sonstiges"));
		bottomPanel.add(etcPanel, BorderLayout.SOUTH);
		//etcPanel.setLayout(new BoxLayout(etcPanel, BoxLayout.Y_AXIS));
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		etcPanel.add(centerPanel);
		
		
		
		JCheckBox versionJB = new JCheckBox("International");
		centerPanel.add(versionJB);
		closeBtn = new JButton("Schließen");
		centerPanel.add(closeBtn);
		
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		versionJB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (versionJB.isSelected()) {
					changeImage(true);
				} else {
					changeImage(false);
				}
				
			}
		});
		
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	private Border createTitledBorder(String title) {
		
		return BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title);
	}
	private void changeImage(boolean en) {
		if (en) {
			imageLabel.setIcon(new ImageIcon("assets/math_en.jpg"));
			// Geil gelöst das Syso kann noch raus :)
			System.out.println("en");
		}else {
			imageLabel.setIcon(new ImageIcon("assets/math_de.jpg"));
		}
	}
	public double getOperandOneValue() {
		return (double) operandOneSpinner.getValue();
	}
	
	public double getOperandTwoValue() {
		return (double) operandTwoSpinner.getValue();
	}
	public char getOperatorChar() {
		return operatorBoxModel.getElementAt(operatorBox.getSelectedIndex()).charValue();
	}
	
	public void addResultBtnActionListener(ActionListener al) {
		resultBtn.addActionListener(al);
	}
	
	public void showResultDialog(String content) {
		JOptionPane.showMessageDialog(this, content);
	}
}
