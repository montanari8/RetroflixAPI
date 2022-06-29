package br.com.retroflix.service;

import java.util.Optional;

import br.com.retroflix.model.ItensPedido;

public interface IItensPedidoService {
	public Optional<ItensPedido> recuperarItensPedidoPorId(Integer id);
}
