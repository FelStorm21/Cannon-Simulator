package me.vmamakers.cannonsim;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

public class PhysicsEnvironment {   //think about changing to an interface
	
	@Getter @Setter CanvasPanel canvas;
	
	@Getter @Setter private int x0 = 0;
	@Getter @Setter private int y0 = 0;
	
	@Getter @Setter private float v0 = 75;
	@Getter @Setter private float angle = 45;
	
	private float[] parabolicCoeff;
	private float[] exponentialCoeff;
	
	public PhysicsEnvironment() {
		parabolicCoeff = new float[3];
		exponentialCoeff = new float[3];
	}
	
	public void calculateParabolicCoeff() {
		parabolicCoeff[0] = (-9.81f / (2 * v0 * v0 * (float) Math.pow(Math.cos(Math.toRadians(angle)), 2)));
		parabolicCoeff[1] = (float) Math.tan(Math.toRadians(angle));
		parabolicCoeff[2] = y0;
	}
	
	public Map<Float, Float> calculateParabolicTraj() {
		calculateParabolicCoeff();
		Map<Float, Float> result = new LinkedHashMap<>();
		for (int i = x0; i <= canvas.getWidth() - 10; i += 10) {
			result.put((float) i, parabolicCoeff[0] * (i - x0) * (i - x0) + parabolicCoeff[1] * (i - x0) + parabolicCoeff[2]);
		}
		result.forEach((k, v) -> System.out.println("y(" + k + ") = " + v));
		return result;
	}

	public float getParabolicCoeff(int index) {
		return parabolicCoeff[index];
	}

	public void setParabolicCoeff(int coeff, int index) {
		this.parabolicCoeff[index] = coeff;
	}
	
}
