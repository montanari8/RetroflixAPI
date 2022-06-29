package br.com.retroflix.service;

import java.util.List;

import br.com.retroflix.model.PessoaFisica;

public interface IPessoaFisicaService {
	public List<PessoaFisica> recuperarTodasAsPessoasFisicas();
	public PessoaFisica recuperarPessoaFisicaPorCpf(String cpf);
	public PessoaFisica recuperarPessoaFisicaPorNome(String nome);
	public PessoaFisica cadastrarNovaPessoaFisica(PessoaFisica novaPessoaFisica);
	public PessoaFisica atualizarPessoaFisica(PessoaFisica pessoaFisica);
}
