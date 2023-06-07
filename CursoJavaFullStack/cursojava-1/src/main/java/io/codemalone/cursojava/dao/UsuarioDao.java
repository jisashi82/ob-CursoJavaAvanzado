package io.codemalone.cursojava.dao;

import java.util.List;

import io.codemalone.cursojava.models.Usuario;

public interface UsuarioDao {
	List<Usuario> getUsuarios();

	void eliminar(Long id);

	void registrar(Usuario usuario);

	boolean verificarCredenciales(Usuario usuario);
	
	Usuario obtenerUsuarioxCredenciales(Usuario usuario);
}
