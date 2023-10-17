package com.okayula.Parque_Estacionamento.controller.detalhes_dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.okayula.Parque_Estacionamento.controller.dto.EstacionamentoVeiculoDto;
import com.okayula.Parque_Estacionamento.modelo.ParametrizacaoPagamento;

public class DetalhesParametrizacaoPagamentoDto {
	
	
	private Long id;
	private LocalDate data;
	private BigDecimal valorPorHora;
	private String forma_pagamento;
	private List<EstacionamentoVeiculoDto> estacionamentoVeiculo;
	
	
	
	
	
	
	public DetalhesParametrizacaoPagamentoDto(ParametrizacaoPagamento para_pagamento) {
		this.id = para_pagamento.getId();
		this.data = para_pagamento.getData();
		this.valorPorHora = para_pagamento.getValorPorHora();
		this.forma_pagamento = para_pagamento.getFormaPagamento().getDescricao();
		this.estacionamentoVeiculo = new ArrayList<>();
		this.estacionamentoVeiculo.addAll(para_pagamento.getEstacionamentoVeiculo().stream().map(EstacionamentoVeiculoDto::new)
				.collect(Collectors.toList()));
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


	public List<EstacionamentoVeiculoDto> getEstacionamentoVeiculo() {
		return estacionamentoVeiculo;
	}
	
	
	

}
