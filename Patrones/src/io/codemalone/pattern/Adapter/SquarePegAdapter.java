package io.codemalone.pattern.Adapter;

public class SquarePegAdapter extends RoundPeg {
	private SquarePeg peg;	

	public SquarePegAdapter(SquarePeg p) {
		this.peg =p;
	}

	@Override
	public double getRadius() {
		double result;
		 // Calculate a minimum circle radius, which can fit this peg.
        result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        return result;
	}

}
