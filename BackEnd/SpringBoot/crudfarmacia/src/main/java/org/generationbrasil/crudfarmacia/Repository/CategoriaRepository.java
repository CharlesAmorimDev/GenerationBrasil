package org.generationbrasil.crudfarmacia.Repository;

import java.util.List;

import org.generationbrasil.crudfarmacia.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	public List<Categoria> findAllByTituloContainingIgnoreCase(String titulo);
}
