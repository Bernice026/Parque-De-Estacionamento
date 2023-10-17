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

import com.okayula.Parque_Estacionamento.controller.actualizar_dto.Actualizar_CondutorDto;
import com.okayula.Parque_Estacionamento.controller.cadastro_dto.Cadastro_CondutorDto;
import com.okayula.Parque_Estacionamento.controller.detalhes_dto.DetalhesCondutorDto;
import com.okayula.Parque_Estacionamento.controller.dto.CondutorDto;
import com.okayula.Parque_Estacionamento.modelo.Condutor;
import com.okayula.Parque_Estacionamento.repository.CondutorRepository;


@RestController
@RequestMapping("/condutor")
public class CondutorController {
	
	
	@Autowired
	private CondutorRepository condutorRepository;
	
	@GetMapping
	public List<CondutorDto> listar(String nome){
		if (nome == null) {
			List<Condutor> condutor = condutorRepository.findAll();
			return CondutorDto.converter(condutor);	
		}else {
			List<Condutor> condutor = condutorRepository.findByNome(nome);
			return CondutorDto.converter(condutor);
		}
		
		
		
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<CondutorDto> cadastrar(@RequestBody @Valid Cadastro_CondutorDto cadastro, UriComponentsBuilder uriBuilder){
		Condutor condutor= cadastro.converter();
		condutorRepository.save(condutor);
		
		URI uri = uriBuilder.path("/condutor/{id}").buildAndExpand(condutor.getId()).toUri();
		return ResponseEntity.created(uri).body(new CondutorDto(condutor));		
		
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesCondutorDto> detalhar(@PathVariable Long id){
		Optional<Condutor> condutor = condutorRepository.findById(id);
		if (condutor.isPresent()) {
			return ResponseEntity.ok(new DetalhesCondutorDto(condutor.get()));	
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CondutorDto> actualizar(@PathVariable Long id, @RequestBody @Valid Actualizar_CondutorDto actualizar){
		Optional<Condutor> optional = condutorRepository.findById(id);
		if (optional.isPresent()) {
			Condutor condutor = actualizar.converter(id, condutorRepository);
			return ResponseEntity.ok(new CondutorDto(condutor));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id){
		Optional<Condutor> optional = condutorRepository.findById(id);
		if (optional.isPresent()) {
			condutorRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	

}
