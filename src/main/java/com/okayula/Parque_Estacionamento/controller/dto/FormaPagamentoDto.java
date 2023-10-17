package com.okayula.Parque_Estacionamento.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.okayula.Parque_Estacionamento.modelo.FormaPagamento;

public class FormaPagamentoDto {
	
	private Long id;
	private String descricao;
	private Boolean estado = false;
	
	
	public FormaPagamentoDto(FormaPagamento forma_pagamento) {
		this.id = forma_pagamento.getId();
		this.descricao = forma_pagamento.getDescricao();
		this.estado = forma_pagamento.getEstado();
	}


	public Long getId() {
		return id;
	}


	public String getDescricao() {
		return descricao;
	}


	public Boolean getEstado() {
		return estado;
	}


	public static List<FormaPagamentoDto> converter(List<FormaPagamento> forma_pagamento) {
		return forma_pagamento.stream().map(FormaPagamentoDto::new).collect(Collectors.toList());
	}
	
	
	
	

}
