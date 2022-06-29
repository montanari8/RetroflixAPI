package br.com.retroflix.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.com.retroflix.model.Usuario;
import br.com.retroflix.security.JWTToken;
import br.com.retroflix.security.JWTTokenUtil;
import br.com.retroflix.service.IUsuarioService;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	@GetMapping("/usuario")
	public ResponseEntity<List<Usuario>> recuperarTodosOsUsuarios(){
		return ResponseEntity.ok((List<Usuario>)iUsuarioService.recuperarTodosOsUsuarios());
	}
	
	/*
	 * @GetMapping("/usuario/teste") public ResponseEntity<List<Usuario>>
	 * recuperaTeste(@RequestHeader(value = "Authorization")String header){ header =
	 * header.replace("Bearer ", ""); String nivelAcesso =
	 * JWTTokenUtil.getNivelAcessoFromToken(header);
	 * System.out.println(nivelAcesso); return
	 * ResponseEntity.ok((List<Usuario>)iUsuarioService.recuperarTodosOsUsuarios());
	 * 
	 * }
	 */
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Optional<Usuario>> buscarUsuarioPorId(@PathVariable Integer id){
		return ResponseEntity.ok(iUsuarioService.recuperarUsuarioPorId(id));
	}
	
	@GetMapping("/usuario/nome/{username}")
	public ResponseEntity<Usuario> recuperarUsuarioPorUsername(@PathVariable String username){
		return ResponseEntity.ok(iUsuarioService.recuperarUsuarioPorUsername(username));
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> inserirNovoUsuario(@RequestBody Usuario novoUsuario){
		return ResponseEntity.status(201).body(iUsuarioService.inserirNovoUsuario(novoUsuario));
	}
	
	@PostMapping("/login")
	public ResponseEntity<JWTToken> fazerLogin(@RequestBody Usuario usuario){
		Usuario user = iUsuarioService.recuperarUsuario(usuario);
		
		if(user != null) {
			if(user.getSenha().equals(usuario.getSenha())) {
				
				JWTToken jwtToken = new JWTToken();
				
				jwtToken.setToken(JWTTokenUtil.generateToken(user));
				
				return ResponseEntity.ok(jwtToken);
			}
			return ResponseEntity.status(403).build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/usuario")
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario){
		return ResponseEntity.status(200).body(iUsuarioService.atualizarUsuario(usuario));
	}
}
