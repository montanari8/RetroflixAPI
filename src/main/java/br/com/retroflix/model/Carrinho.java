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
@Table(name = "carrinho")
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carrinho_id")
	private Integer carrinhoId;
	
	@Column(name = "create_time")
	private LocalDate createTime;
	
	@Column(name = "data_validade")
	private LocalDate dataValidade;
	
	//Relacionamento com a tabela usuário
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id_usuario")
	@JsonIgnoreProperties(value = "carrinhos")
	private Usuario usuario;
	
	//Relacionamento com a tabela itens_carrinho;
	@OneToMany(mappedBy = "carrinho")
	@JsonIgnoreProperties(value = "carrinho")
	private List<ItensCarrinho> itensCarrinho;
	
	public Integer getCarrinhoId() {
		return carrinhoId;
	}

	public void setCarrinhoId(Integer carrinhoId) {
		this.carrinhoId = carrinhoId;
	}

	public LocalDate getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDate createTime) {
		this.createTime = createTime;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ItensCarrinho> getItensCarrinho() {
		return itensCarrinho;
	}

	public void setItensCarrinho(List<ItensCarrinho> itensCarrinho) {
		this.itensCarrinho = itensCarrinho;
	}	
}
