package com.okayula.Parque_Estacionamento.controller.detalhes_dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.okayula.Parque_Estacionamento.controller.dto.EstacionamentoVeiculoDto;
import com.okayula.Parque_Estacionamento.modelo.Estacionamento;

public class DetalhesEstacionamentoDto {
	
	
	private Long id;
	private String descricao;
	private Boolean estado;
	private String bairroEndereco;
	private String cidadeEndereco;
	
	private List<EstacionamentoVeiculoDto> e_vDto;
	
	
	public DetalhesEstacionamentoDto(Estacionamento estacionamento) {
		this.id = estacionamento.getId();
		this.descricao = estacionamento.getDescricao();
		this.estado = estacionamento.getEstado();
		this.bairroEndereco = estacionamento.getEndereco().getBairro();
		this.cidadeEndereco = estacionamento.getEndereco().getCidade();
		this.e_vDto = new ArrayList<EstacionamentoVeiculoDto>();
		this.e_vDto.addAll(estacionamento.getEstacionamentoVeiculo().stream().map(EstacionamentoVeiculoDto::new).collect(Collectors.toList()));
		
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

	public String getBairroEndereco() {
		return bairroEndereco;
	}

	public String getCidadeEndereco() {
		return cidadeEndereco;
	}

	public List<EstacionamentoVeiculoDto> getE_vDto() {
		return e_vDto;
	}
	
	
	
	

}
