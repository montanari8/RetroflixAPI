package br.com.retroflix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retroflix.dao.PedidoDAO;
import br.com.retroflix.model.Pedido;

@Service
public class PedidoServiceImpl implements IPedidoService {
	
	@Autowired
	private PedidoDAO pedidoDao;
	
	@Override
	public List<Pedido> recuperarTodosOsPedidos() {
		try{
			return (List<Pedido>)pedidoDao.findAll();
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar todos os pedidos");
		}
	}

	@Override
	public Optional<Pedido> recuperarPedidoPorId(Integer id) {
		try{
			return (Optional<Pedido>)pedidoDao.findById(id);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar pedido por id");
		}
	}

}
