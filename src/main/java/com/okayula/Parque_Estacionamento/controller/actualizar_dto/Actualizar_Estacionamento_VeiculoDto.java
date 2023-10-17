package com.okayula.Parque_Estacionamento.controller.actualizar_dto;

import java.time.LocalDateTime;


import javax.validation.constraints.NotNull;

import com.okayula.Parque_Estacionamento.modelo.EstacionamentoVeiculo;
import com.okayula.Parque_Estacionamento.repository.EstacionamentoVeiculoRepository;

public class Actualizar_Estacionamento_VeiculoDto {
	
	
	private LocalDateTime dataEntrada = LocalDateTime.now();
	private LocalDateTime dataSaida = LocalDateTime.now();
	
	private LocalDateTime dataInicioPago = LocalDateTime.now();
	private LocalDateTime dataFimPago = LocalDateTime.now();
	@NotNull
	private String marcaVeiculo;
	@NotNull
	private String nomeEstacionamento;
	
	
	
	
	
	
	
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
	public String getMarcaVeiculo() {
		return marcaVeiculo;
	}
	public void setMarcaVeiculo(String marcaVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
	}
	public String getNomeEstacionamento() {
		return nomeEstacionamento;
	}
	public void setNomeEstacionamento(String nomeEstacionamento) {
		this.nomeEstacionamento = nomeEstacionamento;
	}
	
	
	
	@SuppressWarnings("deprecation")
	public EstacionamentoVeiculo converter(Long id, EstacionamentoVeiculoRepository esta_veiculoRepository) {
		EstacionamentoVeiculo esta_veiculo = esta_veiculoRepository.getOne(id);
		esta_veiculo.setDataEntrada(this.dataEntrada);
		esta_veiculo.setDataSaida(this.dataSaida);
		esta_veiculo.setDataInicioPago(this.dataInicioPago);
		esta_veiculo.setDataFimPago(this.dataFimPago);
		this.marcaVeiculo = esta_veiculo.getVeiculo().getMarca();
		this.nomeEstacionamento = esta_veiculo.getEstacionamento().getNome();
		return esta_veiculo;
	}
	
	
	
	

}
