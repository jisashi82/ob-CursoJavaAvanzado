package io.codemalone.pattern.Adapter;

public class RoudHole {
	
	private double radius;
	
	public RoudHole(double r) {
		radius = r;
	}

	public double getRadius() {
		return radius;
	}
	
	public boolean fits(RoundPeg peg) {
		boolean result;
		result = this.getRadius() >= peg.getRadius();
		return result;
	}
}
