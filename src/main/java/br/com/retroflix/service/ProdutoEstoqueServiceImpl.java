package br.com.retroflix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retroflix.dao.ProdutoEstoqueDAO;
import br.com.retroflix.model.ProdutoEstoque;

@Service
public class ProdutoEstoqueServiceImpl implements IProdutoEstoqueService {
	
	@Autowired
	private ProdutoEstoqueDAO produtoEstoqueDao;
	
	@Override
	public List<ProdutoEstoque> recuperarTodosOsProdutosNoEstoque() {
		try{
			return (List<ProdutoEstoque>)produtoEstoqueDao.findAll();
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar todos os produtos no estoque");
		}
	}

	@Override
	public Optional<ProdutoEstoque> recuperarProdutoNoEstoquePorId(Integer id) {
		try{
			return (Optional<ProdutoEstoque>)produtoEstoqueDao.findById(id);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar produto no estoque por id");
		}
	}
	
}
