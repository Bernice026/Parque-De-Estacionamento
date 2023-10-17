package com.okayula.Parque_Estacionamento.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.okayula.Parque_Estacionamento.modelo.CondutorEndereco;

public class CondutorEnderecoDto {
	
	private Long id;
	private String nomeCondutor;
	private String emailCondutor;
	private String bairroEndereco;
	private String cidadeEndereco;
	
	
	public CondutorEnderecoDto(CondutorEndereco condutor_endereco) {
		this.id = condutor_endereco.getId();
		this.nomeCondutor = condutor_endereco.getCondutor().getNome();
		this.emailCondutor = condutor_endereco.getCondutor().getEmail();
		this.bairroEndereco = condutor_endereco.getEndereco().getBairro();
		this.cidadeEndereco = condutor_endereco.getEndereco().getCidade();
		
	}


	public Long getId() {
		return id;
	}


	public String getNomeCondutor() {
		return nomeCondutor;
	}


	public String getEmailCondutor() {
		return emailCondutor;
	}


	public String getBairroEndereco() {
		return bairroEndereco;
	}


	public String getCidadeEndereco() {
		return cidadeEndereco;
	}


	public static List<CondutorEnderecoDto> converter(List<CondutorEndereco> condutor_endereco) {
		return condutor_endereco.stream().map(CondutorEnderecoDto::new).collect(Collectors.toList());
	}
	
	
	
	
	

}
