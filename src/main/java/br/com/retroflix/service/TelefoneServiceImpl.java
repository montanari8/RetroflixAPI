package br.com.retroflix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retroflix.dao.TelefoneDAO;
import br.com.retroflix.model.Telefone;

@Service
public class TelefoneServiceImpl implements ITelefoneService{
	
	@Autowired
	private TelefoneDAO telefoneDao;
	
	@Override
	public List<Telefone> recuperarTodosOsTelefones() {
		try{
			return (List<Telefone>)telefoneDao.findAll();
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar telefones");
		}
	}

	@Override
	public Optional<Telefone> recuperarTelefonePorId(Integer id) {
		try{
			return (Optional<Telefone>)telefoneDao.findById(id);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar telefone por id");
		}
	}

	@Override
	public Telefone inserirNovoTelefone(Telefone novoTelefone) {
		try{
			return telefoneDao.save(novoTelefone);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao inserir novo telefone");
		}
	}

	@Override
	public Telefone atualizarTelefone(Telefone telefone) {
		return telefoneDao.save(telefone);
	}

}
