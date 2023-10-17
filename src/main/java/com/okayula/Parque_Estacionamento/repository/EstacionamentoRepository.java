package com.okayula.Parque_Estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okayula.Parque_Estacionamento.modelo.Estacionamento;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long>{

	Estacionamento findByNome(String nomeEstacionamento);

	List<Estacionamento> findByEnderecoBairro(String bairroEndereco);
	
	
	

}
