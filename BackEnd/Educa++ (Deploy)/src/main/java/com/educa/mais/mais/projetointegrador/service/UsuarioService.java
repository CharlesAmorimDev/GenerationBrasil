package com.educa.mais.mais.projetointegrador.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.educa.mais.mais.projetointegrador.model.DTO;
import com.educa.mais.mais.projetointegrador.model.Role;
import com.educa.mais.mais.projetointegrador.model.Usuario;
import com.educa.mais.mais.projetointegrador.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario cadastrarRole(DTO dto) {
		Optional<Usuario> usuario = repository.findById(dto.getIdUsuario());
		List<Role> roles = new ArrayList<>();
		
		if(usuario.isEmpty()) {
			throw new Error("Usuário não Localizado");
		}
		
		roles = dto.getIdRoles().stream().map(resposta -> {
			return new Role(resposta);
		}).collect(Collectors.toList());
		
		Usuario salvarUsuario = usuario.get();
		salvarUsuario.setRoles(roles);
		repository.save(salvarUsuario);
		return salvarUsuario;
	}
	
	public Usuario cadastrar(Usuario usuario){
		Usuario usuario2 = repository.findByUsuario(usuario.getUsuario());
		
		if(usuario2 != null) {
			throw new Error("Usuário não Localizado");
		}
		return repository.save(usuario);
	}
	
	public Optional<Usuario> atualizar(Usuario usuario){
		if (repository.findById(usuario.getId()).isPresent()) {
			usuario.setSenha(criptografarSenha(usuario.getSenha()));
			return Optional.of(repository.save(usuario));
		}
		return Optional.empty();
	}

	public String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}
	
}
