package br.com.retroflix.model;

import java.time.LocalDate;
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
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", nullable = false)
	private Integer idUsuario;
	
	@Column(name = "username", nullable = false, length = 32)
	private String username;
	
	@Column(name = "email", nullable = false, length = 255)
	private String email;
	
	@Column(name = "senha", nullable = false, length = 255)
	private String senha;
	
	@Column(name = "create_time")
	private LocalDate createTime;
	
	@Column(name = "nivel_acesso", length = 1)
	private String nivelAcesso;
	
	//Relacionamento com a tabela endereço
	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties(value = "usuario")
	private List<Endereco> enderecos;
	
	//Relacionamento com a tabela telefone
	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties(value = "usuario")
	private List<Telefone> telefones;
	
	//Relacionamento com a tabela carrinho
	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties(value = "usuario")
	private List<Carrinho> carrinhos;
	
	//Relacionamento com a tabela pedido
	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties(value = "usuario")
	private List<Pedido> pedidos;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDate createTime) {
		this.createTime = createTime;
	}

	public String getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Carrinho> getCarrinhos() {
		return carrinhos;
	}

	public void setCarrinhos(List<Carrinho> carrinhos) {
		this.carrinhos = carrinhos;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
