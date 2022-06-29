package br.com.retroflix.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.retroflix.model.Carrinho;

public interface CarrinhoDAO extends CrudRepository<Carrinho, Integer>{

}
