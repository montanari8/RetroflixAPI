package br.com.retroflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.retroflix.dao.ProdutoMongoDAO;
import br.com.retroflix.model.ProdutoMongo;

@Service
public class ProdutoMongoServiceImpl implements IProdutoMongoService{
	
	@Autowired
	private ProdutoMongoDAO produtoMongoDao;
	
	@Override
	public List<ProdutoMongo> obterTodos() {
		try {
			return (List<ProdutoMongo>)produtoMongoDao.findAll();
		} catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar produtos do Atlas." + e);
		}
	}
	
	@Override
	public ProdutoMongo cadastrarProdutoMongo(ProdutoMongo novoProdutoMongo) {
		try{
			return produtoMongoDao.save(novoProdutoMongo);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao cadastrar um novo produto no Atlas.");
		}
	}
	
	@Override
	public ProdutoMongo atualizarProdutoMongo(ProdutoMongo produtoMongo) {
		try{
			return produtoMongoDao.save(produtoMongo);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao atualizar produto no Atlas.");
		}
	}


	@Override
	public  void deletarProdutoMongo(ProdutoMongo produtoMongo) {
		try{
			produtoMongoDao.delete(produtoMongo);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao deletar produto no Atlas.");
		}
	}

	@Override
	public void deleterProdutoMongoPorId(String id) {
		try{
			produtoMongoDao.deleteById(id);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao deletar produto no Atlas.");
		}
		
	}

	@Override
	public List<ProdutoMongo> obterPorCategoria(String categoria) {
		try{
			return produtoMongoDao.obterFilmePorCategoria(categoria);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao encontrar produto por categoria.");
		}
	}

	@Override
	public List<ProdutoMongo> obterFilmePorId(String id) {
		try{
			return produtoMongoDao.obterFilmePorId(id);
		} catch(Exception e) {
			throw new RuntimeException("Erro ao encontrar produto por categoria.");
		}
	}
}
