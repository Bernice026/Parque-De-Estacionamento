package com.okayula.Parque_Estacionamento.controller.actualizar_dto;

import com.okayula.Parque_Estacionamento.modelo.CondutorEndereco;
import com.okayula.Parque_Estacionamento.repository.CondutorEnderecoRepository;

public class Actualizar_CondutorEnderecoDto {
	
	private Long condutor_id;
	private Long endereco_id;
	
	
	
	public Long getCondutor_id() {
		return condutor_id;
	}
	public void setCondutor_id(Long condutor_id) {
		this.condutor_id = condutor_id;
	}
	public Long getEndereco_id() {
		return endereco_id;
	}
	public void setEndereco_id(Long endereco_id) {
		this.endereco_id = endereco_id;
	}
	
	
	@SuppressWarnings("deprecation")
	public CondutorEndereco converter(Long id, CondutorEnderecoRepository condutor_enderecoRespository) {
		CondutorEndereco condutor_endereco = condutor_enderecoRespository.getOne(id);
		this.condutor_id = condutor_endereco.getCondutor().getId();
		this.endereco_id = condutor_endereco.getEndereco().getId();
		return condutor_endereco;
	}

	
	
	
}
