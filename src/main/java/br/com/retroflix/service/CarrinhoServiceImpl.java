package br.com.retroflix.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retroflix.dao.CarrinhoDAO;
import br.com.retroflix.model.Carrinho;

@Service
public class CarrinhoServiceImpl implements ICarrinhoService{
	
	@Autowired
	private CarrinhoDAO carrinhoDao;
	
	@Override
	public Optional<Carrinho> recuperarCarrinhoPorId(Integer id) {
		try{
			return (Optional<Carrinho>)carrinhoDao.findById(id);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar carrinho");
		}
	}

}
