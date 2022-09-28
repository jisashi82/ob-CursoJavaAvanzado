package io.codemalone.pattern.AbstractFactory;

//paso 4.-Create Factory classes extending AbstractFactory or implement Interface to generate object of concrete class based on given information.
public class WindowsFactory implements GUIFactory {

	@Override
	public Button createButton() {
		return new WindowsButton();
	}

	@Override
	public Checkbox createCheckbox() {
		return new WindowsCheckbox();
	}

}
