package com.okayula.Parque_Estacionamento.controller.cadastro_dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.okayula.Parque_Estacionamento.modelo.Condutor;
import com.okayula.Parque_Estacionamento.modelo.Veiculo;
import com.okayula.Parque_Estacionamento.repository.CondutorRepository;

public class Cadastro_VeiculoDto {
	
	@NotNull @NotEmpty
	private String marca;
	@NotNull @NotEmpty
	private String modelo;
	@NotNull @NotEmpty
	private String matricula;
	@NotNull @NotEmpty
	private Long cavalos;
	private String nomeCondutor;
	
	
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Long getCavalos() {
		return cavalos;
	}
	public void setCavalos(Long cavalos) {
		this.cavalos = cavalos;
	}
	public String getNomeCondutor() {
		return nomeCondutor;
	}
	public void setNomeCondutor(String nomeCondutor) {
		this.nomeCondutor = nomeCondutor;
	}
	
	
	public Veiculo converter(CondutorRepository condutorRespository) {
		Condutor condutor = condutorRespository.CarregarNomeCondutor(nomeCondutor);
		return new Veiculo(marca, modelo, matricula, cavalos, condutor);
	}
	
	
	
	
	

}
