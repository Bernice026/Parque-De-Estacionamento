package com.okayula.Parque_Estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.okayula.Parque_Estacionamento.modelo.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	List<Endereco> findByBairro(String bairro);

	
	
	

}
