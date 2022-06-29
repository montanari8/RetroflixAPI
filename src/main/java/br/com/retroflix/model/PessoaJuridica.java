package br.com.retroflix.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica {
	
	@Id
	@Column(name = "cnpj", nullable = false, length = 14)
	private String cnpj;
	
	@Column(name = "ie", nullable = false, length = 14)
	private String ie;
	
	@Column(name = "create_time")
	private LocalDate createTime;
	
	@Column(name = "razao_social", nullable = false, length = 150)
	private String razaoSocial;
	
	@Column(name = "nome_fantasia", length = 45) //verificar tamanho do campo e se pode ser nulo
	private String nomeFantasia;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id_usuario")
	private Usuario usuario;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getIe() {
		return ie;
	}
	public void setIe(String ie) {
		this.ie = ie;
	}
	public LocalDate getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDate createTime) {
		this.createTime = createTime;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
