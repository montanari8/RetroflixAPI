package br.com.retroflix.service;

import java.util.Optional;

import br.com.retroflix.model.Carrinho;

public interface ICarrinhoService {
	public Optional<Carrinho> recuperarCarrinhoPorId(Integer id);
}
