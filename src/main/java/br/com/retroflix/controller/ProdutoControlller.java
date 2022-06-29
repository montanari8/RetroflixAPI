package br.com.retroflix.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.retroflix.model.Produto;
import br.com.retroflix.service.IProdutoService;

@RestController
@CrossOrigin("*")
public class ProdutoControlller {
	
	@Autowired
	private IProdutoService iProdutoService;
	
	@GetMapping("/produto")
	public ResponseEntity<List<Produto>> recuperarProdutos(){
		return ResponseEntity.ok((List<Produto>)iProdutoService.recuperarProdutos());
	}
	
	@GetMapping("/produto/id/{id}")
	public ResponseEntity<Optional<Produto>> recuperarProdutoPorId(@PathVariable Integer id){
		return ResponseEntity.ok((Optional<Produto>)iProdutoService.recuperarProdutoPorId(id));
	}
}
