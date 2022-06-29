package br.com.retroflix.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.retroflix.model.ProdutoMongo;

public interface ProdutoMongoDAO extends MongoRepository<ProdutoMongo, String> {
	
	@Query("{'categoria': ?0 }")
	public List<ProdutoMongo> obterFilmePorCategoria(String categoria);
	
	@Query("{'_id': ?0}")
	public List<ProdutoMongo> obterFilmePorId(String id);
	
}
