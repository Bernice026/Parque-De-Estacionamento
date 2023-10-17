package com.okayula.Parque_Estacionamento.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.okayula.Parque_Estacionamento.modelo.Endereco;

public class EnderecoDto {
	
	private Long id;
	private String rua;
	private String bairro;
	private String cep;
	private Integer numero;
	private String cidade;
	private String estado;
	
	
	
	
	public EnderecoDto(Endereco endereco) {
		
		this.id = endereco.getId();
		this.rua = endereco.getRua();
		this.bairro = endereco.getBairro();
		this.cep = endereco.getCep();
		this.numero = endereco.getNumero();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		
		
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



	


	public static List<EnderecoDto> converter(List<Endereco> endereco) {
		
		return endereco.stream().map(EnderecoDto::new).collect(Collectors.toList());
	}
	
	
	
	
	
	
	
	
	
	
	

}
