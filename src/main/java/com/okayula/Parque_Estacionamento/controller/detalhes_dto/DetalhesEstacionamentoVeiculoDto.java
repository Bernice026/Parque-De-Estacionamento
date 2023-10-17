package com.okayula.Parque_Estacionamento.controller.detalhes_dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.okayula.Parque_Estacionamento.modelo.EstacionamentoVeiculo;

public class DetalhesEstacionamentoVeiculoDto {
	
	
	private Long id;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private LocalDateTime dataInicioPago;
	private LocalDateTime dataFimPago;
	private String marcaVeiculo;
	private String nomeEstacionamento;
	private BigDecimal parametrizacaoEstacionamento;
	
	
	
	public DetalhesEstacionamentoVeiculoDto(EstacionamentoVeiculo esta_veiculo) {
		this.id = esta_veiculo.getId();
		this.dataEntrada = esta_veiculo.getDataEntrada();
		this.dataSaida = esta_veiculo.getDataSaida();
		this.dataInicioPago = esta_veiculo.getDataInicioPago();
		this.dataFimPago = esta_veiculo.getDataFimPago();
		this.marcaVeiculo = esta_veiculo.getVeiculo().getMarca();
		this.nomeEstacionamento = esta_veiculo.getEstacionamento().getNome();
		this.parametrizacaoEstacionamento = esta_veiculo.getParametrizacao().getValorPorHora();
	}



	public Long getId() {
		return id;
	}



	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}



	public LocalDateTime getDataSaida() {
		return dataSaida;
	}



	public LocalDateTime getDataInicioPago() {
		return dataInicioPago;
	}



	public LocalDateTime getDataFimPago() {
		return dataFimPago;
	}



	public String getMarcaVeiculo() {
		return marcaVeiculo;
	}



	public String getNomeEstacionamento() {
		return nomeEstacionamento;
	}



	public BigDecimal getParametrizacaoEstacionamento() {
		return parametrizacaoEstacionamento;
	}
	
	
	
	

}
