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

import com.okayula.Parque_Estacionamento.controller.actualizar_dto.Actualizar_CondutorEnderecoDto;
import com.okayula.Parque_Estacionamento.controller.cadastro_dto.Cadastro_CondutorEndereco_Dto;
import com.okayula.Parque_Estacionamento.controller.dto.CondutorEnderecoDto;
import com.okayula.Parque_Estacionamento.modelo.CondutorEndereco;
import com.okayula.Parque_Estacionamento.repository.CondutorEnderecoRepository;
import com.okayula.Parque_Estacionamento.repository.CondutorRepository;
import com.okayula.Parque_Estacionamento.repository.EnderecoRepository;

@RestController
@RequestMapping("/condutor_endereco")
public class CondutorEnderecoController {
	
	@Autowired
	private CondutorEnderecoRepository condutor_enderecoRespository ;
	
	@Autowired
	private CondutorRepository condutorRespository ;
	
	@Autowired
	private EnderecoRepository enderecoRespository ;
	
	
	
	@GetMapping
	public List<CondutorEnderecoDto> listar(String nomeCondutor){
		if (nomeCondutor == null) {
			List<CondutorEndereco> condutor_endereco = condutor_enderecoRespository.findAll();
			return CondutorEnderecoDto.converter(condutor_endereco);	
		}else {
			List<CondutorEndereco> condutor_endereco = condutor_enderecoRespository.findByCondutorNome(nomeCondutor);
			return CondutorEnderecoDto.converter(condutor_endereco);
		}
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<CondutorEnderecoDto> cadastrar(@RequestBody  Cadastro_CondutorEndereco_Dto cadastro, UriComponentsBuilder uriBuilder){
		CondutorEndereco condutor_endereco = cadastro.converter(condutorRespository, enderecoRespository);
		condutor_enderecoRespository.save(condutor_endereco);
		
		URI uri = uriBuilder.path("/condutor_endereco/{id}").buildAndExpand(condutor_endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(new CondutorEnderecoDto(condutor_endereco));		
		
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<CondutorEnderecoDto> detalhar(@PathVariable Long id){
		Optional<CondutorEndereco> condutor_endereco = condutor_enderecoRespository.findById(id);
		if (condutor_endereco.isPresent()) {
			return ResponseEntity.ok(new CondutorEnderecoDto(condutor_endereco.get()));	
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CondutorEnderecoDto> actualizar(@PathVariable Long id, @RequestBody Actualizar_CondutorEnderecoDto actualizar){
		Optional<CondutorEndereco> optional = condutor_enderecoRespository.findById(id);
		if (optional.isPresent()) {
			CondutorEndereco condutor_endereco = actualizar.converter(id, condutor_enderecoRespository);
			return ResponseEntity.ok(new CondutorEnderecoDto(condutor_endereco));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id){
		Optional<CondutorEndereco> optional = condutor_enderecoRespository.findById(id);
		if (optional.isPresent()) {
			condutor_enderecoRespository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	

}
