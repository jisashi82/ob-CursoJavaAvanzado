package io.codemalone.pattern.mediator;

public class ColegaConcreto3 extends Colega {

	@Override
	void recibe() {
		System.out.println("He recibido un mensaje, Soy ColegaConcreto3");		
	}

	@Override
	void envia() {
		System.out.println("Soy ColegaConcreto3, envio un mensaje");
		mediator.reenvia(this);		
	}

}
