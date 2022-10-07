package io.codemalone.pattern.facade;
/*
 * Facade es un patrón de diseño estructural que proporciona una interfaz simplificada a una biblioteca, 
 * un framework o cualquier otro grupo complejo de clases.
 */
public class Demo {

	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();
		
		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}

}
