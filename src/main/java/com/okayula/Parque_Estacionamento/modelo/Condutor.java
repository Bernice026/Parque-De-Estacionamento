package com.okayula.Parque_Estacionamento.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Condutor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String documento;
	private String cpf;
	
	@OneToMany(mappedBy = "condutor")
	private List<CondutorEndereco> condutorEndereco = new ArrayList<>();
	
	@OneToMany(mappedBy = "condutor")
	private List<Veiculo> veiculo = new ArrayList<>();
	

	
	public Condutor() {
		
	}
	
	
	
	
	
	
	public Condutor(String nome, String email, String telefone, String documento, String cpf) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.documento = documento;
		this.cpf = cpf;
	}






	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public List<CondutorEndereco> getCondutorEndereco() {
		return condutorEndereco;
	}
	public void setCondutorEndereco(List<CondutorEndereco> condutorEndereco) {
		this.condutorEndereco = condutorEndereco;
	}

	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}
	
	
	

}
