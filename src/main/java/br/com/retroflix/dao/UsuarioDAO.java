package br.com.retroflix.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.retroflix.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	@Query("SELECT u FROM Usuario u WHERE u.username LIKE :username")
	public Usuario recuperarUsuarioPorUsername(@Param("username") String usernmame);
	
	@Query("SELECT u FROM Usuario u WHERE u.username LIKE :username OR u.email LIKE :email")
	public Usuario recuperarUsuarioPorUsernameOuEmail(@Param("username") String username, @Param("email") String email);
	
}
