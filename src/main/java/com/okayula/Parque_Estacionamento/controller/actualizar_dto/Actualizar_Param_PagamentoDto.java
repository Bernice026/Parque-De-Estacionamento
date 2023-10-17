package com.okayula.Parque_Estacionamento.controller.actualizar_dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.okayula.Parque_Estacionamento.modelo.ParametrizacaoPagamento;
import com.okayula.Parque_Estacionamento.modelo.PeriodoEstacionamento;
import com.okayula.Parque_Estacionamento.repository.ParametrizacaoPagamentoRepository;

public class Actualizar_Param_PagamentoDto {
	
	
	private LocalDate data;
	private BigDecimal valorPorHora;
	@Enumerated(EnumType.STRING)
	private PeriodoEstacionamento periodoEstacionamento;
	
	
	
	
	
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
	
	
	@SuppressWarnings("deprecation")
	public ParametrizacaoPagamento converter(Long id, ParametrizacaoPagamentoRepository para_pg_Respository) {
		ParametrizacaoPagamento param_pagamento = para_pg_Respository.getOne(id);
		param_pagamento.setData(this.data);
		param_pagamento.setValorPorHora(this.valorPorHora);
		param_pagamento.setPeriodoEstacionamento(this.periodoEstacionamento);
		return param_pagamento;
	}
	
	
	
	

}
