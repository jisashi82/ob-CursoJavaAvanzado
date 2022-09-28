package io.codemalone.pattern.factory;

//Paso 3.- Crear una Clase Factory que genere las clases concretas de acuerdo al parametro que se le pasa
public class ShapeFactory {

	public ShapeFactory() {
		// TODO Auto-generated constructor stub
	}

	public Shape getShape(String shapeType) {
		switch (shapeType) {
		case "CIRCLE" -> {
			return new Circle();
		}
		case "SQUARE" -> {
			return new Square();
		}
		case "RECTANGLE" -> {
			return new Rectangle();
		}
		default -> {
			return null;
		}
		}
	}

}
