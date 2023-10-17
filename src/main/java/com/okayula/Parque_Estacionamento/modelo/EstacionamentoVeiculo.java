package com.okayula.Parque_Estacionamento.modelo;

import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class EstacionamentoVeiculo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private ParametrizacaoPagamento parametrizacao;
	@ManyToOne
	private Veiculo veiculo;
	@ManyToOne
	private Estacionamento estacionamento;
	
	private LocalDateTime dataEntrada = LocalDateTime.now();
	private LocalDateTime dataSaida = LocalDateTime.now();

	private LocalDateTime dataInicioPago = LocalDateTime.now();
	private LocalDateTime dataFimPago = LocalDateTime.now();
	
	
	
	
	
	public EstacionamentoVeiculo() {
	}
	
	



	public EstacionamentoVeiculo(Veiculo veiculo, Estacionamento estacionamento, LocalDateTime dataEntrada,
			LocalDateTime dataSaida, LocalDateTime dataInicioPago, LocalDateTime dataFimPago) {
		super();
		this.veiculo = veiculo;
		this.estacionamento = estacionamento;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.dataInicioPago = dataInicioPago;
		this.dataFimPago = dataFimPago;
	}





	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public LocalDateTime getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(LocalDateTime dataSaida) {
		this.dataSaida = dataSaida;
	}
	public ParametrizacaoPagamento getParametrizacao() {
		return parametrizacao;
	}
	public void setParametrizacao(ParametrizacaoPagamento parametrizacao) {
		this.parametrizacao = parametrizacao;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Estacionamento getEstacionamento() {
		return estacionamento;
	}
	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}
	public LocalDateTime getDataInicioPago() {
		return dataInicioPago;
	}
	public void setDataInicioPago(LocalDateTime dataInicioPago) {
		this.dataInicioPago = dataInicioPago;
	}
	public LocalDateTime getDataFimPago() {
		return dataFimPago;
	}
	public void setDataFimPago(LocalDateTime dataFimPago) {
		this.dataFimPago = dataFimPago;
	}
	
	
	
	
	
	
	

}
