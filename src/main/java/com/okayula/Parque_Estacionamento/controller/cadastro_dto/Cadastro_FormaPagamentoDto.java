package com.okayula.Parque_Estacionamento.controller.cadastro_dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.okayula.Parque_Estacionamento.modelo.FormaPagamento;

public class Cadastro_FormaPagamentoDto {
	
	@NotNull @NotEmpty
	private String descricao;
	private Boolean estado = false;
	
	
	
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
	
	
	public FormaPagamento converter() {
		return new FormaPagamento(descricao, estado);
	}
	
	
	

}
