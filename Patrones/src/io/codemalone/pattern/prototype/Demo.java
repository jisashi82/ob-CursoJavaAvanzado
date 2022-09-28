package io.codemalone.pattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>();
		List<Shape> shapesCopy = new ArrayList<>();
		
		Circle circle1= new Circle();
		circle1.x=10;
		circle1.y=20;
		circle1.radius = 15;
		circle1.color ="red";
		shapes.add(circle1);
		
		Circle circle2= (Circle) circle1.clone();
		shapes.add(circle2);
		
		Rectangle rectangle = new Rectangle();
		rectangle.width = 10;
		rectangle.height =20;
		rectangle.color ="blue";
		shapes.add(rectangle);
		
		cloneAndCompare(shapes, shapesCopy);

	}
	
	private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
		for(Shape shape : shapes) {
			shapesCopy.add(shape.clone());
		}
		
		for(int i = 0; i< shapes.size(); i++) {
			if(shapes.get(i) != shapesCopy.get(i)) {
				System.out.println(i + ": Shapes son diferentes objects (yahoo!)");
				if(shapes.get(i).equals(shapesCopy.get(i))) {
					System.out.println(i + ": y ellos son identicos (yahoo!)");
				} else {
					System.out.println(i +": Pero ellos no son identicos (Buuu)");
				}
			} else {
				System.out.println(i +": Los Objetos Shae son el mismo (Buuuu)");
			}
		}
		
	}

}
