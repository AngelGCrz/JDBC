package com.pe.jdbc.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pe.jdbc.domain.PersonaDTO;

public class PersonaDAO implements IPersona {

	private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
	private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono)VALUES(?, ? , ? , ?)";
	private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, email=?, telefono=? WHERE id_persona = ?";
	private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	PersonaDTO persona = null;
	List<PersonaDTO> personas = new ArrayList<>();
	int registrarPersona = 0;

	@Override
	public List<PersonaDTO> listPersonas() {
		try {
			con = Conexion.getConnection();
			pst = con.prepareStatement(SQL_SELECT);
			rs = pst.executeQuery();

			while (rs.next()) {
				int idPersona = rs.getInt("id_persona");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");

				persona = new PersonaDTO(idPersona, nombre, apellido, email, telefono);
				personas.add(persona);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return personas;
	}

	@Override
	public int insertPersonas(PersonaDTO persona) {
		try {
			con = Conexion.getConnection();
			pst = con.prepareStatement(SQL_INSERT);

			pst.setString(1, persona.getNombre());
			pst.setString(2, persona.getApellido());
			pst.setString(3, persona.getEmail());
			pst.setString(4, persona.getTelefono());

			registrarPersona = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pst != null) {
					pst.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return registrarPersona;
	}

	@Override
	public int updatePersonas(PersonaDTO persona) {
		try {
			con = Conexion.getConnection();
			pst = con.prepareStatement(SQL_UPDATE);

			pst.setString(1, persona.getNombre());
			pst.setString(2, persona.getApellido());
			pst.setString(3, persona.getEmail());
			pst.setString(4, persona.getTelefono());
			pst.setInt(5, persona.getIdPersona());

			registrarPersona = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pst != null) {
					pst.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return registrarPersona;
	}

	@Override
	public int deletePersonas(PersonaDTO persona) {
		try {
			con = Conexion.getConnection();
			pst = con.prepareStatement(SQL_DELETE);

			pst.setInt(1, persona.getIdPersona());
			registrarPersona = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pst != null) {
					pst.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return registrarPersona;
	}

}
