package com.okayula.Parque_Estacionamento.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Veiculo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String modelo;
	private String matricula;
	private Long cavalos;
	
	@ManyToOne
	private Condutor condutor;
	
	@OneToMany(mappedBy = "veiculo" )
	private List<EstacionamentoVeiculo> estacionamentoVeiculo= new ArrayList<>();
	
	
	
	
	
	public Veiculo() {
		
	}
	
	
	
	
	
	public Veiculo(String marca, String modelo, String matricula, Long cavalos, Condutor condutor) {
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.cavalos = cavalos;
		this.condutor = condutor;
	}





	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Condutor getCondutor() {
		return condutor;
	}
	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}
	public List<EstacionamentoVeiculo> getEstacionamentoVeiculo() {
		return estacionamentoVeiculo;
	}
	public void setEstacionamentoVeiculo(List<EstacionamentoVeiculo> estacionamentoVeiculo) {
		this.estacionamentoVeiculo = estacionamentoVeiculo;
	}
	
	
	
	

}
