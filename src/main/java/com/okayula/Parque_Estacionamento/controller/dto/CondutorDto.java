package com.okayula.Parque_Estacionamento.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.okayula.Parque_Estacionamento.modelo.Condutor;

public class CondutorDto {
	
	
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String documento;
	private String cpf;
	
	
	public CondutorDto(Condutor condutor) {
		this.id = condutor.getId();
		this.nome = condutor.getNome();
		this.email = condutor.getEmail();
		this.telefone = condutor.getTelefone();
		this.documento = condutor.getDocumento();
		this.cpf = condutor.getCpf();
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public String getTelefone() {
		return telefone;
	}


	public String getDocumento() {
		return documento;
	}


	public String getCpf() {
		return cpf;
	}


	public static List<CondutorDto> converter(List<Condutor> condutor) {
		return condutor.stream().map(CondutorDto::new).collect(Collectors.toList());
	}
	
	
	
	
	
	
	

}
