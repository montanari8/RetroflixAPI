package br.com.retroflix.service;

import java.util.List;
import java.util.Optional;

import br.com.retroflix.model.Produto;

public interface IProdutoService {
	public List<Produto> recuperarProdutos();
	public Optional<Produto> recuperarProdutoPorId(Integer id);
}
