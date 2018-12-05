package me.vmamakers.cannonsim;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import lombok.Getter;
import lombok.Setter;

public class CanvasPanel extends JPanel {
	
	public static final Color SKY_BLUE = new Color(135, 206, 250);
	public static final Color SUNSET = new Color(253, 94, 83);
	@Getter @Setter private Color color = SKY_BLUE;
	
	private int[] graphicsOrigin = {0, 0};
	@Getter @Setter private int[] physicsOrigin;
	
	@Getter @Setter private Map<Float, Float> trajectory;
	
	public CanvasPanel() {
		trajectory = new HashMap<>();
		setPreferredSize(new Dimension(SwingGui.frameWidth/2 - 10, SwingGui.frameHeight/2 - 10));
	}
	
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);  //this paints the JPanel normally, using the non-overriden paintComponent() method
		setBackground(color);
		
		g.setColor(Color.BLACK);
		trajectory.forEach((k,v) -> {
//			if (k != null) {
				g.drawOval((int) (physicsOrigin[0] + k), (int) (physicsOrigin[1] - v), 5, 5);  //measured at upper left corner, not center
//			}
		});
	}
	
}
