package br.com.retroflix.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "forma_pagamento_id")
	private Integer formaPagamentoId;
	
	@Column(name = "descricao", length = 255)
	private String descricao;
	
	//Relacionamento com a tabela Forma de Pagamento
	@OneToMany(mappedBy = "formaPagamento")
	@JsonIgnoreProperties(value = "formaPagamento")
	private List<Pedido> pedidos;
	
	public Integer getFormaPagamentoId() {
		return formaPagamentoId;
	}

	public void setFormaPagamentoId(Integer formaPagamentoId) {
		this.formaPagamentoId = formaPagamentoId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
