package br.com.retroflix.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retroflix.dao.PessoaFisicaDAO;
import br.com.retroflix.model.PessoaFisica;

@Service
public class PessoaFisicaServiceImpl implements IPessoaFisicaService {
	
	@Autowired
	private PessoaFisicaDAO pessoaFisicaDao;
	
	@Override
	public List<PessoaFisica> recuperarTodasAsPessoasFisicas() {
		try {
			return (List<PessoaFisica>)pessoaFisicaDao.findAll();
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar pessoas física");
		}
	}

	@Override
	public PessoaFisica recuperarPessoaFisicaPorCpf(String cpf) {
		try {
			return pessoaFisicaDao.recuperarPessoaFisicaPorCpf(cpf);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar pessoa por CPF");
		}
	}

	@Override
	public PessoaFisica recuperarPessoaFisicaPorNome(String nome) {
		try {
			return pessoaFisicaDao.recupearPessoaFisicaPorNome(nome);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar pessoa física por nome");
		}
	}

	@Override
	public PessoaFisica cadastrarNovaPessoaFisica(PessoaFisica novaPessoaFisica) {
		try {
			LocalDate agora = LocalDate.now();
			novaPessoaFisica.setCreateTime(agora);
			
			return pessoaFisicaDao.save(novaPessoaFisica);
			
		} catch(Exception e) {
			throw new RuntimeException("Erro ao cadastrar nova pessoa física");
		}
	}

	@Override
	public PessoaFisica atualizarPessoaFisica(PessoaFisica pessoaFisica) {
		try {
			return pessoaFisicaDao.save(pessoaFisica);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao atualizar cadastro pessoa física");
		}
	}

}
