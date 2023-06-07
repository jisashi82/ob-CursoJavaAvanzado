package io.codemalone.cursojava.controllers;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import io.codemalone.cursojava.dao.UsuarioDao;
import io.codemalone.cursojava.models.Usuario;
import io.codemalone.cursojava.utils.JWTUtil;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private JWTUtil jwtUtil;
	
	@GetMapping("prueba")
	public List<String> prueba() {
		return List.of("Manzana", "Banana", "Kiwi");
	}

	@GetMapping("usuario")
	public Usuario getUsuario() {
		return new Usuario(1L, "Abel", "Ramos", "abelRamos@javalover.com", "9621349897", "Javalover");
	}
	
	@GetMapping("usuarios")
	public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token) {
				
		if(!validarToken(token)) {
			return null;
		}
				
		return usuarioDao.getUsuarios();
	}

	@DeleteMapping("usuarios/{id}")
	public void eliminar(@PathVariable Long id, @RequestHeader(value = "Authorization") String token) {
		
		if(!validarToken(token)) {
			return ;
		}
		usuarioDao.eliminar(id);
	}
	
	@PostMapping("usuarios")
	public void registrarUsuario(@RequestBody Usuario usuario) {
		
		Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id,16,32);
		String hash=argon2.hash(1, 1024, 1, usuario.getPassword().getBytes(StandardCharsets.UTF_8));
		usuario.setPassword(hash);
		usuarioDao.registrar(usuario);
	}

	@GetMapping("usuario/{id}")
	public Usuario findUsuario(@PathVariable Long id) {
		Usuario usuario = new Usuario();
		usuario.setId(2L);
		usuario.setNombre("Jisashi");
		usuario.setApellido("Nakamura");
		usuario.setEmail("jisashi@javalover.com");
		usuario.setTelefono("9621324240");
		usuario.setPassword("springkey");
		return usuario;
	}
	
	
	public boolean validarToken(String token) {
		String usuarioID=jwtUtil.getKey(token);
		return usuarioID != null ;
	}
}