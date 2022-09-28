package io.codemalone.pattern.AbstractFactory;

//paso 5.-Create a Factory generator/producer class to get factories by passing an information such as GuiFactory
public class FactoryProducer {
	
	private Button button;
	private Checkbox checkbox;
	
	public FactoryProducer(GUIFactory factory) {
		button = factory.createButton();
		checkbox = factory.createCheckbox();
	}
	
	public void paint() {
		button.paint();
		checkbox.paint();
	}

}
