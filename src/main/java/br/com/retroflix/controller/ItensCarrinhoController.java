package br.com.retroflix.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.retroflix.model.ItensCarrinho;
import br.com.retroflix.service.IItensCarrinhoService;

@RestController
@CrossOrigin("*")
public class ItensCarrinhoController {
	@Autowired
	private IItensCarrinhoService iItensCarrinhoService;
	
	@GetMapping("/carrinho/itens/{id}")
	public ResponseEntity<Optional<ItensCarrinho>> recuperarItensCarrinhoPorId(@PathVariable Integer id){
		return ResponseEntity.ok((Optional<ItensCarrinho>)iItensCarrinhoService.recuperarItensCarrinhoPorId(id));
		
	}
}
