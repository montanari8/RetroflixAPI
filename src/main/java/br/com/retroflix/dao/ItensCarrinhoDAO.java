package br.com.retroflix.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.retroflix.model.ItensCarrinho;

public interface ItensCarrinhoDAO extends CrudRepository<ItensCarrinho, Integer> {

}
