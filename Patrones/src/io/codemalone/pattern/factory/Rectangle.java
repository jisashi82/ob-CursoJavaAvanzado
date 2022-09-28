package io.codemalone.pattern.factory;

//Paso 2.- Crear clases que implementen la interface
public class Rectangle implements Shape {

	public Rectangle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method");
	}

}
