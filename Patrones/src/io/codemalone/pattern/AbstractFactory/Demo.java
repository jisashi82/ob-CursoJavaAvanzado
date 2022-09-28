package io.codemalone.pattern.AbstractFactory;

public class Demo {
	
	private static FactoryProducer configureApp() {
		FactoryProducer app;
		GUIFactory factory;
		
		String osName= System.getProperty("os.name").toLowerCase();
		if(osName.contains("mac")) {
			factory = new MacOSFactory();
		}
		else {
			factory = new WindowsFactory();
		}
		
		app = new FactoryProducer(factory);
		return app;
		
	}
	
	
	public static void main(String[] args) {
		FactoryProducer app = configureApp();
		app.paint();
	}

}
