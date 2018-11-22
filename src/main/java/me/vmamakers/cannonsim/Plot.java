package me.vmamakers.cannonsim;

import processing.core.PApplet;

public class Plot extends PApplet {  //EMBED THIS IN SWING TO ALLOW FOR TEXT INPUT - https://amnonp5.wordpress.com/2012/01/28/25-life-saving-tips-for-processing/
	
	public static final int WINDOW_SIZE = 650;
	
	public Plot() {
		
	}
	
	public static void main(String[] args) {
		String[] processingArgs = {"Plot"};
		Plot plot = new Plot();
		PApplet.runSketch(processingArgs, plot);
	}
	
	public void setup() {
		background(240);
		rectMode(CENTER);
	}
	
	public void settings() {
		size(WINDOW_SIZE, WINDOW_SIZE);
	}
	
	public void draw() {
		
	}
	
	public void mousePressed() {
		rect(mouseX, mouseY, 20, 20);
	}
	
	public void mouseDragged() {
		ellipse(mouseX, mouseY, 10, 10);
	}
	
}
