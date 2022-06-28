package org.generationbrasil.crudlojagames.repository;

import java.util.List;
import org.generationbrasil.crudlojagames.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
}