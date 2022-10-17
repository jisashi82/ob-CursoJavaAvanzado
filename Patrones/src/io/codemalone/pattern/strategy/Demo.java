package io.codemalone.pattern.strategy;

import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		int tipo=1;	
		Usuarios usuarios;
		
		if (tipo==0) {
			usuarios = new UsuariosFichero();
		}else {
			usuarios= new UsuariosMemoria();
		}
		
		crear(usuarios,"Abel");
		crear(usuarios,"Jisashi");
		crear(usuarios,"Karl");
		
		listar(usuarios).stream().forEach(System.out::println);

	}
	
	//pROCESO CLAVE CREAR ENVOLTORIOS PARA LLAMAR A LOS METODOS DE LA INTERFACE
	public static void crear(Usuarios usuarios, String nombre) {
		usuarios.crear(nombre);
	}
	
	public static ArrayList<String> listar(Usuarios usuarios){
		return usuarios.listar();
	}

}
