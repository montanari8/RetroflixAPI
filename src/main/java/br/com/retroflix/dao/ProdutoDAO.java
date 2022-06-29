package br.com.retroflix.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.retroflix.model.Produto;

public interface ProdutoDAO extends CrudRepository<Produto, Integer> {

}
