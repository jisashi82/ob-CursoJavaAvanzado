package io.codemalone.pattern.singleton;

/*
 * Static block initialization implementation is similar to eager initialization, 
 * except that instance of class is created in the static block that provides option for exception handling.*/

public class SingletonStaticBlock {
	//paso1.- crea 1 propiedad del mismo tipo de la clase
	private static SingletonStaticBlock instance;

	//paso 2.- cambia a private el constructor
	private SingletonStaticBlock() {
		// TODO Auto-generated constructor stub
	}

	//paso 3.- declara un bloque static, utiliza try/catch para crear la instancia singleton
	static {
		try {
			instance = new SingletonStaticBlock();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating Singleton instance");
		}
	}

	//paso 4.- crea el metodo getInstance para devolver la instancia
	public static SingletonStaticBlock getInstance() {
		return instance;
	}

}
