package io.codemalone.pattern.facade;
//paso 2.- crear la clase concreta que impolemente la interface
public class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Rectangle::draw()");
	}

}
