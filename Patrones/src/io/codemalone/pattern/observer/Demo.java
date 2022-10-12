package io.codemalone.pattern.observer;
/*
 * Observer es un patrón de diseño de comportamiento que te permite definir un mecanismo de suscripción para 
 * notificar a varios objetos sobre cualquier evento que le suceda al objeto que están observando
 */

public class Demo {

	public static void main(String[] args) {
		Subject subject = new Subject();
		
		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);
		
		System.out.println("First state change: 15");
		subject.setState(15);
		System.out.println("Second state change: 20");
		subject.setState(20);
		

	}

}
