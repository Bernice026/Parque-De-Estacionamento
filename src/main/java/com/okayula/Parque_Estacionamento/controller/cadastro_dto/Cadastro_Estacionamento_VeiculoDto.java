package com.okayula.Parque_Estacionamento.controller.cadastro_dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.okayula.Parque_Estacionamento.modelo.Estacionamento;
import com.okayula.Parque_Estacionamento.modelo.EstacionamentoVeiculo;
import com.okayula.Parque_Estacionamento.modelo.Veiculo;
import com.okayula.Parque_Estacionamento.repository.EstacionamentoRepository;
import com.okayula.Parque_Estacionamento.repository.VeiculoRepository;



public class Cadastro_Estacionamento_VeiculoDto {
	
	
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
	
	
	
	
	public EstacionamentoVeiculo converter(VeiculoRepository veiculoRepository, EstacionamentoRepository estacionamentoRepository) {
		Veiculo veiculo = veiculoRepository.findByMarca(marcaVeiculo);
		Estacionamento estacionamento = estacionamentoRepository.findByNome(nomeEstacionamento);
		return new EstacionamentoVeiculo(veiculo, estacionamento, dataEntrada, dataSaida, dataInicioPago, dataFimPago);
	}
	
	
	
	
	
	
	
	
	
	

}
