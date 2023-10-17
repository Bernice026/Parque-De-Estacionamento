package com.okayula.Parque_Estacionamento.controller.actualizar_dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.okayula.Parque_Estacionamento.modelo.Estacionamento;
import com.okayula.Parque_Estacionamento.repository.EstacionamentoRepository;

public class ActualizarEstacionamentoDto {
	
	@NotNull @NotEmpty 
	private String nome;
	
	@NotNull @NotEmpty @Length(min = 5)
	private String descricao;
	
	private Boolean estado;
	
	
	
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@SuppressWarnings("deprecation")
	public Estacionamento converter(Long id, EstacionamentoRepository estacionamentoRepository) {
		Estacionamento estacionamento = estacionamentoRepository.getOne(id);
		estacionamento.setNome(this.nome);
		estacionamento.setDescricao(this.descricao);
		estacionamento.setEstado(this.estado);
		return estacionamento;
	}
	
	
	

}
