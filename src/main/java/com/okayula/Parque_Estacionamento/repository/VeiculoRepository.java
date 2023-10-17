package com.okayula.Parque_Estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.okayula.Parque_Estacionamento.modelo.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	Veiculo findByMarca(String marcaVeiculo);
	
	List<Veiculo> findByCondutorNome(String nomeCondutor);


	

}
