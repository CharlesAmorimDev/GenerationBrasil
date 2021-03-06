package org.generationbrasil.blogpessoal.repository;

import java.util.List;
import java.util.Optional;

import org.generationbrasil.blogpessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
				
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
	
	public Optional<Tema> findByTituloContainingIgnoreCase(String titulo);
}