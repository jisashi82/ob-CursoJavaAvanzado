package io.codemalone.pattern.observer;

public class HexaObserver extends Observer{
	
	public HexaObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Binary Strng: " + Integer.toHexString(subject.getState()).toUpperCase());		
	}

}
