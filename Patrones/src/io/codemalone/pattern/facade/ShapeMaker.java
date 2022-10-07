package io.codemalone.pattern.facade;
//Paso 3.- crear un clase Facade
public class ShapeMaker {
	
	//usar la interface Shape en lugar de las clases.
	private Shape circle;
	private Shape square;
	private Shape rectangle;
	
	public ShapeMaker() {
		circle = new Circle();
		square= new Square();
		rectangle = new Rectangle();
	}
	
	public void drawCircle() {
		circle.draw();
	}

	public void drawRectangle() {
		rectangle.draw();
	}
	
	public void drawSquare() {
		square.draw();
	}
}
