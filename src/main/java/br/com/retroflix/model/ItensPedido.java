package br.com.retroflix.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "itens_pedido")
public class ItensPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_produto_id")
	private Integer pedidoProdutoId;
	
	@Column(name = "quantidade_produto")
	private Integer quantidadeProduto;
	
	@Column(name = "valor_unitario")
	private Double valorUnitario;
	
	@Column(name = "valor_total")
	private Double valorTotal;
	
	//Relacionamento com a tabela pedido
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pedido")
	@JsonIgnoreProperties(value = "itensPedido")
	private Pedido pedido;
	
	//Relacionamento com a tabela produto_estoque
	@OneToMany(mappedBy = "itensPedido")
	@JsonIgnoreProperties(value = "itensPedido")
	private List<ProdutoEstoque> produtosEstoque;
	
	public Integer getPedidoProdutoId() {
		return pedidoProdutoId;
	}

	public void setPedidoProdutoId(Integer pedidoProdutoId) {
		this.pedidoProdutoId = pedidoProdutoId;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<ProdutoEstoque> getProdutosEstoque() {
		return produtosEstoque;
	}

	public void setProdutosEstoque(List<ProdutoEstoque> produtosEstoque) {
		this.produtosEstoque = produtosEstoque;
	}
}
