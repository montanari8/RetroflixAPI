package br.com.retroflix.service;

import java.util.Optional;

import br.com.retroflix.model.ItensCarrinho;

public interface IItensCarrinhoService {
	public Optional<ItensCarrinho> recuperarItensCarrinhoPorId(Integer id);
}
