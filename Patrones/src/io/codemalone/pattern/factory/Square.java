package io.codemalone.pattern.factory;

//Paso 2.- Crear clases que implementen la interface
public class Square implements Shape{

	public Square() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method");
	}

}
