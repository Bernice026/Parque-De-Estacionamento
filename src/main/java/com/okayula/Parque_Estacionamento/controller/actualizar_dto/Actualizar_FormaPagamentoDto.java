package com.okayula.Parque_Estacionamento.controller.actualizar_dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.okayula.Parque_Estacionamento.modelo.FormaPagamento;
import com.okayula.Parque_Estacionamento.repository.FormaPagamentoRepository;

public class Actualizar_FormaPagamentoDto {
	
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
	@SuppressWarnings("deprecation")
	public FormaPagamento converter(Long id, FormaPagamentoRepository forma_pagamentoRepository) {
		FormaPagamento formaPagamento = forma_pagamentoRepository.getOne(id);
		formaPagamento.setDescricao(this.descricao);
		formaPagamento.setEstado(this.estado);
		return formaPagamento;
	}
	
	

}
