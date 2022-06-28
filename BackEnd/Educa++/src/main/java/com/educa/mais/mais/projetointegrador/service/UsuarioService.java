package com.educa.mais.mais.projetointegrador.service;

import java.nio.charset.Charset;
import java.util.Optional;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.educa.mais.mais.projetointegrador.model.Usuario;
import com.educa.mais.mais.projetointegrador.model.UsuarioLogin;
import com.educa.mais.mais.projetointegrador.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> cadastrar(Usuario usuario){
		if (usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent()) {
			return Optional.empty();
		}
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		return Optional.of(usuarioRepository.save(usuario));
	}
	
	public Optional<Usuario> atualizar(Usuario usuario){
		if (usuarioRepository.findById(usuario.getId()).isPresent()) {
			usuario.setSenha(criptografarSenha(usuario.getSenha()));
			return Optional.of(usuarioRepository.save(usuario));
		}
		return Optional.empty();
	}

	public String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}
	
	public Optional<UsuarioLogin> autenticar(Optional<UsuarioLogin> usuarioLogin) {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario(usuarioLogin.get().getUsuario());
	
		if (usuario.isPresent()) {
			if (compararSenhas(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {
				usuarioLogin.get().setId(usuario.get().getId());
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setFoto(usuario.get().getFoto());
				usuarioLogin.get().setToken(gerarBasicToken(usuarioLogin.get().getUsuario(), usuarioLogin.get().getSenha()));
				usuarioLogin.get().setSenha(usuario.get().getSenha());
				usuarioLogin.get().setCelular(usuario.get().getTelefone());	
				usuarioLogin.get().setPronome(usuario.get().getPronome());
				return usuarioLogin;	
			}
		}
		return Optional.empty();
	}
	
	private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(senhaDigitada, senhaBanco);
	}
	
	private String gerarBasicToken(String usuario, String senha) {
		String token = usuario + ":" + senha;
		byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(tokenBase64);
	}
	
}