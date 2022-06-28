package com.educa.mais.mais.projetointegrador.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educa.mais.mais.projetointegrador.model.Parceiro;
import com.educa.mais.mais.projetointegrador.model.Usuario;

@RestController
@RequestMapping ("/curso")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CursoController {

	private String nome;
	private Date dataNasc;
	private String foto;
	private String email;
	private String senha;
	private String role;
	private List<Usuario> usuario;
	private List<Parceiro> parceiro;
}
