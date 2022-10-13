package io.codemalone.pattern.mediator;

public class ColegaConcreto2 extends Colega {

	@Override
	void recibe() {
		System.out.println("He recibido un mensaje, Soy ColegaConcreto2");		
	}

	@Override
	void envia() {
		System.out.println("Soy ColegaConcreto2, envio un mensaje");
		mediator.reenvia(this);		
	}

}
