package br.com.retroflix.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "itens_carrinho")
public class ItensCarrinho {
	
	@Id
	@Column(name = "itens_carrinho_id")
	private Integer itensCarrinhoId;
	
	//Relacionamento com a tabela Carrinho
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carrinho_carrinho_id")
	@JsonIgnoreProperties("itensCarrinho")
	private Carrinho carrinho;
	
	public Integer getItensCarrinhoId() {
		return itensCarrinhoId;
	}

	public void setItensCarrinhoId(Integer itensCarrinhoId) {
		this.itensCarrinhoId = itensCarrinhoId;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
}
