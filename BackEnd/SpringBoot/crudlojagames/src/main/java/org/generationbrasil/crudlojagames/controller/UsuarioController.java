package org.generationbrasil.crudlojagames.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generationbrasil.crudlojagames.model.Usuario;
import org.generationbrasil.crudlojagames.model.UsuarioLogin;
import org.generationbrasil.crudlojagames.repository.UsuarioRepository;
import org.generationbrasil.crudlojagames.service.UsuarioService;
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
	private UsuarioRepository repository;
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@Valid @PathVariable Long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/usuario/{usuario}")
	public ResponseEntity<Optional<Usuario>> getByUsuario(@Valid @PathVariable String usuario) {
		return ResponseEntity.ok(repository.findByUsuario(usuario));
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario usuario) {
		return service.cadastrarUsuario(usuario).map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
												.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@PostMapping("/autenticar")
	public ResponseEntity<UsuarioLogin> autenticar(@Valid @RequestBody Optional<UsuarioLogin> usuario) {
		return service.autenticarUsuario(usuario).map(resposta -> ResponseEntity.ok(resposta))
												 .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario usuario) {
		return service.atualizarUsuario(usuario).map(resposta -> ResponseEntity.ok(resposta))
												.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@DeleteMapping("/{id}")
	public void delete(@Valid @PathVariable Long id) {
		repository.deleteById(id);
	}
}
