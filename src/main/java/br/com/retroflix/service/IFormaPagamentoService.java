package br.com.retroflix.service;

import java.util.Optional;

import br.com.retroflix.model.FormaPagamento;

public interface IFormaPagamentoService {
	public Optional<FormaPagamento> recuperarFormaDePagamentoPorId(Integer id);
}
