package cundi.edu.co.service;

import org.springframework.beans.factory.annotation.Qualifier;

import cundi.edu.co.dto.ProfesorDto;

public interface IProfesorService {
	public ProfesorDto retornarProfesor(int number, String emocion, String correo);
	public ProfesorDto crearProfesor();
	public ProfesorDto actualizarProfesor();
	public void eliminarProfesor(int id);
}
