package org.generationbrasil.blogpessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.generationbrasil.blogpessoal.model.Usuario;
import org.generationbrasil.blogpessoal.service.UsuarioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioControllerTest {
	
	@Autowired
	private UsuarioService service;
	@Autowired
	private TestRestTemplate template;
	
	@Test
	@DisplayName("Teste - Criar Usuário")
	@Order(1)
	public void testeCriarUsuario() {
		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(new Usuario(0L, "Paulo Antunes", "paulo@email.com", "147258369"));
		ResponseEntity<Usuario> resposta = template.exchange("/usuarios/cadastrar", HttpMethod.POST, requisicao, Usuario.class);
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		assertEquals(requisicao.getBody().getNome(), resposta.getBody().getNome());
		assertEquals(requisicao.getBody().getEmail(), resposta.getBody().getEmail());
	}

	@Test
	@DisplayName("Teste - Não permitir duplicar Usuários")
	@Order(2)
	public void testeDuplicarUsuario() {
		service.cadastrarUsuario(new Usuario(0L,"Diogo Freitas", "diogo@email.com", "369852147"));
		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(new Usuario(0L, "Diogo Freitas", "diogo@email.com", "369852147"));
		ResponseEntity<Usuario> resposta = template.exchange("/usuarios/cadastrar", HttpMethod.POST, requisicao, Usuario.class);
		assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
	}
	
	@Test
	@DisplayName("Teste - Atualizar Usuário")
	@Order(3)
	public void testeAtualizarUsuario() {
		Optional<Usuario> usuario = service.cadastrarUsuario(new Usuario(0L, "Chave da Vila", "chaves@email.com", "chaves0808"));
		Usuario atualizado = new Usuario(usuario.get().getId(),"Chaves do Barril", "chaves2.0@email.com", "chavao2.0.9");
		HttpEntity<Usuario> requisicao = new HttpEntity<Usuario>(atualizado);
		ResponseEntity<Usuario> resposta = template.withBasicAuth("root", "root").exchange("/usuarios/atualizar", HttpMethod.PUT, requisicao, Usuario.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals(requisicao.getBody().getNome(), resposta.getBody().getNome());
		assertEquals(requisicao.getBody().getEmail(), resposta.getBody().getEmail());
	}
	
	@Test
	@DisplayName("Teste - GetAll")
	@Order(4)
	public void testeGetAll() {
		service.cadastrarUsuario(new Usuario(0L,"Usuario Teste 1", "teste1@email.com", "senhateste1"));
		service.cadastrarUsuario(new Usuario(0L,"Usuario teste 2", "teste2@email.com", "senhateste2"));
		ResponseEntity<Usuario> resposta = template.withBasicAuth("root", "root").exchange("/usuarios/all", HttpMethod.GET, null, Usuario.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
}
