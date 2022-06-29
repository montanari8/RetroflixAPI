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

import br.com.retroflix.model.PessoaJuridica;
import br.com.retroflix.service.IPessoaJuridicaService;

@RestController
@CrossOrigin("*")
public class PessoaJuridicaController {
	
	@Autowired
	private IPessoaJuridicaService iPessoaJuridicaService;
	
	@GetMapping("/pj")
	public ResponseEntity<List<PessoaJuridica>> recuperarTodasAsPessoasJuridicas(){
		return ResponseEntity.ok(iPessoaJuridicaService.recuperarTodasAsPessoasJuridicas());
	}
	
	@GetMapping("pj/{cnpj}")
	public ResponseEntity<PessoaJuridica> recuperarPessoaJuridicaPorCnpj(@PathVariable String cnpj){
		return ResponseEntity.ok(iPessoaJuridicaService.recuperarPessoaJuridicaPorCnpj(cnpj));
	}
	
	@PostMapping("/pj")
	public ResponseEntity<PessoaJuridica> cadastrarNovaPessoaJuridica(@RequestBody PessoaJuridica novaPessoaJuridica){
		return ResponseEntity.status(201).body(iPessoaJuridicaService.cadastrarNovaPessoaJuridica(novaPessoaJuridica));
	}
	
	@PutMapping("/pj")
	public ResponseEntity<PessoaJuridica> atualizarPessoaJuridica(@RequestBody PessoaJuridica pessoaJuridica){
		return ResponseEntity.ok(iPessoaJuridicaService.atualizarPessoaJuridica(pessoaJuridica));
	}
	
}
