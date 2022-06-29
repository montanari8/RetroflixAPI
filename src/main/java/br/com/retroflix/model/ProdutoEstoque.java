package br.com.retroflix.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produto_estoque")
public class ProdutoEstoque {
	
	@Id
	@Column(name = "id_produto")
	private String idProduto;
	
	@Column(name = "create_time")
	private LocalDate createTime;
	
	@Column(name = "quantidade_produto")
	private Integer quantidadeProduto;
	
	//Relacionamento com a tabela itens_pedido
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto_id")
	@JsonIgnoreProperties(value = "produtosEstoque")
	private ItensPedido itensPedido;
	
	//Relacionamento com a tabela produto
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produtos_id_produtos")
	private Produto produto;
	
	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public LocalDate getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDate createTime) {
		this.createTime = createTime;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public ItensPedido getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(ItensPedido itensPedido) {
		this.itensPedido = itensPedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
