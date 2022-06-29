package br.com.retroflix.service;

import java.util.List;

import br.com.retroflix.model.ProdutoMongo;

public interface IProdutoMongoService {
	public List<ProdutoMongo> obterTodos();

	public List<ProdutoMongo> obterFilmePorId(String id);

	public List<ProdutoMongo> obterPorCategoria(String categoria);

	public ProdutoMongo cadastrarProdutoMongo(ProdutoMongo novoProdutoMongo);

	public ProdutoMongo atualizarProdutoMongo(ProdutoMongo produtoMongo);

	public void deletarProdutoMongo(ProdutoMongo produtoMongo);

	public void deleterProdutoMongoPorId(String id);
}
