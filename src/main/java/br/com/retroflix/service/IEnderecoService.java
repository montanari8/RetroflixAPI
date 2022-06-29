package br.com.retroflix.service;

import java.util.List;

import br.com.retroflix.model.Endereco;

public interface IEnderecoService {
	public List<Endereco> recuperarTodosOsEnderecos();
	public Endereco recuperarEnderecoPorCep(String cep);
	public Endereco inserirNovoEndereco(Endereco novoEndereco);
	public Endereco atualizarEndereco(Endereco endereco);
}
