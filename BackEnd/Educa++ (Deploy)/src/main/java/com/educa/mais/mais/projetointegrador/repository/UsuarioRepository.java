package com.educa.mais.mais.projetointegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.educa.mais.mais.projetointegrador.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Usuario findByUsuario(String usuario);
	
	@Query("SELECT u from Usuario u JOIN FETCH u.roles where u.usuario = : usuario")
	public Usuario findByRole(@Param("usuario") String usuario);

}
