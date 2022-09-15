package io.codemalone.pattern.singleton;

/*
 * Singleton ingenuo (thread safe) este Singleton es Lazy
 * */

public class Singleton {
	// paso 1.- crear una propiedad del tipo de la misma clase
	private static Singleton instance;
	public String value;

	// 2.-paso 2.- esconder el constructor mediante private
	private Singleton(String value) {
		this.value = value;
	}

	// paso 3.- declara un metodo static que valide si existe la instancia o la crea
	// y la devuelve
	public static synchronized Singleton getInstance(String value) {
		if (instance == null) {
			instance = new Singleton(value);
		}
		return instance;

	}

}
