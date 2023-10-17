package com.okayula.Parque_Estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okayula.Parque_Estacionamento.modelo.EstacionamentoVeiculo;

public interface EstacionamentoVeiculoRepository extends JpaRepository<EstacionamentoVeiculo, Long> {

	List<EstacionamentoVeiculo> findByDataEntrada(String dataEntrada);
	
	

}
