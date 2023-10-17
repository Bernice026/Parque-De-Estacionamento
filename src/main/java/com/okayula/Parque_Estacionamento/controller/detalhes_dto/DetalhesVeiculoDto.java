package com.okayula.Parque_Estacionamento.controller.detalhes_dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.okayula.Parque_Estacionamento.controller.dto.EstacionamentoVeiculoDto;
import com.okayula.Parque_Estacionamento.modelo.Veiculo;

public class DetalhesVeiculoDto {
	
	
	
	private Long id;
	private String marca;
	private String modelo;
	private String matricula;
	private Long cavalos;
	private String nomeCondutor;
	private List<EstacionamentoVeiculoDto> estacionamentoVeiculo;
	
	
	
	public DetalhesVeiculoDto(Veiculo veiculo) {
		this.id = veiculo.getId();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.matricula = veiculo.getMatricula();
		this.cavalos = veiculo.getCavalos();
		this.nomeCondutor = veiculo.getCondutor().getNome();
		this.estacionamentoVeiculo = new ArrayList<>();
		this.estacionamentoVeiculo.addAll(veiculo.getEstacionamentoVeiculo().stream().map(EstacionamentoVeiculoDto::new).collect(Collectors.toList()));
	}



	public Long getId() {
		return id;
	}



	public String getMarca() {
		return marca;
	}



	public String getModelo() {
		return modelo;
	}



	public String getMatricula() {
		return matricula;
	}



	public Long getCavalos() {
		return cavalos;
	}



	public String getNomeCondutor() {
		return nomeCondutor;
	}



	public List<EstacionamentoVeiculoDto> getEstacionamentoVeiculo() {
		return estacionamentoVeiculo;
	}
	
	
	

}
