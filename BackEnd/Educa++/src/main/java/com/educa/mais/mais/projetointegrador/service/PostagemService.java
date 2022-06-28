package com.educa.mais.mais.projetointegrador.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educa.mais.mais.projetointegrador.model.Postagem;
import com.educa.mais.mais.projetointegrador.repository.PostagemRepository;

@Service
public class PostagemService {

	@Autowired
	PostagemRepository repository;
	
	public Optional<Postagem> cadastrar(Postagem postagem) {
		if(repository.findById(postagem.getId()).isPresent())
			return Optional.empty();
		return Optional.of(repository.save(postagem));
	}
	
	public Optional<Postagem> atualizar(Postagem postagem) {
		if(repository.findById(postagem.getId()).isPresent())
			return Optional.of(repository.save(postagem));
		return Optional.empty();
	}
}
