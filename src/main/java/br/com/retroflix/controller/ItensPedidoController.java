package br.com.retroflix.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.retroflix.model.ItensPedido;
import br.com.retroflix.service.IItensPedidoService;

@RestController
@CrossOrigin("*")
public class ItensPedidoController {
	@Autowired
	private IItensPedidoService iItensPedidoService;
	
	@GetMapping("/pedido/itens/{id}")
	public ResponseEntity<Optional<ItensPedido>> recuperarItensPedidoPorId(@PathVariable Integer id){
		return ResponseEntity.ok((Optional<ItensPedido>)iItensPedidoService.recuperarItensPedidoPorId(id));
		
	}
}
