package br.com.retroflix.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.retroflix.model.ProdutoEstoque;

public interface ProdutoEstoqueDAO extends CrudRepository<ProdutoEstoque, Integer> {

}
