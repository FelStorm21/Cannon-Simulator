package me.vmamakers.cannonsim;

public class Main {
	public static void main(String[] args) {
		PhysicsEnvironment phys = new PhysicsEnvironment();
		SwingGui gui = new SwingGui(phys);
	}
}
