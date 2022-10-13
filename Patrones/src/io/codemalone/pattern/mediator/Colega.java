package io.codemalone.pattern.mediator;

public abstract class Colega {
	
	public Mediator mediator;
	
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	
	abstract void recibe();
	abstract void envia();
	

}
