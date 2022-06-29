package br.com.retroflix.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.retroflix.model.FormaPagamento;

public interface FormaPagamentoDAO extends CrudRepository<FormaPagamento, Integer> {

}
