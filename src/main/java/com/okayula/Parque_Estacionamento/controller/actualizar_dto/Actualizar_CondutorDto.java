package com.okayula.Parque_Estacionamento.controller.actualizar_dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.okayula.Parque_Estacionamento.modelo.Condutor;
import com.okayula.Parque_Estacionamento.repository.CondutorRepository;

public class Actualizar_CondutorDto {
	
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String email;
	@NotNull @NotEmpty
	private String telefone;
	@NotNull @NotEmpty
	private String documento;
	@NotNull @NotEmpty
	private String cpf;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	@SuppressWarnings("deprecation")
	public Condutor converter(Long id, CondutorRepository condutorRepository) {
		Condutor condutor = condutorRepository.getOne(id);
		condutor.setNome(this.nome);
		condutor.setEmail(this.email);
		condutor.setTelefone(this.telefone);
		condutor.setDocumento(this.documento);
		condutor.setCpf(this.cpf);
		return condutor;
	}
	
	
	
	

}
