package com.okayula.Parque_Estacionamento.controller.detalhes_dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import com.okayula.Parque_Estacionamento.controller.dto.CondutorEnderecoDto;
import com.okayula.Parque_Estacionamento.controller.dto.EstacionamentoDto;
import com.okayula.Parque_Estacionamento.modelo.Endereco;

public class DetalhesEnderecoDto {
	
	
	private Long id;
	private String rua;
	private String bairro;
	private String cep;
	private Integer numero;
	private String cidade;
	private String estado;
	
	private List<CondutorEnderecoDto> condutorEndereco;
	private List<EstacionamentoDto> estacionamento;
	
	
	
	
	public DetalhesEnderecoDto(Endereco endereco) {
		
		this.id = endereco.getId();
		this.rua = endereco.getRua();
		this.bairro = endereco.getBairro();
		this.cep = endereco.getCep();
		this.numero = endereco.getNumero();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.condutorEndereco = new ArrayList<>();
		this.condutorEndereco.addAll(endereco.getCondutorEndereco().stream().map(CondutorEnderecoDto::new).collect(Collectors.toList()));
		this.estacionamento = new ArrayList<>();
		this.estacionamento.addAll(endereco.getEstacionamento().stream().map(EstacionamentoDto::new).collect(Collectors.toList()));
		
	}




	public Long getId() {
		return id;
	}




	public String getRua() {
		return rua;
	}




	public String getBairro() {
		return bairro;
	}




	public String getCep() {
		return cep;
	}




	public Integer getNumero() {
		return numero;
	}




	public String getCidade() {
		return cidade;
	}




	public String getEstado() {
		return estado;
	}




	public List<CondutorEnderecoDto> getCondutorEndereco() {
		return condutorEndereco;
	}




	public List<EstacionamentoDto> getEstacionamento() {
		return estacionamento;
	}
	
	
	

}
