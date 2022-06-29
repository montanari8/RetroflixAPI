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

import br.com.retroflix.model.PessoaFisica;
import br.com.retroflix.service.IPessoaFisicaService;

@RestController
@CrossOrigin("*")
public class PessoaFisicaController {
	
	@Autowired
	private IPessoaFisicaService iPessoaFisicaService;
	
	@GetMapping("/pessoa")
	public ResponseEntity<List<PessoaFisica>> recuperarTodasAsPessoas(){
		return ResponseEntity.ok(iPessoaFisicaService.recuperarTodasAsPessoasFisicas());
	}
	
	@GetMapping("/pessoa/cpf/{cpf}")
	public ResponseEntity<PessoaFisica> recuperarPessoaFisicaPorCpf(@PathVariable String cpf) {
		return ResponseEntity.ok(iPessoaFisicaService.recuperarPessoaFisicaPorCpf(cpf));
	}
	
	@GetMapping("/pessoa/nome/{nome}")
	public ResponseEntity<PessoaFisica> recuperarPessoaFisicaPorNome(@PathVariable String nome){
		return ResponseEntity.ok(iPessoaFisicaService.recuperarPessoaFisicaPorNome(nome));
	}
	
	@PostMapping("/pessoa")
	public ResponseEntity<PessoaFisica> inserirNovaPessoaFisica(@RequestBody PessoaFisica novaPessoaFisica){
		return ResponseEntity.status(201).body(iPessoaFisicaService.cadastrarNovaPessoaFisica(novaPessoaFisica));
	}
	
	@PutMapping("/pessoa")
	public ResponseEntity<PessoaFisica> atualizarPessoaFisica(@RequestBody PessoaFisica pessoaFisica){
		return ResponseEntity.ok(iPessoaFisicaService.atualizarPessoaFisica(pessoaFisica));
	}
	
}
