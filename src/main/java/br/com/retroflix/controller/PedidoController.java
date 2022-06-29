package br.com.retroflix.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.retroflix.model.Pedido;
import br.com.retroflix.service.IPedidoService;

@RestController
@CrossOrigin("*")
public class PedidoController {
	@Autowired
	private IPedidoService iPedidoService;
	
	@GetMapping("/pedido")
	public ResponseEntity<List<Pedido>> recuperarTodosOsPedidos(){
		return ResponseEntity.ok(iPedidoService.recuperarTodosOsPedidos());
	}
	
	@GetMapping("/pedido/id/{id}")
	public ResponseEntity<Optional<Pedido>> recuperarPedidoPorId(Integer id){
		return ResponseEntity.ok((Optional<Pedido>)iPedidoService.recuperarPedidoPorId(id));
	}
}
