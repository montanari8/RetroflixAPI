package br.com.retroflix.service;

import java.util.List;
import java.util.Optional;

import br.com.retroflix.model.ProdutoEstoque;

public interface IProdutoEstoqueService {
	
	public List<ProdutoEstoque> recuperarTodosOsProdutosNoEstoque();
	public Optional<ProdutoEstoque> recuperarProdutoNoEstoquePorId(Integer id);
	
}
