package com.educa.mais.mais.projetointegrador.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.educa.mais.mais.projetointegrador.model.Curso;
import com.educa.mais.mais.projetointegrador.model.Parceiro;
import com.educa.mais.mais.projetointegrador.model.ParceiroLogin;
import com.educa.mais.mais.projetointegrador.repository.CursoRepository;
import com.educa.mais.mais.projetointegrador.repository.ParceiroRepository;

@RestController
@RequestMapping("/parceiros")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ParceiroController {
	
	@Autowired
	private ParceiroRepository parceiroRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Parceiro> getById(@PathVariable long id) {
		return parceiroRepository.findById (id).map(resposta -> ResponseEntity.ok(resposta))
									   		   .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Parceiro> getByEmail(@PathVariable String email) {
		return parceiroRepository.findByEmail(email).map(resposta -> ResponseEntity.ok(resposta))
													.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Parceiro>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(parceiroRepository.findByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/cnpj/{cnpj}")
	public ResponseEntity<Parceiro> getByCnpj(@PathVariable String Cnpj) {
		return parceiroRepository.findByCnpj(Cnpj).map(resposta -> ResponseEntity.ok(resposta))
												  .orElse(ResponseEntity.notFound().build());
	}
	

	
	@GetMapping("/all")
	public ResponseEntity<List<Parceiro>> getAll() {
		return ResponseEntity.ok(parceiroRepository.findAll());
	}
	



	
	@PutMapping("/atualizar")
	public ResponseEntity<Parceiro> atualizar(@Valid @RequestBody Parceiro parceiro) {
		return ResponseEntity.status(HttpStatus.OK).body(parceiroRepository.save(parceiro));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		parceiroRepository.deleteById(id);
	}
}
