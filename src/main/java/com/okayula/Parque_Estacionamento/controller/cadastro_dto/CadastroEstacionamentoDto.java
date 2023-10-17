package com.okayula.Parque_Estacionamento.controller.cadastro_dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


import com.okayula.Parque_Estacionamento.modelo.Estacionamento;


public class CadastroEstacionamentoDto {
	
	@NotNull @NotEmpty 
	private String nome;
	
	@NotNull @NotEmpty @Length(min = 5)
	private String descricao;
	
	private Boolean estado;
	
	
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
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

	

	

	public Estacionamento converter() {
		return new Estacionamento(nome, descricao, estado);
	}

}
