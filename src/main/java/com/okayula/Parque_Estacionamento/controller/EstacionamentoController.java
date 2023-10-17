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

import com.okayula.Parque_Estacionamento.controller.actualizar_dto.ActualizarEstacionamentoDto;
import com.okayula.Parque_Estacionamento.controller.cadastro_dto.CadastroEstacionamentoDto;
import com.okayula.Parque_Estacionamento.controller.detalhes_dto.DetalhesEstacionamentoDto;
import com.okayula.Parque_Estacionamento.controller.dto.EstacionamentoDto;

import com.okayula.Parque_Estacionamento.modelo.Estacionamento;
//import com.okayula.Parque_Estacionamento.repository.EnderecoRepository;
import com.okayula.Parque_Estacionamento.repository.EstacionamentoRepository;



@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {
	
	@Autowired
	private EstacionamentoRepository estacionamentoRepository;
	
	//@Autowired
	//private EnderecoRepository enderecoRepository;
	
	
	
	@GetMapping
	public List<EstacionamentoDto> listar(String bairroEndereco){
		if (bairroEndereco == null) {
			List<Estacionamento> estacionamento = estacionamentoRepository.findAll();
			return EstacionamentoDto.converter(estacionamento);	
		}else {
			List<Estacionamento> estacionamento = estacionamentoRepository.findByEnderecoBairro(bairroEndereco);
			return EstacionamentoDto.converter(estacionamento);	
		}
	}

	
	
	@PostMapping
	@Transactional
	public ResponseEntity<EstacionamentoDto> cadastrar(@RequestBody @Valid CadastroEstacionamentoDto cadastrar, UriComponentsBuilder uriBuilder){
		Estacionamento estacionamento = cadastrar.converter();
		estacionamentoRepository.save(estacionamento);
		
		URI uri= uriBuilder.path("/estacionamento/{id}").buildAndExpand(estacionamento.getId()).toUri();
		return ResponseEntity.created(uri).body(new EstacionamentoDto(estacionamento));
	}
	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesEstacionamentoDto> detalhar(@PathVariable Long id){
		Optional<Estacionamento> estacionamento= estacionamentoRepository.findById(id);
		if (estacionamento.isPresent()) {
			return ResponseEntity.ok(new DetalhesEstacionamentoDto(estacionamento.get()));	
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EstacionamentoDto> actualizar(@PathVariable Long id, @RequestBody @Valid ActualizarEstacionamentoDto actualiza){
		Optional<Estacionamento> Optional= estacionamentoRepository.findById(id);
		if (Optional.isPresent()) {
			Estacionamento estacionamentoNovo = actualiza.converter(id, estacionamentoRepository);
			return ResponseEntity.ok(new EstacionamentoDto(estacionamentoNovo));
			
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id){
		Optional<Estacionamento> Optional= estacionamentoRepository.findById(id);
		if (Optional.isPresent()) {
			estacionamentoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
}
