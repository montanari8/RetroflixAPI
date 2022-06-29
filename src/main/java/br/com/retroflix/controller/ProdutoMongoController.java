package br.com.retroflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.retroflix.model.ProdutoMongo;
import br.com.retroflix.service.IProdutoMongoService;

@RestController
@CrossOrigin("*")
public class ProdutoMongoController {
	
	@Autowired
	private IProdutoMongoService iProdutoMongoService;
		
	@GetMapping("/produtos")
	public ResponseEntity<List<ProdutoMongo>> obterTodos(){
		return ResponseEntity.ok((List<ProdutoMongo>)iProdutoMongoService.obterTodos());
	}
	
	@GetMapping("/produtos/id/{id}")
	public ResponseEntity<List<ProdutoMongo>> obterTodos(@PathVariable String id){
		return ResponseEntity.ok((List<ProdutoMongo>)iProdutoMongoService.obterFilmePorId(id));
	}
	
	@GetMapping("/produtos/{categoria}")
	public ResponseEntity<List<ProdutoMongo>> obterFilmesPorCategoria(@PathVariable String categoria){
		return ResponseEntity.ok((List<ProdutoMongo>)iProdutoMongoService.obterPorCategoria(categoria));
	}
	
	@PostMapping("/produtos")
	public ResponseEntity<ProdutoMongo> novoProdutoMongo(@RequestBody ProdutoMongo novoProdutoMongo){
		return ResponseEntity.status(201).body(iProdutoMongoService.cadastrarProdutoMongo(novoProdutoMongo));
	}
	
	@PutMapping("/produtos")
	public ResponseEntity<ProdutoMongo> atualizarProdutoMonto(@RequestBody ProdutoMongo produtoMongo){
		return ResponseEntity.ok(iProdutoMongoService.atualizarProdutoMongo(produtoMongo));
	}
	
	@DeleteMapping("/produtos")
	public ResponseEntity<String> deletarProdutoMongo(@RequestBody ProdutoMongo produtoMongo){
			iProdutoMongoService.deletarProdutoMongo(produtoMongo);
			return ResponseEntity.ok("Produto deletado com sucesso!");
	}
	
	@DeleteMapping("/produtos/{id}")
	public ResponseEntity<String> deletarProdutoMongoPorId(@PathVariable String id){
			iProdutoMongoService.deleterProdutoMongoPorId(id);
			return ResponseEntity.ok("Produto deletado com sucesso!");
	}
}
