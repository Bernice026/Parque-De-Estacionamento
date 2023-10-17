package com.okayula.Parque_Estacionamento.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rua;
	private String bairro;
	private String cep;
	private Integer numero;
	private String cidade;
	private String estado;
	
	@OneToMany(mappedBy = "endereco")
	private List<CondutorEndereco> condutorEndereco = new ArrayList<>();
	
	@OneToMany(mappedBy = "endereco")
	private List<Estacionamento> estacionamento= new ArrayList<>();
	
	
	
	
	
	

	public Endereco() {
	}
	
	
	
	
	

	public Endereco(String rua, String bairro, String cep, Integer numero, String cidade, String estado) {
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
	}






	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<CondutorEndereco> getCondutorEndereco() {
		return condutorEndereco;
	}

	public void setCondutorEndereco(List<CondutorEndereco> condutorEndereco) {
		this.condutorEndereco = condutorEndereco;
	}

	public List<Estacionamento> getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(List<Estacionamento> estacionamento) {
		this.estacionamento = estacionamento;
	}
	
	
	
	

}
