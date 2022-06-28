package org.generationbrasil.crudlojagames.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.generationbrasil.crudlojagames.model.Usuario;
import org.generationbrasil.crudlojagames.model.UsuarioLogin;
import org.generationbrasil.crudlojagames.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	BCryptPasswordEncoder criptografar = new BCryptPasswordEncoder();
	
	private String criptografarSenha(String senha) {
		return criptografar.encode(senha);
	}
	
	private String gerarBasicToken(String usuario, String senha) {
		String token = usuario + ":" + senha;
		byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(tokenBase64);
	}
	
  	public Optional<Usuario> cadastrarUsuario(Usuario usuario) {
		if(repository.findByUsuario(usuario.getUsuario()).isPresent())
			return Optional.empty();
		
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		return Optional.of(repository.save(usuario));
	}
	
	public Optional<Usuario> atualizarUsuario(Usuario usuario) {
		
		if(repository.findById(usuario.getId()).isPresent()) {
			usuario.setSenha(criptografarSenha(usuario.getSenha()));
			return Optional.of(repository.save(usuario));
		}
		return Optional.empty();
	}
	
	public Optional<UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> usuario) {
		if(repository.findById(usuario.get().getId()).isPresent()) {
			Optional<Usuario> usuarioDoBanco = repository.findByUsuario(usuario.get().getUsuario());
			
			if(criptografar.matches(usuario.get().getSenha(), usuarioDoBanco.get().getSenha())) {
				usuario.get().setId(usuarioDoBanco.get().getId());
				usuario.get().setNome(usuarioDoBanco.get().getNome());
				usuario.get().setSenha(usuarioDoBanco.get().getSenha());
				usuario.get().setToken(gerarBasicToken(usuario.get().getUsuario(), usuario.get().getSenha()));
				return usuario;
			}
		}
		return Optional.empty();
	}
}
