package br.com.retroflix.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.retroflix.dao.UsuarioDAO;
import br.com.retroflix.model.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Override
	public List<Usuario> recuperarTodosOsUsuarios() {
		try {
			
			return (List<Usuario>)usuarioDao.findAll();
			
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar usuários");
		}
	}

	@Override
	public Optional<Usuario> recuperarUsuarioPorId(Integer id) {
		try {
			return usuarioDao.findById(id);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar usuário por ID");
		}
	}
	
	@Override
	public Usuario recuperarUsuarioPorUsername(String username) {
		try{
			return (Usuario)usuarioDao.recuperarUsuarioPorUsername(username);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar usuário por username");
		}
	}

	@Override
	public Usuario inserirNovoUsuario(Usuario novoUsuario) {
		try {
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			LocalDate agora = LocalDate.now();
			
			String novaSenha = encoder.encode(novoUsuario.getSenha());
			novoUsuario.setSenha(novaSenha.trim());
			novoUsuario.setCreateTime(agora);
			return usuarioDao.save(novoUsuario);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao criar novo usuário");
		}
	}

	@Override
	public Usuario atualizarUsuario(Usuario usuario) {
		try {
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String novaSenha = encoder.encode(usuario.getSenha());
			usuario.setSenha(novaSenha);
			return usuarioDao.save(usuario);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao atualizar informações do usuário");
		}
	}

	@Override
	public Usuario recuperarUsuario(Usuario usuario) {
		try{
			return (Usuario)usuarioDao.recuperarUsuarioPorUsernameOuEmail(usuario.getUsername(), usuario.getEmail());
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar usuário por username");
		}
	}
}
