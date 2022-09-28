package io.codemalone.pattern.factory;

public class Demo {
	
	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		
		Shape circle = factory.getShape("CIRCLE");
		Shape rectangle = factory.getShape("RECTANGLE");
		Shape square = factory.getShape("SQUARE");
		
		circle.draw();
		rectangle.draw();
		square.draw();
	}

}
