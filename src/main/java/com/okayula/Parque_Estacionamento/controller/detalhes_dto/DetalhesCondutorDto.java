package com.okayula.Parque_Estacionamento.controller.detalhes_dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.okayula.Parque_Estacionamento.controller.dto.CondutorEnderecoDto;
import com.okayula.Parque_Estacionamento.controller.dto.VeiculoDto;
import com.okayula.Parque_Estacionamento.modelo.Condutor;

public class DetalhesCondutorDto {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String documento;
	private String cpf;
	
	private List<CondutorEnderecoDto> condutorEndereco;
	private List<VeiculoDto> veiculo;

	public DetalhesCondutorDto(Condutor condutor) {
		this.id = condutor.getId();
		this.nome = condutor.getNome();
		this.email = condutor.getEmail();
		this.telefone = condutor.getTelefone();
		this.documento = condutor.getDocumento();
		this.cpf = condutor.getCpf();
		this.condutorEndereco = new ArrayList<>();
		this.condutorEndereco.addAll(condutor.getCondutorEndereco().stream().map(CondutorEnderecoDto::new).collect(Collectors.toList()));
		this.veiculo = new ArrayList<>();
		this.veiculo.addAll(condutor.getVeiculo().stream().map(VeiculoDto::new).collect(Collectors.toList()));
		
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

	public List<CondutorEnderecoDto> getCondutorEndereco() {
		return condutorEndereco;
	}

	public List<VeiculoDto> getVeiculo() {
		return veiculo;
	}
	
	
	
	

}
