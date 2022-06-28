package org.generationbrasil.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.generationbrasil.blogpessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository repository;
	
	@BeforeAll
	public void start() {
		repository.save(new Usuario(0L, "João Silva", "joao@email.com", "123456789"));
		repository.save(new Usuario(0L, "Maria Silva", "maria@email.com", "987654321"));
		repository.save(new Usuario(0L, "Mario Silva", "mario@email.com", "123456789"));
		//repository.save(new Usuario(0L, "Carlos Gomes", "carlos@email.com", "987654321"));
	}
	
	@Test
	@DisplayName("Teste - Retorna 1 Usuário")
	public void retornarUmUsuario() {
		Optional<Usuario> usuario = repository.findByUsuario("mario@email.com");
		assertTrue(usuario.get().getUsuario().equals("mario@email.com"));
	}
	
	@Test
	@DisplayName("Teste - Retorna 3 Usuários que contenham 'silva'")
	public void retornarTresUsuarios() {
		List<Usuario> usuarios = repository.findAllByNomeContainingIgnoreCase("silva");
		assertEquals(3, usuarios.size());
		assertTrue(usuarios.get(1).getNome().equals("João Silva"));
		assertTrue(usuarios.get(2).getNome().equals("Maria Silva"));
		assertTrue(usuarios.get(3).getNome().equals("Mario Silva"));
	}
}
