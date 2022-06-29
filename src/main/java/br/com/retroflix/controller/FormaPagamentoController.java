package br.com.retroflix.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.retroflix.model.FormaPagamento;
import br.com.retroflix.service.IFormaPagamentoService;

@RestController
@CrossOrigin("*")
public class FormaPagamentoController {
	
	@Autowired
	private IFormaPagamentoService iFormaPagamentoService;
	
	@GetMapping("/pagamento/{id}")
	public ResponseEntity<Optional<FormaPagamento>> recuperarFormaPagamentoId(@PathVariable Integer id){
		return ResponseEntity.ok((Optional<FormaPagamento>)iFormaPagamentoService.recuperarFormaDePagamentoPorId(id));
	}
	
}
