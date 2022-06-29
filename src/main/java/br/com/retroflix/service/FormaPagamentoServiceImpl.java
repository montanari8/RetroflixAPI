package br.com.retroflix.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retroflix.dao.FormaPagamentoDAO;
import br.com.retroflix.model.FormaPagamento;

@Service
public class FormaPagamentoServiceImpl implements IFormaPagamentoService {
	
	@Autowired
	private FormaPagamentoDAO formaPagamentoDao;
	
	@Override
	public Optional<FormaPagamento> recuperarFormaDePagamentoPorId(Integer id) {
		try{
			return (Optional<FormaPagamento>)formaPagamentoDao.findById(id) ;
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar forma de pagamento por id");
		}
	}

}
