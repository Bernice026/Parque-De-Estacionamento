package com.okayula.Parque_Estacionamento.controller.actualizar_dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.okayula.Parque_Estacionamento.modelo.Veiculo;
import com.okayula.Parque_Estacionamento.repository.VeiculoRepository;

public class Actualizar_VeiculoDto {
	
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
	
	
	@SuppressWarnings("deprecation")
	public Veiculo converter(Long id, VeiculoRepository veiculoRepository) {
		Veiculo veiculo = veiculoRepository.getOne(id);
		veiculo.setMarca(this.marca);
		veiculo.setModelo(this.modelo);
		veiculo.setMatricula(this.matricula);
		veiculo.setCavalos(this.cavalos);
		this.nomeCondutor = veiculo.getCondutor().getNome();
		return veiculo;
	}
	
	
	
	

}
