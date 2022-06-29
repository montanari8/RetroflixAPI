package br.com.retroflix.service;

import java.util.List;
import java.util.Optional;

import br.com.retroflix.model.Telefone;

public interface ITelefoneService {
	public List<Telefone> recuperarTodosOsTelefones();
	public Optional<Telefone> recuperarTelefonePorId(Integer id);
	public Telefone inserirNovoTelefone(Telefone novoTelefone);
	public Telefone atualizarTelefone(Telefone telefone);
}
