package io.codemalone.pattern.Adapter;

public class SquarePeg {
	
	private double width;
	
	public SquarePeg(double width) {
		this.width =width;
	}

	public double getWidth() {
		return width;
	}
	
	public double getSquare() {
		double result;
		result = Math.pow(this.getWidth(), 2);
		return result;
	}

}
