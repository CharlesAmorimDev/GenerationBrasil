package org.generationbrasil.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

import org.generationbrasil.blogpessoal.model.Postagem;
import org.generationbrasil.blogpessoal.model.Usuario;
import org.generationbrasil.blogpessoal.repository.PostagemRepository;
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
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

	@Autowired
	private PostagemRepository repositoryPostagem;
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getById(@PathVariable Long id) {
		return repositoryPostagem.findById(id).map(resposta -> ResponseEntity.ok(resposta))
									  .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repositoryPostagem.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@GetMapping("/usuario/{email}")
	public ResponseEntity<List<Postagem>> getByUsuario(@PathVariable Optional<Usuario> email) {
		Long id = email.get().getId();
		if(id > 0) {
			return ResponseEntity.ok(repositoryPostagem.findAllById(id));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Postagem>> getAll(){
		return ResponseEntity.ok(repositoryPostagem.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryPostagem.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repositoryPostagem.save(postagem));
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		repositoryPostagem.deleteById(id);
	}
}