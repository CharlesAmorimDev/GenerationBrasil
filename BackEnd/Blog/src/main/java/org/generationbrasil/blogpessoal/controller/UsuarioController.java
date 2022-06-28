package org.generationbrasil.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generationbrasil.blogpessoal.model.Usuario;
import org.generationbrasil.blogpessoal.model.UsuarioLogin;
import org.generationbrasil.blogpessoal.repository.UsuarioRepository;
import org.generationbrasil.blogpessoal.service.UsuarioService;
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

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario usuario) {
		return service.cadastrarUsuario(usuario).map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
												.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());	
	}
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> entrar(@Valid @RequestBody Optional<UsuarioLogin> usuario) {
		return service.autenticarUsuario(usuario).map(resposta -> ResponseEntity.ok(resposta))
												 .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
