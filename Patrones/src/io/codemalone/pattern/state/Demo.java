package io.codemalone.pattern.state;
/*
 * State es un patrón de diseño de comportamiento que permite a un objeto cambiar de comportamiento cuando cambia su estado interno.
 * El patrón extrae comportamientos relacionados con el estado, los coloca dentro de clases de estado separadas
 * y fuerza al objeto original a delegar el trabajo de una instancia de esas clases, en lugar de actuar por su cuenta.
 */
public class Demo {
	
	public static void main(String[] args) {
		Player player = new Player();
		UI ui = new UI(player);
		ui.init();
	}

}
