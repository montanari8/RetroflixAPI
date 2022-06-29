package br.com.retroflix.service;

import java.util.List;

import br.com.retroflix.model.PessoaJuridica;

public interface IPessoaJuridicaService {
	public List<PessoaJuridica> recuperarTodasAsPessoasJuridicas();
	public PessoaJuridica recuperarPessoaJuridicaPorCnpj(String cnpj);
	public PessoaJuridica cadastrarNovaPessoaJuridica(PessoaJuridica novaPessoaJuridica);
	public PessoaJuridica atualizarPessoaJuridica(PessoaJuridica pessoaJuridica);
}
