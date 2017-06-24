package br.com.tt.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length = 100)
	private String contato;
	
	@Column(nullable=false, length = 100)
	private String rSocial;
	
	@Column(nullable=false, length = 100)
	private String nFantasia;
	
	@Column(length = 100)
	private String inscEstadual;
	
	@Column(length = 100)
	private String inscMunicial;
	
	@Column(length = 100)
	@Temporal(TemporalType.DATE)
	private Calendar dataCadastro;
	
	@Column(length = 11)
	private String telefone;
	
	@Column(length = 20)
	private String cnpj;
	
	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
	private List<Endereco> enderecos;
	
	@Column(length=100)
	private String email;
	
	@Column
	private Boolean oferta;
	
	@Column
	private String status;
	
	@Column(length=300)
	private String obs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getrSocial() {
		return rSocial;
	}

	public void setrSocial(String rSocial) {
		this.rSocial = rSocial;
	}

	public String getnFantasia() {
		return nFantasia;
	}

	public void setnFantasia(String nFantasia) {
		this.nFantasia = nFantasia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}



	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public String getInscMunicial() {
		return inscMunicial;
	}

	public void setInscMunicial(String inscMunicial) {
		this.inscMunicial = inscMunicial;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getOferta() {
		return oferta;
	}

	public void setOferta(Boolean oferta) {
		this.oferta = oferta;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
	

	
	
}
