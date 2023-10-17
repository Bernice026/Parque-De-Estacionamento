package com.okayula.Parque_Estacionamento.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.okayula.Parque_Estacionamento.modelo.Estacionamento;

public class EstacionamentoDto {
	
	
	private Long id;
	private String nome;
	private String descricao;
	private Boolean estado;
	
	
	
	public EstacionamentoDto(Estacionamento estacionamento) {
		this.id = estacionamento.getId();
		this.nome = estacionamento.getNome();
		this.descricao = estacionamento.getDescricao();
		this.estado = estacionamento.getEstado();
		
	}


	public Long getId() {
		return id;
	}
	
	
	public String getNome() {
		return nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public Boolean getEstado() {
		return estado;
	}


	


	public static List<EstacionamentoDto> converter(List<Estacionamento> estacionamento) {
		return estacionamento.stream().map(EstacionamentoDto::new).collect(Collectors.toList());
	}



	
	
	
	
	
	
	

}
