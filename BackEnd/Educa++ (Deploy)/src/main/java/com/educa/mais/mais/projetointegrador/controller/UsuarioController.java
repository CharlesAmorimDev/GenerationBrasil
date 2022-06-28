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

import com.educa.mais.mais.projetointegrador.model.DTO;
import com.educa.mais.mais.projetointegrador.model.Usuario;
import com.educa.mais.mais.projetointegrador.model.UsuarioLogin;
import com.educa.mais.mais.projetointegrador.repository.UsuarioRepository;
import com.educa.mais.mais.projetointegrador.service.UsuarioService;

@RestController
@RequestMapping ("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private UsuarioService service;

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
											 .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Usuario> getByUsuario(@PathVariable String email) {
		return repository.findByUsuario(email).map(resposta -> ResponseEntity.ok(resposta))
											  .orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	

	@PostMapping("/entrar")
	public ResponseEntity<UsuarioLogin> entrar(@RequestBody Optional<UsuarioLogin> user) {
		return service.autenticar(user).map(resposta -> ResponseEntity.ok(resposta))
									   .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario usuario) {
		return service.cadastrar(usuario).map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
										 .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@PostMapping("/role")
	public Usuario role(@RequestBody DTO dto) {
		return service.cadastrarRole(dto);
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
