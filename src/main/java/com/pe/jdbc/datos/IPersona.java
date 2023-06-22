package com.pe.jdbc.datos;

import java.util.List;

import com.pe.jdbc.domain.PersonaDTO;

public interface IPersona {

	//interface para listar Personas
	public List<PersonaDTO> listPersonas();
	
	//interface para insertar Personas
	public int insertPersonas(PersonaDTO persona);
	
	//interface para actualizar personas
	public int updatePersonas(PersonaDTO persona);
	
	//interface para eliminar personas
	public int deletePersonas(PersonaDTO persona);
}
