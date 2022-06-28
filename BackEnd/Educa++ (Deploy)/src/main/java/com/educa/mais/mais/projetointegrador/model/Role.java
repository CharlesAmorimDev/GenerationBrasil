package com.educa.mais.mais.projetointegrador.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "role")
public class Role {
	
	public Role(Long id) {
		super();
		this.id = id;
	}
	
	public Role() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String nome;
	
	@ManyToMany
	@JsonIgnoreProperties("role")
	private List<Usuario> usuario;
	
	public Long getId() {
		return id;
	}
	public List<Usuario> getUsuarios() {
		return usuario;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuario = usuarios;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}