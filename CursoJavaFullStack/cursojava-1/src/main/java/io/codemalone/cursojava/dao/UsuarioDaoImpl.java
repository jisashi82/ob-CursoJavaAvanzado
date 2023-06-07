package io.codemalone.cursojava.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;
import io.codemalone.cursojava.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Usuario> getUsuarios() {
		String query = "FROM Usuario";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public void eliminar(Long id) {
		Usuario usuario = entityManager.find(Usuario.class, id);
		entityManager.remove(usuario);

	}

	@Override
	public void registrar(Usuario usuario) {
		entityManager.persist(usuario);
	}

	@Override
	public boolean verificarCredenciales(Usuario usuario) {
		String query = "FROM Usuario WHERE email = :email";
		@SuppressWarnings("unchecked")
		List<Usuario> usuarioEncontrado = entityManager.createQuery(query).setParameter("email", usuario.getEmail())
				.getResultList();
		
		Argon2 argon2=Argon2Factory.create(Argon2Types.ARGON2id,16,32);
		try {
			return argon2.verify(usuarioEncontrado.get(0).getPassword(), usuario.getPassword().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		//return !usuarioEncontrado.isEmpty();
	}

	@Override
	public Usuario obtenerUsuarioxCredenciales(Usuario usuario) {
		String query = "FROM Usuario WHERE email = :email";
		@SuppressWarnings("unchecked")
		List<Usuario> usuarioEncontrado = entityManager.createQuery(query).setParameter("email", usuario.getEmail())
				.getResultList();
		
		
		Argon2 argon2=Argon2Factory.create(Argon2Types.ARGON2id,16,32);
		try {
			if (!usuarioEncontrado.isEmpty() && argon2.verify(usuarioEncontrado.get(0).getPassword(), usuario.getPassword().getBytes())) {
				return usuarioEncontrado.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return null;		
	}

}
