package com.okayula.Parque_Estacionamento.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.okayula.Parque_Estacionamento.controller.actualizar_dto.Actualizar_Param_PagamentoDto;
import com.okayula.Parque_Estacionamento.controller.cadastro_dto.Cadastro_Parametrizacao_PagamentoDto;
import com.okayula.Parque_Estacionamento.controller.detalhes_dto.DetalhesParametrizacaoPagamentoDto;
import com.okayula.Parque_Estacionamento.controller.dto.ParametrizacaoPagamentoDto;
import com.okayula.Parque_Estacionamento.modelo.ParametrizacaoPagamento;
import com.okayula.Parque_Estacionamento.repository.FormaPagamentoRepository;
import com.okayula.Parque_Estacionamento.repository.ParametrizacaoPagamentoRepository;

@RestController
@RequestMapping("/para_pagamento")
public class ParametrizacaoPagamentoController {
	
	@Autowired
	private ParametrizacaoPagamentoRepository para_pg_Respository ;
	
	@Autowired
	private FormaPagamentoRepository formaPagamentoRespository ;
	
	@GetMapping
	public List<ParametrizacaoPagamentoDto> listar(String descricao_forma_pagamento){
		if (descricao_forma_pagamento == null) {
			List<ParametrizacaoPagamento> para_pagamento = para_pg_Respository.findAll();
			return ParametrizacaoPagamentoDto.converter(para_pagamento);	
		}else {
			List<ParametrizacaoPagamento> para_pagamento = para_pg_Respository.findByFormaPagamentoDescricao(descricao_forma_pagamento);
			return ParametrizacaoPagamentoDto.converter(para_pagamento);
		}
	}
	
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<ParametrizacaoPagamentoDto> cadastrar(@RequestBody Cadastro_Parametrizacao_PagamentoDto cadastro, UriComponentsBuilder uriBuilder){
		ParametrizacaoPagamento param_Pagamento= cadastro.converter(formaPagamentoRespository);
		para_pg_Respository.save(param_Pagamento);
		
		URI uri = uriBuilder.path("/para_pagamento/{id}").buildAndExpand(param_Pagamento.getId()).toUri();
		return ResponseEntity.created(uri).body(new ParametrizacaoPagamentoDto(param_Pagamento));		
		
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesParametrizacaoPagamentoDto> detalhar(@PathVariable Long id){
		Optional<ParametrizacaoPagamento> formaPagamento = para_pg_Respository.findById(id);
		if (formaPagamento.isPresent()) {
			return ResponseEntity.ok(new DetalhesParametrizacaoPagamentoDto(formaPagamento.get()));	
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ParametrizacaoPagamentoDto> actualizar(@PathVariable Long id, @RequestBody  Actualizar_Param_PagamentoDto actualizar){
		Optional<ParametrizacaoPagamento> optional = para_pg_Respository.findById(id);
		if (optional.isPresent()) {
			ParametrizacaoPagamento param_Pagamento = actualizar.converter(id, para_pg_Respository);
			return ResponseEntity.ok(new ParametrizacaoPagamentoDto(param_Pagamento));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id){
		Optional<ParametrizacaoPagamento> optional = para_pg_Respository.findById(id);
		if (optional.isPresent()) {
			para_pg_Respository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}


}
