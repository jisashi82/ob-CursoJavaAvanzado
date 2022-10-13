package io.codemalone.pattern.mediator;

public class ColegaConcreto1 extends Colega {

	@Override
	void recibe() {
		System.out.println("He recibido un mensaje, Soy ColegaConcreto1");		
	}

	@Override
	void envia() {
		System.out.println("Soy ColegaConcreto1, envio un mensaje");
		mediator.reenvia(this);		
	}

}
