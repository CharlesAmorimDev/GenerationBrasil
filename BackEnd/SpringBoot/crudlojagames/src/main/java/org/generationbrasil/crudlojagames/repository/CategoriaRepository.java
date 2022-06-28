package org.generationbrasil.crudlojagames.repository;

import java.util.List;
import org.generationbrasil.crudlojagames.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	public List<Categoria> findAllByTituloContainingIgnoreCase(String titulo);
}
