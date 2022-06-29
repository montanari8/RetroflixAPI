package br.com.retroflix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retroflix.dao.ProdutoDAO;
import br.com.retroflix.model.Produto;

@Service
public class ProdutoServiceImpl implements IProdutoService{
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@Override
	public List<Produto> recuperarProdutos() {
		try{
			return (List<Produto>)produtoDao.findAll();
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar produtos");
		}
	}

	@Override
	public Optional<Produto> recuperarProdutoPorId(Integer id) {
		try{
			return (Optional<Produto>)produtoDao.findById(id);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar produto por id");
		}
	}

}
