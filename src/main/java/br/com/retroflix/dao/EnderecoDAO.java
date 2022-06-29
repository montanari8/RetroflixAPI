package br.com.retroflix.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.retroflix.model.Endereco;

public interface EnderecoDAO extends CrudRepository<Endereco, Integer> {
	@Query("SELECT e FROM Endereco e WHERE e.cep LIKE :cep")
	public Endereco recuperarEnderecoPorCep(@Param("cep") String cep);
}
