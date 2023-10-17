package com.okayula.Parque_Estacionamento.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.okayula.Parque_Estacionamento.modelo.EstacionamentoVeiculo;

public class EstacionamentoVeiculoDto {

	
	
	
	private Long id;
	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private LocalDateTime dataInicioPago;
	private LocalDateTime dataFimPago;
	private String marcaVeiculo;
	private String nomeEstacionamento;
	
	
	public EstacionamentoVeiculoDto(EstacionamentoVeiculo esta_veiculo) {
		this.id = esta_veiculo.getId();
		this.dataEntrada = esta_veiculo.getDataEntrada();
		this.dataSaida = esta_veiculo.getDataSaida();
		this.dataInicioPago = esta_veiculo.getDataInicioPago();
		this.dataFimPago = esta_veiculo.getDataFimPago();
		this.marcaVeiculo = esta_veiculo.getVeiculo().getMarca();
		this.nomeEstacionamento = esta_veiculo.getEstacionamento().getNome();
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


	

	public static List<EstacionamentoVeiculoDto> converter(List<EstacionamentoVeiculo> esta_veiculo) {
		return esta_veiculo.stream().map(EstacionamentoVeiculoDto::new).collect(Collectors.toList());
	}
	
	
	
	
	

	
	
}