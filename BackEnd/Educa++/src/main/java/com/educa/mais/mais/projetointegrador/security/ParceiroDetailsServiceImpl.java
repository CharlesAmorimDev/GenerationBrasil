package com.educa.mais.mais.projetointegrador.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.educa.mais.mais.projetointegrador.model.Parceiro;
import com.educa.mais.mais.projetointegrador.repository.ParceiroRepository;



@Service
public class ParceiroDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private ParceiroRepository parceiroRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		Optional<Parceiro> parceiro = parceiroRepository.findByEmail(userName);
		parceiro.orElseThrow(() -> new UsernameNotFoundException(userName + "Not found"));
	return parceiro.map(ParceiroDetailsImpl::new).get();
	}
}
