package com.educa.mais.mais.projetointegrador.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.educa.mais.mais.projetointegrador.model.Usuario;

public class UserDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;	
	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Usuario usuario) {
		this.userName = usuario.getUsuario();
		this.password = usuario.getSenha();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		authorities = usuario.getRoles().stream().map(resposta -> {
			return new SimpleGrantedAuthority("ROLE_".concat(resposta.getNome()));
		}).collect(Collectors.toList());
				
		this.authorities = authorities;
	}
	
	public static UserDetailsImpl create(Usuario usuario) {
		return new UserDetailsImpl(usuario);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
