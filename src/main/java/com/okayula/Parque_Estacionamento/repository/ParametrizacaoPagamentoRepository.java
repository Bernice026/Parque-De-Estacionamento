package com.okayula.Parque_Estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okayula.Parque_Estacionamento.modelo.ParametrizacaoPagamento;

public interface ParametrizacaoPagamentoRepository extends JpaRepository<ParametrizacaoPagamento, Long>{

	List<ParametrizacaoPagamento> findByFormaPagamentoDescricao(String descricao_forma_pagamento);

	

}
