package br.com.retroflix.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.retroflix.model.PessoaFisica;

public interface PessoaFisicaDAO extends CrudRepository<PessoaFisica, String>{
		
	@Query("SELECT pf FROM PessoaFisica pf WHERE pf.cpf LIKE :cpf")
	public PessoaFisica recuperarPessoaFisicaPorCpf(String cpf);
	
	@Query("SELECT pf FROM PessoaFisica pf WHERE pf.nomeCompleto LIKE CONCAT('%', :nome, '%')")
	public PessoaFisica recupearPessoaFisicaPorNome(@Param("nome") String nome);
}
