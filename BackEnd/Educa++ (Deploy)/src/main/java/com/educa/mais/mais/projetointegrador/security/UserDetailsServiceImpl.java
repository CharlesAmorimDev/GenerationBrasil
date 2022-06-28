package com.educa.mais.mais.projetointegrador.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.educa.mais.mais.projetointegrador.model.Usuario;
import com.educa.mais.mais.projetointegrador.repository.UsuarioRepository;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		Usuario usuario = repository.findByUsuario(userName);
		
		if(usuario != null) {
			throw new Error("Usuário não Localizado");
		}
		
		return UserDetailsImpl.create(usuario);
	}
}
