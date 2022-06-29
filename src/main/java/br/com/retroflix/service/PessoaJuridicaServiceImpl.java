package br.com.retroflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retroflix.dao.PessoaJuridicaDAO;
import br.com.retroflix.model.PessoaJuridica;

@Service
public class PessoaJuridicaServiceImpl implements IPessoaJuridicaService{
	
	@Autowired
	private PessoaJuridicaDAO pessoaJuridicaDao;
	
	@Override
	public List<PessoaJuridica> recuperarTodasAsPessoasJuridicas() {
		try {
			return (List<PessoaJuridica>)pessoaJuridicaDao.findAll();
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar todas as pessoas juridicas");
		}
	}

	@Override
	public PessoaJuridica recuperarPessoaJuridicaPorCnpj(String cnpj) {
		try {
			return pessoaJuridicaDao.recuperarPessoaJuridicaPorCnpj(cnpj);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar pessoa juridica por cnpj");
		}
	}

	@Override
	public PessoaJuridica cadastrarNovaPessoaJuridica(PessoaJuridica novaPessoaJuridica) {
		try {
			return pessoaJuridicaDao.save(novaPessoaJuridica);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao cadastrar pessoa juridica");
		}
	}

	@Override
	public PessoaJuridica atualizarPessoaJuridica(PessoaJuridica pessoaJuridica) {
		try {
			return pessoaJuridicaDao.save(pessoaJuridica);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao atualizar pessoa juridica");
		}
	}

}
