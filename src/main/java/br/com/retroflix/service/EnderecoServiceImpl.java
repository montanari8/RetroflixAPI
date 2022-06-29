package br.com.retroflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retroflix.dao.EnderecoDAO;
import br.com.retroflix.model.Endereco;

@Service
public class EnderecoServiceImpl implements IEnderecoService{
	
	@Autowired
	private EnderecoDAO enderecoDao;
	
	@Override
	public List<Endereco> recuperarTodosOsEnderecos() {
		try {
			return (List<Endereco>)enderecoDao.findAll();
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar endereços");
		}
	}

	@Override
	public Endereco recuperarEnderecoPorCep(String cep) {
		try{
			return enderecoDao.recuperarEnderecoPorCep(cep);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar endereço pelo cep");
		}
	}

	@Override
	public Endereco inserirNovoEndereco(Endereco novoEndereco) {
		try{
			return enderecoDao.save(novoEndereco);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao inserir novo endereço");
		}
	}

	@Override
	public Endereco atualizarEndereco(Endereco endereco) {
		try{
			return enderecoDao.save(endereco);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao atualizar endereco");
		}
	}
}
