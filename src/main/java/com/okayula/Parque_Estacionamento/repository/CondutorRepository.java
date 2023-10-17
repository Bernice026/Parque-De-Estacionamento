package com.okayula.Parque_Estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.okayula.Parque_Estacionamento.modelo.Condutor;

public interface CondutorRepository extends JpaRepository<Condutor, Long>{

	@Query ("SELECT t FROM Condutor t WHERE t.nome = :nomeCondutor")
	Condutor CarregarNomeCondutor (@Param("nomeCondutor") String nomeCondutor);
	
	List<Condutor> findByNome(String nome);

	

}
