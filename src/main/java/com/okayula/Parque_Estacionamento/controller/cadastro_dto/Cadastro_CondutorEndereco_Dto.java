package com.okayula.Parque_Estacionamento.controller.cadastro_dto;

import com.okayula.Parque_Estacionamento.modelo.Condutor;
import com.okayula.Parque_Estacionamento.modelo.CondutorEndereco;
import com.okayula.Parque_Estacionamento.modelo.Endereco;
import com.okayula.Parque_Estacionamento.repository.CondutorRepository;
import com.okayula.Parque_Estacionamento.repository.EnderecoRepository;

public class Cadastro_CondutorEndereco_Dto {
	
	
	
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
	
	
	public CondutorEndereco converter(CondutorRepository condutorRepository, EnderecoRepository enderecoRepository) {
		Condutor condutor = condutorRepository.getById(condutor_id);
		Endereco endereco = enderecoRepository.getById(endereco_id);
		return new CondutorEndereco(condutor, endereco);
	}
	
	

}
