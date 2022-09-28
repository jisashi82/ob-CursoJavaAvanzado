package io.codemalone.pattern.AbstractFactory;
//paso 2
public class MacOSButton implements Button{

	@Override
	public void paint() {
		System.out.println("You have created MacOSButton");		
	}

}
