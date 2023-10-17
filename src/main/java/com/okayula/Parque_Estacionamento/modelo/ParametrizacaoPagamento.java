package com.okayula.Parque_Estacionamento.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class ParametrizacaoPagamento {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate data;
	private BigDecimal valorPorHora;
	
	@ManyToOne
	private FormaPagamento formaPagamento;
	
	@Enumerated(EnumType.STRING)
	private PeriodoEstacionamento periodoEstacionamento = PeriodoEstacionamento.POR_HORA;
	
	@OneToMany(mappedBy = "parametrizacao")
	private List<EstacionamentoVeiculo> estacionamentoVeiculo = new ArrayList<>();
	
	
	
	

	public ParametrizacaoPagamento() {
		
	}

	
	
	
	public ParametrizacaoPagamento(LocalDate data, BigDecimal valorPorHora, FormaPagamento formaPagamento,
			PeriodoEstacionamento periodoEstacionamento) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.formaPagamento = formaPagamento;
		this.periodoEstacionamento = periodoEstacionamento;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(BigDecimal valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public PeriodoEstacionamento getPeriodoEstacionamento() {
		return periodoEstacionamento;
	}

	public void setPeriodoEstacionamento(PeriodoEstacionamento periodoEstacionamento) {
		this.periodoEstacionamento = periodoEstacionamento;
	}

	public List<EstacionamentoVeiculo> getEstacionamentoVeiculo() {
		return estacionamentoVeiculo;
	}

	public void setEstacionamentoVeiculo(List<EstacionamentoVeiculo> estacionamentoVeiculo) {
		this.estacionamentoVeiculo = estacionamentoVeiculo;
	}
	
	
	
	
	
	
	
	

}
