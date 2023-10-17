package com.okayula.Parque_Estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.okayula.Parque_Estacionamento.modelo.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long>{
	
	
	@Query ("SELECT t FROM FormaPagamento t WHERE t.descricao = :descricao_formaPagamento")
	FormaPagamento carregarPelaDescricao(@Param("descricao_formaPagamento")String descricao_formaPagamento);

	
	List<FormaPagamento> findByDescricao(String descricao);
	

}
