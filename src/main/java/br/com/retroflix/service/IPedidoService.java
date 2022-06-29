package br.com.retroflix.service;

import java.util.List;
import java.util.Optional;

import br.com.retroflix.model.Pedido;

public interface IPedidoService {
	public List<Pedido> recuperarTodosOsPedidos();
	public Optional<Pedido> recuperarPedidoPorId(Integer id);
}
