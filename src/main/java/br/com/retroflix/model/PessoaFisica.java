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
@Table(name = "pessoa_fisica")
public class PessoaFisica {
	
	@Id
	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "rg", nullable = false, length = 9)
	private String rg;
	
	@Column(name = "nome_completo", nullable = false)
	private String nomeCompleto;
	
	@Column(name = "nascimento", nullable = false)
	private LocalDate nascimento;
	
	@Column(name = "create_time")
	private LocalDate createTime;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id_usuario")
	private Usuario usuario;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public LocalDate getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDate createTime) {
		this.createTime = createTime;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario clienteIdUsuario) {
		this.usuario = clienteIdUsuario;
	}
}
