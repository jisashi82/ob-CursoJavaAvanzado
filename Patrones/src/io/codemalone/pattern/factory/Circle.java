package io.codemalone.pattern.factory;

//Paso 2.- Crear clases que implementen la interface
public class Circle implements Shape{

	public Circle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() Method");
	}

}
