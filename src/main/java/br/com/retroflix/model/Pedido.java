package br.com.retroflix.model;

import java.time.LocalDate;
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
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_id")
	private Integer pedidoId;
	
	@Column(name = "data_compra")
	private LocalDate dataCompra;
	
	@Column(name = "observacoes")
	private String observacoes;
	
	@Column(name = "frete")
	private Double frete;
	
	@Column(name = "valor_produtos")
	private Double valorProdutos;
	
	@Column(name = "valor_venda")
	private Double valorVenda;
	
	//Relacionamento com a tabela usuário
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id_usuario")
	@JsonIgnoreProperties(value = "pedidos")
	private Usuario usuario;
	
	//Relacionamento com a tabela forma de pagamento
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_forma_pagamento")
	@JsonIgnoreProperties(value = "pedidos")
	private FormaPagamento formaPagamento;
	
	//Relacionamento com a tabela itens-pedido
	@OneToMany(mappedBy = "pedido")
	@JsonIgnoreProperties(value = "pedido")
	private List<ItensPedido> itensPedido;
	
	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Double getFrete() {
		return frete;
	}

	public void setFrete(Double frete) {
		this.frete = frete;
	}

	public Double getValorProdutos() {
		return valorProdutos;
	}

	public void setValorProdutos(Double valorProdutos) {
		this.valorProdutos = valorProdutos;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public List<ItensPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItensPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}
}
