package me.vmamakers.cannonsim;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SwingGui {
	
	private JFrame frame;
	private CanvasPanel canvas;
	private ControlPanel controlPanel;
	private JTextField[] inputs; //angle, v0, x0, y0
	private JButton[] buttons; //color, shoot, clear
	private int[] counts = {0};
	
	private Cannon cannon;
	private CannonBall cball;
	private Target target;
	private PhysicsEnvironment phys; 
	
	public static final Dimension windowSize = calculateFrameSize();
	public static final int frameWidth = (int) (windowSize.width / 1.5);
	public static final int frameHeight = (int) (windowSize.height / 1.3);
	
	public SwingGui(PhysicsEnvironment phys) {
		this.phys = phys;

		SwingUtilities.invokeLater(this::initGui);
	}
	
	/**
	 * Sets up the {@link JFrame frame}, {@link ControlPanel controlPanel}, and {@link CanvasPanel canvas}, 
	 * calls {@link #setupActionListeners()}, calls {@link #prepareAndShow()} to display the simulation window.  
	 */
	public void initGui() {
		System.out.println("Canvas panel pixel width: " + (frameWidth/2 - 10));
		System.out.println("Canvas panel pixel height: " + (frameHeight/2 - 10));
		
		frame = new JFrame("Simulation Control");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		controlPanel = new ControlPanel();
		inputs = controlPanel.setupTextFields();
		buttons = controlPanel.setupButtons();	
		frame.add(controlPanel);
		
		canvas = new CanvasPanel();
//		canvas.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		phys.setCanvas(canvas);
		frame.add(canvas);
		
		setupActionListeners();
		prepareAndShow();
	}
	
	/**
	 * Sets up all the action listeners for textfields and buttons.
	 */
	public void setupActionListeners() {
		inputs[0].addActionListener((e) -> {  //angle input
			phys.setAngle(Float.parseFloat(inputs[0].getText()));
			inputs[0].setText("");
			inputs[1].requestFocus();
		});
		
		inputs[1].addActionListener((e) -> {  //v0 input
			phys.setV0(Float.parseFloat(inputs[1].getText()));
			inputs[1].setText("");
			inputs[2].requestFocus();
		});
		
		inputs[2].addActionListener((e) -> {  //x0 input
			phys.setX0(Integer.parseInt(inputs[2].getText()));
			inputs[2].setText("");
			inputs[3].requestFocus();
		});
		
		inputs[3].addActionListener((e) -> {  //y0 input
			phys.setY0(Integer.parseInt(inputs[3].getText()));
			inputs[3].setText("");
			buttons[1].requestFocus();
		});
		
		buttons[0].addActionListener((e) -> {  //color button
			if (counts[0] == 1) {
				canvas.setColor(CanvasPanel.SKY_BLUE);
				canvas.repaint();
				counts[0]--;
			} else {
				canvas.setColor(CanvasPanel.SUNSET);
				canvas.repaint();
				counts[0]++;
			}
		});
		
		buttons[1].addActionListener((e) -> {  //shoot button
			canvas.setTrajectory(phys.calculateParabolicTraj());
			canvas.repaint();
		});
		
		buttons[2].addActionListener((e) -> {  //clear button
			canvas.getTrajectory().clear();
			canvas.repaint();
		});
	}
	
	/**
	 * Packs the {@link JFrame frame}, calls {@link CanvasPanel#setPhysicsOrigin(int[])} to transform from
	 * the top-bottom window coordinate space to standard x-y space, sets {@link JFrame frame}'s location to the center of the screen, 
	 * sets {@link JFrame frame} to visible. 
	 */
	public void prepareAndShow() {
		frame.pack();
		canvas.setPhysicsOrigin(new int[] {0, canvas.getHeight()});
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	/**
	 * Gets the size of the screen.
	 * @return the size of the screen in pixels
	 */
	public static Dimension calculateFrameSize() {
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
}
