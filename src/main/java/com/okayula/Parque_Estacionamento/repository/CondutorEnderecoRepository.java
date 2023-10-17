package com.okayula.Parque_Estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okayula.Parque_Estacionamento.modelo.CondutorEndereco;

public interface CondutorEnderecoRepository extends JpaRepository<CondutorEndereco, Long>{

	List<CondutorEndereco> findByCondutorNome(String nomeCondutor);
	
	
	

}
