package com.educa.mais.mais.projetointegrador.model;

import java.util.List;

public class DTO {

	private Long idUsuario;
	private List<Long> idRoles;
	
	
	
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public List<Long> getIdRoles() {
		return idRoles;
	}
	public void setIdRoles(List<Long> idRoles) {
		this.idRoles = idRoles;
	}

}
