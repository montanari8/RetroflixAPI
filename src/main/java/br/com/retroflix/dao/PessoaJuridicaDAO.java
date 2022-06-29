package br.com.retroflix.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.retroflix.model.PessoaJuridica;

public interface PessoaJuridicaDAO extends CrudRepository<PessoaJuridica, String> {
	
	@Query("SELECT pj FROM PessoaJuridica pj WHERE pj.cnpj LIKE :cnpj")
	public PessoaJuridica recuperarPessoaJuridicaPorCnpj(@Param("cnpj") String cnpj);

}
