package com.okayula.Parque_Estacionamento.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

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

import com.okayula.Parque_Estacionamento.controller.actualizar_dto.Actualizar_FormaPagamentoDto;
import com.okayula.Parque_Estacionamento.controller.cadastro_dto.Cadastro_FormaPagamentoDto;
import com.okayula.Parque_Estacionamento.controller.dto.FormaPagamentoDto;
import com.okayula.Parque_Estacionamento.modelo.FormaPagamento;
import com.okayula.Parque_Estacionamento.repository.FormaPagamentoRepository;


@RestController
@RequestMapping("/forma_pagamento")
public class FormaPagamentoController {
	
	
	@Autowired
	private FormaPagamentoRepository forma_pagamentoRepository;
	
	
	@GetMapping
	public List<FormaPagamentoDto> listar(String descricao){
		if (descricao == null) {
			List<FormaPagamento> forma_pagamento = forma_pagamentoRepository.findAll();
			return FormaPagamentoDto.converter(forma_pagamento);	
		}else {
			List<FormaPagamento> forma_pagamento = forma_pagamentoRepository.findByDescricao(descricao);
			return FormaPagamentoDto.converter(forma_pagamento);
		}
	}
	
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<FormaPagamentoDto> cadastrar(@RequestBody @Valid Cadastro_FormaPagamentoDto cadastro, UriComponentsBuilder uriBuilder){
		FormaPagamento formaPagamento= cadastro.converter();
		forma_pagamentoRepository.save(formaPagamento);
		
		URI uri = uriBuilder.path("/forma_pagamento/{id}").buildAndExpand(formaPagamento.getId()).toUri();
		return ResponseEntity.created(uri).body(new FormaPagamentoDto(formaPagamento));		
		
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<FormaPagamentoDto> detalhar(@PathVariable Long id){
		Optional<FormaPagamento> formaPagamento = forma_pagamentoRepository.findById(id);
		if (formaPagamento.isPresent()) {
			return ResponseEntity.ok(new FormaPagamentoDto(formaPagamento.get()));	
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FormaPagamentoDto> actualizar(@PathVariable Long id, @RequestBody @Valid Actualizar_FormaPagamentoDto actualizar){
		Optional<FormaPagamento> optional = forma_pagamentoRepository.findById(id);
		if (optional.isPresent()) {
			FormaPagamento formaPagamento = actualizar.converter(id, forma_pagamentoRepository);
			return ResponseEntity.ok(new FormaPagamentoDto(formaPagamento));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id){
		Optional<FormaPagamento> optional = forma_pagamentoRepository.findById(id);
		if (optional.isPresent()) {
			forma_pagamentoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}


}
