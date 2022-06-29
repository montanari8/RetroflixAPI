package br.com.retroflix.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.retroflix.model.Telefone;
import br.com.retroflix.service.ITelefoneService;

@RestController
@CrossOrigin("*")
public class TelefoneController {

	@Autowired
	private ITelefoneService iTelefoneService;
	
	@GetMapping("/telefone")
	public ResponseEntity<List<Telefone>> recuperarTodosOsTelefones(){
		return ResponseEntity.ok((List<Telefone>)iTelefoneService.recuperarTodosOsTelefones());
	}
	
	@GetMapping("/telefone/id/{id}")
	public ResponseEntity<Optional<Telefone>> recuperarTelefonePorId(Integer id){
		return ResponseEntity.ok((Optional<Telefone>)iTelefoneService.recuperarTelefonePorId(id));
	}
	
	@PostMapping("/telefone")
	public ResponseEntity<Telefone> inserirNovoTelefone(@RequestBody Telefone novoTelefone){
		return ResponseEntity.status(201).body(iTelefoneService.inserirNovoTelefone(novoTelefone));
	}
	
	@PutMapping("/telefone")
	public ResponseEntity<Telefone> atualizarTelefone(@RequestBody Telefone telefone){
		return ResponseEntity.ok(iTelefoneService.atualizarTelefone(telefone));
	}
	
}
