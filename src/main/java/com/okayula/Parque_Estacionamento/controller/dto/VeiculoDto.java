package com.okayula.Parque_Estacionamento.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.okayula.Parque_Estacionamento.modelo.Veiculo;

public class VeiculoDto {
	
	
	private Long id;
	private String marca;
	private String modelo;
	private String matricula;
	private Long cavalos;
	private String nomeCondutor;
	
	
	
	public VeiculoDto(Veiculo veiculo) {
		this.id = veiculo.getId();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.matricula = veiculo.getMatricula();
		this.cavalos = veiculo.getCavalos();
		this.nomeCondutor = veiculo.getCondutor().getNome();
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



	public static List<VeiculoDto> converter(List<Veiculo> veiculo) {
		return veiculo.stream().map(VeiculoDto::new).collect(Collectors.toList());
	}
	
	
	
	
	
	
	
	

}
