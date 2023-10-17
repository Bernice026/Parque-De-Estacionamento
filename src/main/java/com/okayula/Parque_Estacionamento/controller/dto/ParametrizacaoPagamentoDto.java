package com.okayula.Parque_Estacionamento.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.okayula.Parque_Estacionamento.modelo.ParametrizacaoPagamento;

public class ParametrizacaoPagamentoDto {

	
	
	private Long id;
	private LocalDate data;
	private BigDecimal valorPorHora;
	private String forma_pagamento;
	
	
	
	
	
	
	public ParametrizacaoPagamentoDto(ParametrizacaoPagamento para_pagamento) {
		this.id = para_pagamento.getId();
		this.data = para_pagamento.getData();
		this.valorPorHora = para_pagamento.getValorPorHora();
		this.forma_pagamento = para_pagamento.getFormaPagamento().getDescricao();
	}
	
	
	
	
	public Long getId() {
		return id;
	}
	public LocalDate getData() {
		return data;
	}
	public BigDecimal getValorPorHora() {
		return valorPorHora;
	}
	public String getForma_pagamento() {
		return forma_pagamento;
	}




	public static List<ParametrizacaoPagamentoDto> converter(List<ParametrizacaoPagamento> para_pagamento) {
		return para_pagamento.stream().map(ParametrizacaoPagamentoDto::new).collect(Collectors.toList());
	}
	
	
	
}
