package br.com.retroflix.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retroflix.dao.ItensCarrinhoDAO;
import br.com.retroflix.model.ItensCarrinho;

@Service
public class ItensCarrinhoServiceImpl implements IItensCarrinhoService{
	
	@Autowired
	private ItensCarrinhoDAO itensCarrinhoDao;
	
	@Override
	public Optional<ItensCarrinho> recuperarItensCarrinhoPorId(Integer id) {
		try{
			return (Optional<ItensCarrinho>)itensCarrinhoDao.findById(id);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar itens do carrinho pelo id");
		}
	}

}
