package io.codemalone.cursojava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.codemalone.cursojava.dao.UsuarioDao;
import io.codemalone.cursojava.models.Usuario;
import io.codemalone.cursojava.utils.JWTUtil;

@RestController
@RequestMapping(value = "/api")
public class AuthController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping("login")
 	public String login(@RequestBody Usuario usuario) {
		
		Usuario usuarioLogueado= usuarioDao.obtenerUsuarioxCredenciales(usuario);
		
		if(usuarioLogueado != null) {
			String tokenJwt =jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
			return tokenJwt;
		} else {
			return "FAIL";			
		}
				
		/*if(usuarioDao.verificarCredenciales(usuario)) {
			return "OK";
		} else {
			return "FAIL";
		}*/
		
	}

}
