package br.com.retroflix.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.retroflix.model.Pedido;

public interface PedidoDAO extends CrudRepository<Pedido, Integer>{

}
