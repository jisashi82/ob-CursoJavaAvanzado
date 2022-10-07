package io.codemalone.pattern.facade;
//paso 2.- crear la clase concreta que impolemente la interface
public class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Circle::draw()");
	}

}
