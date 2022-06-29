package br.com.retroflix.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.retroflix.model.Telefone;

public interface TelefoneDAO extends CrudRepository<Telefone, Integer>{

}
