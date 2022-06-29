package br.com.retroflix.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retroflix.dao.ItensPedidoDAO;
import br.com.retroflix.model.ItensPedido;

@Service
public class ItensPedidoServiceImpl implements IItensPedidoService {
	
	@Autowired
	private ItensPedidoDAO itensPedidoDao;
	
	@Override
	public Optional<ItensPedido> recuperarItensPedidoPorId(Integer id) {
		try{
			return (Optional<ItensPedido>)itensPedidoDao.findById(id);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar itens do pedido por id");
		}
	}

}
