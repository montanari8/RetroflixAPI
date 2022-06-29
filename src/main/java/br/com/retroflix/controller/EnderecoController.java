package br.com.retroflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.retroflix.model.Endereco;
import br.com.retroflix.service.IEnderecoService;

@RestController
@CrossOrigin("*")
public class EnderecoController {
	
	@Autowired
	private IEnderecoService iEnderecoService;
	
	@GetMapping("/endereco")
	public ResponseEntity<List<Endereco>> recuperarTodosOsEnderecos(){
		return ResponseEntity.ok(iEnderecoService.recuperarTodosOsEnderecos());
	}
	
	@GetMapping("/endereco/cep/{cep}")
	public ResponseEntity<Endereco> recuperarEnderecoPorCep(@PathVariable String cep){
		return ResponseEntity.ok(iEnderecoService.recuperarEnderecoPorCep(cep));
	}
	
	@PostMapping("/endereco")
	public ResponseEntity<Endereco> inserirNovoEndereco(@RequestBody Endereco novoEndereco){
		return ResponseEntity.status(201).body(iEnderecoService.inserirNovoEndereco(novoEndereco));
	}
	
	@PutMapping("/endereco")
	public ResponseEntity<Endereco> atualizarEndereco(@RequestBody Endereco endereco){
		return ResponseEntity.ok(iEnderecoService.atualizarEndereco(endereco));
	}
	
}
