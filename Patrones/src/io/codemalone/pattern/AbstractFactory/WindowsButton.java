package io.codemalone.pattern.AbstractFactory;
//paso 2
public class WindowsButton implements Button{

	@Override
	public void paint() {
		System.out.println("You have created WindowsButton");
	}

}
