package io.codemalone.pattern.Adapter;

public class Demo {
	
	public static void main(String args[]) {
		
		RoudHole hole = new RoudHole(5);
		RoundPeg rpeg = new RoundPeg(5);
		if(hole.fits(rpeg)) {
			System.out.println("Round Peg r5 fits round hole r5");
		}
		
		SquarePeg smallSqPeg = new SquarePeg(2);
		SquarePeg largeSqPeg = new SquarePeg(8);
		
		SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
		SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
		if(hole.fits(smallSqPegAdapter)) {
			System.out.println("Square Peg w2 fits roud hole r5");
		}
		if(hole.fits(largeSqPegAdapter)) {
			System.out.println("Square Peg w10 fits roud hole r5");
		} else {
			System.out.println("Square peg w10 does not fit into round hole r5");
		}
	}

}
