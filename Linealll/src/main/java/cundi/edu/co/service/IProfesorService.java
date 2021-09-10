package cundi.edu.co.service;

import org.springframework.beans.factory.annotation.Qualifier;

import cundi.edu.co.dto.ProfesorDto;

public interface IProfesorService {
	public ProfesorDto retornarProfesor(int number, String emocion, String correo);
	public void crearProfesor(ProfesorDto profesor);
	public void actualizarProfesor(ProfesorDto profesor);
	public void eliminarProfesor(int id);
}
