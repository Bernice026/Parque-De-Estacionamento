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

import com.okayula.Parque_Estacionamento.controller.actualizar_dto.Actualizar_Estacionamento_VeiculoDto;
import com.okayula.Parque_Estacionamento.controller.cadastro_dto.Cadastro_Estacionamento_VeiculoDto;
import com.okayula.Parque_Estacionamento.controller.detalhes_dto.DetalhesEstacionamentoVeiculoDto;
import com.okayula.Parque_Estacionamento.controller.dto.EstacionamentoVeiculoDto;
import com.okayula.Parque_Estacionamento.modelo.EstacionamentoVeiculo;
import com.okayula.Parque_Estacionamento.repository.EstacionamentoRepository;
import com.okayula.Parque_Estacionamento.repository.EstacionamentoVeiculoRepository;
import com.okayula.Parque_Estacionamento.repository.VeiculoRepository;

@RestController
@RequestMapping("/estacionamento_veiculo")
public class EstacionamentoVeiculoController {
	
	

	@Autowired
	private EstacionamentoVeiculoRepository esta_veiculoRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private EstacionamentoRepository estaRepository;
	
	@GetMapping
	public List<EstacionamentoVeiculoDto> listar(String dataEntrada){
		if (dataEntrada == null) {
			List<EstacionamentoVeiculo> esta_veiculo = esta_veiculoRepository.findAll();
			return EstacionamentoVeiculoDto.converter(esta_veiculo);	
		}else {
			List<EstacionamentoVeiculo> esta_veiculo = esta_veiculoRepository.findByDataEntrada(dataEntrada);
			return EstacionamentoVeiculoDto.converter(esta_veiculo);
		}
	}
	
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<EstacionamentoVeiculoDto> cadastrar(@RequestBody @Valid Cadastro_Estacionamento_VeiculoDto cadastro, UriComponentsBuilder uriBuilder){
		EstacionamentoVeiculo esta_veiculo = cadastro.converter(veiculoRepository, estaRepository);
		esta_veiculoRepository.save(esta_veiculo);
		
		URI uri = uriBuilder.path("/estacionamento_veiculo/{id}").buildAndExpand(esta_veiculo.getId()).toUri();
		return ResponseEntity.created(uri).body(new EstacionamentoVeiculoDto(esta_veiculo));		
		
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesEstacionamentoVeiculoDto> detalhar(@PathVariable Long id){
		Optional<EstacionamentoVeiculo> esta_veiculo = esta_veiculoRepository.findById(id);
		if (esta_veiculo.isPresent()) {
			return ResponseEntity.ok(new DetalhesEstacionamentoVeiculoDto(esta_veiculo.get()));
			
		}
		
		return ResponseEntity.notFound().build();
	
	}
	
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EstacionamentoVeiculoDto> actualizar(@PathVariable Long id, @RequestBody @Valid Actualizar_Estacionamento_VeiculoDto actualizar){
		Optional<EstacionamentoVeiculo> optional = esta_veiculoRepository.findById(id);
		
		if (optional.isPresent()) {
			EstacionamentoVeiculo esta_veiculo= actualizar.converter(id, esta_veiculoRepository);
			return ResponseEntity.ok(new EstacionamentoVeiculoDto(esta_veiculo));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id){
		Optional<EstacionamentoVeiculo> optional = esta_veiculoRepository.findById(id);
		if (optional.isPresent()) {
			esta_veiculoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	

}
