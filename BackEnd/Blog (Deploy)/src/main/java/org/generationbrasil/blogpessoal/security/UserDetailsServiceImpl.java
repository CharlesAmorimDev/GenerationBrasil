package org.generationbrasil.blogpessoal.security;

import java.util.Optional;

import org.generationbrasil.blogpessoal.model.Usuario;
import org.generationbrasil.blogpessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByEmail(userName);
		usuario.orElseThrow(() -> new UsernameNotFoundException(userName + "Not Found."));
		return usuario.map(UserDetailsImpl::new).get();
	}
}
