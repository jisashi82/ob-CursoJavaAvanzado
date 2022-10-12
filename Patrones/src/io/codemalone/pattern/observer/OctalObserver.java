package io.codemalone.pattern.observer;

public class OctalObserver extends Observer{
	
	public OctalObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Binary Strng: " + Integer.toOctalString(subject.getState()));
	}

}
