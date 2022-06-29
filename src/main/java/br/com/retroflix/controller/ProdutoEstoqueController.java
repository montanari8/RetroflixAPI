package br.com.retroflix.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.retroflix.model.ProdutoEstoque;
import br.com.retroflix.service.IProdutoEstoqueService;

@RestController
@CrossOrigin("*")
public class ProdutoEstoqueController {
	
	@Autowired
	private IProdutoEstoqueService iProdutoEstoqueService;
	
	@GetMapping("/estoque")
	public ResponseEntity<List<ProdutoEstoque>> recuperarTodosOsProdutosNoEstoque(){
		return ResponseEntity.ok((List<ProdutoEstoque>)iProdutoEstoqueService.recuperarTodosOsProdutosNoEstoque());
	}
	
	@GetMapping("/estoque/id/{i}")
	public ResponseEntity<Optional<ProdutoEstoque>> recuperarProdutoNoEstoquePorId(Integer id){
		return ResponseEntity.ok((Optional<ProdutoEstoque>)iProdutoEstoqueService.recuperarProdutoNoEstoquePorId(id));
	}
}
