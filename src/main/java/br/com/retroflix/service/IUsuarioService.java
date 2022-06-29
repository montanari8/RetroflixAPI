package br.com.retroflix.service;

import java.util.List;
import java.util.Optional;

import br.com.retroflix.model.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> recuperarTodosOsUsuarios();
	public Optional<Usuario> recuperarUsuarioPorId(Integer id);
	public Usuario recuperarUsuario(Usuario usuario);
	public Usuario recuperarUsuarioPorUsername(String username);
	public Usuario inserirNovoUsuario(Usuario novoUsuario);
	public Usuario atualizarUsuario(Usuario usuario);
	
}
