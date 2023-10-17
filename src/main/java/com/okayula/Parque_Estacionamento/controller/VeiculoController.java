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

import com.okayula.Parque_Estacionamento.controller.actualizar_dto.Actualizar_VeiculoDto;
import com.okayula.Parque_Estacionamento.controller.cadastro_dto.Cadastro_VeiculoDto;
import com.okayula.Parque_Estacionamento.controller.detalhes_dto.DetalhesVeiculoDto;
import com.okayula.Parque_Estacionamento.controller.dto.VeiculoDto;
import com.okayula.Parque_Estacionamento.modelo.Veiculo;
import com.okayula.Parque_Estacionamento.repository.CondutorRepository;
import com.okayula.Parque_Estacionamento.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private CondutorRepository condutorRepository;
	
	
	@GetMapping
	public List<VeiculoDto> listar(String nomeCondutor){
		if (nomeCondutor == null) {
			List<Veiculo> veiculo = veiculoRepository.findAll();
			return VeiculoDto.converter(veiculo);	
		}else {
			List<Veiculo> veiculo = veiculoRepository.findByCondutorNome(nomeCondutor);
			return VeiculoDto.converter(veiculo);	
		}
	}
	
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<VeiculoDto> cadastrar(@RequestBody @Valid Cadastro_VeiculoDto cadastro, UriComponentsBuilder uriBuilder){
		Veiculo veiculo = cadastro.converter(condutorRepository);
		veiculoRepository.save(veiculo);
		
		URI uri = uriBuilder.path("/veiculos/{id}").buildAndExpand(veiculo.getId()).toUri();
		return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));		
		
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesVeiculoDto> detalhar(@PathVariable Long id){
		Optional<Veiculo> veiculo = veiculoRepository.findById(id);
		if (veiculo.isPresent()) {
			return ResponseEntity.ok(new DetalhesVeiculoDto(veiculo.get()));	
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VeiculoDto> actualizar(@PathVariable Long id, @RequestBody @Valid Actualizar_VeiculoDto actualizar){
		Optional<Veiculo> optional = veiculoRepository.findById(id);
		if (optional.isPresent()) {
			Veiculo veiculo= actualizar.converter(id, veiculoRepository);
			return ResponseEntity.ok(new VeiculoDto(veiculo));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id){
		Optional<Veiculo> optional = veiculoRepository.findById(id);
		if (optional.isPresent()) {
			veiculoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	

}
