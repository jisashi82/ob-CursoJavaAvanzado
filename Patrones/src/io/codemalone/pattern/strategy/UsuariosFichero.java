package io.codemalone.pattern.strategy;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuariosFichero implements Usuarios {
	private String pathFichero = "usuarios.txt";
	private PrintStream fichero;

	public UsuariosFichero() {
		try {
			fichero = new PrintStream(pathFichero);
		} catch (Exception e) {
			System.out.println("No se ha podido Abrir " + e.getMessage());
		}
	}

	@Override 
	public void crear(String nombre) {
		fichero.println(nombre);
	}

	@Override 
	public ArrayList<String> listar() {
		ArrayList<String> usuarios = new ArrayList<>();
		try {

			Scanner scanner = new Scanner(new File(pathFichero));

			while (scanner.hasNext()) {
				usuarios.add(scanner.next());
			}

		} catch (Exception e) {
			System.out.println("Error Leyendo");
		}

		return usuarios;

	}
}
