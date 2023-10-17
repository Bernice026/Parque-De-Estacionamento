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

import com.okayula.Parque_Estacionamento.controller.actualizar_dto.Actualizar_EnderecoDto;
import com.okayula.Parque_Estacionamento.controller.cadastro_dto.Cadastro_EnderecoDto;
import com.okayula.Parque_Estacionamento.controller.detalhes_dto.DetalhesEnderecoDto;
import com.okayula.Parque_Estacionamento.controller.dto.EnderecoDto;
import com.okayula.Parque_Estacionamento.modelo.Endereco;
import com.okayula.Parque_Estacionamento.repository.EnderecoRepository;


@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping
	public List<EnderecoDto> listar(String bairro){
		if (bairro == null) {
			List<Endereco> endereco = enderecoRepository.findAll();
			return EnderecoDto.converter(endereco);	
		}else {
			List<Endereco> endereco = enderecoRepository.findByBairro(bairro);
			return EnderecoDto.converter(endereco);	
		}
		
	}
	
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<EnderecoDto> cadastrar(@RequestBody @Valid Cadastro_EnderecoDto cadastro, UriComponentsBuilder uriBuilder){
		Endereco endereco = cadastro.converter();
		enderecoRepository.save(endereco);
		
		URI uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDto(endereco));		
		
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesEnderecoDto> detalhar(@PathVariable Long id){
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		if (endereco.isPresent()) {
			return ResponseEntity.ok(new DetalhesEnderecoDto(endereco.get()));	
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EnderecoDto> actualizar(@PathVariable Long id, @RequestBody @Valid Actualizar_EnderecoDto actualizar){
		Optional<Endereco> optional = enderecoRepository.findById(id);
		if (optional.isPresent()) {
			Endereco endereco = actualizar.converter(id, enderecoRepository);
			return ResponseEntity.ok(new EnderecoDto(endereco));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id){
		Optional<Endereco> optional = enderecoRepository.findById(id);
		if (optional.isPresent()) {
			enderecoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	

}
