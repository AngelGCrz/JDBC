package com.pe.jdbc.presentacion;

import java.util.List;

import com.pe.jdbc.datos.PersonaDAO;
import com.pe.jdbc.domain.PersonaDTO;

public class Main {

	public static void main(String[] args) {
		eliminarPersona();
		//actualizarPersona();
		//insertarPersona();
		listarPersona();
	}

	public static void listarPersona() {
		PersonaDAO personaDao = new PersonaDAO();
		List<PersonaDTO> personas = personaDao.listPersonas();
		for (PersonaDTO persona : personas) {
			System.out.println(persona);
		}
	}

	public static void insertarPersona() {
		PersonaDTO personaDto = new PersonaDTO("aaa", "bbb", "ccc", "ddd");

		PersonaDAO personaDao = new PersonaDAO();

		// insertar persona nueva
		int nuevaPersona = personaDao.insertPersonas(personaDto);

		if (nuevaPersona > 0) {
			System.out.println("Registro exitoso");
		} else {
			System.out.println("Error en el Registro");
		}
	}

	public static void actualizarPersona() {

		PersonaDTO personaDto = new PersonaDTO(4, "Antonia", "Cruz", "null", "null");
		PersonaDAO personaDao = new PersonaDAO();

		int personasNuevas = personaDao.updatePersonas(personaDto);

		if (personasNuevas > 0) {
			System.out.println("Exito: Se actualizó la persona");
		} else {
			System.out.println("Error: No se pudo actualizar la persona");
		}
	}
	
	public static void eliminarPersona() {
		
		PersonaDTO personaDto = new PersonaDTO(5);
		PersonaDAO personaDao = new PersonaDAO();
		int eliminarPersona = personaDao.deletePersonas(personaDto);
		if (eliminarPersona > 0) {
			System.out.println("Exito: Se elimino la persona");
		} else {
			System.out.println("Error: No se pudo eliminar la persona");
		}
	}
}
