package com.okayula.Parque_Estacionamento.controller.cadastro_dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


import com.okayula.Parque_Estacionamento.modelo.FormaPagamento;
import com.okayula.Parque_Estacionamento.modelo.ParametrizacaoPagamento;
import com.okayula.Parque_Estacionamento.modelo.PeriodoEstacionamento;
import com.okayula.Parque_Estacionamento.repository.FormaPagamentoRepository;

public class Cadastro_Parametrizacao_PagamentoDto {
	
	
	private LocalDate data;
	private BigDecimal valorPorHora;
	@Enumerated(EnumType.STRING)
	private PeriodoEstacionamento periodoEstacionamento;
	private String descricao_formaPagamento;
	
	
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public BigDecimal getValorPorHora() {
		return valorPorHora;
	}
	public void setValorPorHora(BigDecimal valorPorHora) {
		this.valorPorHora = valorPorHora;
	}
	public PeriodoEstacionamento getPeriodoEstacionamento() {
		return periodoEstacionamento;
	}
	public void setPeriodoEstacionamento(PeriodoEstacionamento periodoEstacionamento) {
		this.periodoEstacionamento = periodoEstacionamento;
	}
	public String getDescricao_formaPagamento() {
		return descricao_formaPagamento;
	}
	public void setDescricao_formaPagamento(String descricao_formaPagamento) {
		this.descricao_formaPagamento = descricao_formaPagamento;
	}
	
	
	public ParametrizacaoPagamento converter(FormaPagamentoRepository forma_pagamentoRepository) {
		FormaPagamento formaPagamento = forma_pagamentoRepository.carregarPelaDescricao(descricao_formaPagamento);
		return new ParametrizacaoPagamento(data, valorPorHora, formaPagamento, periodoEstacionamento);
	}
	
	
	

}
