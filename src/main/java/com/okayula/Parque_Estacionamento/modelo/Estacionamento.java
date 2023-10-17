package com.okayula.Parque_Estacionamento.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Estacionamento {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private Boolean estado;
	
	@ManyToOne
	private Endereco endereco;
	
	@OneToMany(mappedBy = "estacionamento" )
	private List<EstacionamentoVeiculo> estacionamentoVeiculo= new ArrayList<>();
	
	
	



	public Estacionamento() {
		
	}
	
	



	public Estacionamento(String nome, String descricao, Boolean estado) {
		this.nome = nome;
		this.descricao = descricao;
		this.estado = estado;
	}





	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDescricao() {
		return descricao;
	}
	
	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}





	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public Boolean getEstado() {
		return estado;
	}



	public void setEstado(Boolean estado) {
		this.estado = estado;
	}



	public List<EstacionamentoVeiculo> getEstacionamentoVeiculo() {
		return estacionamentoVeiculo;
	}



	public void setEstacionamentoVeiculo(List<EstacionamentoVeiculo> estacionamentoVeiculo) {
		this.estacionamentoVeiculo = estacionamentoVeiculo;
	}



	public Endereco getEndereco() {
		return endereco;
	}



	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}



	
	
	
	
	
	
	

}
