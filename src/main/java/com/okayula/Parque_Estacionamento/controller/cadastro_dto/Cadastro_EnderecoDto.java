package com.okayula.Parque_Estacionamento.controller.cadastro_dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.okayula.Parque_Estacionamento.modelo.Endereco;

public class Cadastro_EnderecoDto {
	
	@NotNull @NotEmpty
	private String rua;
	@NotNull @NotEmpty
	private String bairro;
	@NotNull @NotEmpty
	private String cep;
	@NotNull @NotEmpty
	private Integer numero;
	@NotNull @NotEmpty
	private String cidade;
	@NotNull @NotEmpty
	private String estado;
	
	
	
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	public Endereco converter() {
		return new Endereco(rua, bairro, cep, numero, cidade, estado);
	}
	
	
	

}
