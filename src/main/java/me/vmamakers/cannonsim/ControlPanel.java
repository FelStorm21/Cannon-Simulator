package me.vmamakers.cannonsim;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lombok.Getter;
import lombok.Setter;

public class ControlPanel extends JPanel {
	
	@Getter @Setter PhysicsEnvironment phys;
	
	public ControlPanel() {
		setPreferredSize(new Dimension(SwingGui.frameWidth/2 - 10, SwingGui.frameHeight/2 - 10));
		setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
	}
	
	public JTextField[] setupTextFields() {
		JTextField[] returnArray = new JTextField[4];
		
		JTextField angleInput = new JTextField(10);
		JLabel angleLabel = new JLabel("Enter angle: ");
		add(angleLabel); 
		add(angleInput);
		returnArray[0] = angleInput;
		
		JTextField v0Input = new JTextField(10);
		JLabel v0Label = new JLabel("Enter initial velocity (magnitude): ");
		add(v0Label); 
		add(v0Input);
		returnArray[1] = v0Input;
		
		JTextField x0Input = new JTextField(10);
		JLabel x0Label = new JLabel("Enter x0: ");
		add(x0Label); 
		add(x0Input);
		returnArray[2] = x0Input;
		
		JTextField y0Input = new JTextField(10);
		JLabel y0Label = new JLabel("Enter y0: ");
		add(y0Label); 
		add(y0Input);
		returnArray[3] = y0Input;
		
		return returnArray;
	}
	
	public JButton[] setupButtons() {
		JButton[] returnArray = new JButton[3];
		
		JButton colorButton = new JButton("Change color");
		add(colorButton);
		returnArray[0] = colorButton;
		
		
		JButton shootButton = new JButton("Shoot");
		add(shootButton);
		returnArray[1] = shootButton;
		
		
		JButton clearButton = new JButton("Clear");
		add(clearButton);
		returnArray[2] = clearButton;
		
		return returnArray;
	}
	
}
