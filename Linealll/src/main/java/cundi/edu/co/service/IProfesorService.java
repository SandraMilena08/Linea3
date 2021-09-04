package cundi.edu.co.service;

import cundi.edu.co.dto.ProfesorDto;

public interface IProfesorService {
	public ProfesorDto retornarProfesor(int number, String emocion);
	public void crearProfesor(ProfesorDto profesor);
	public void actualizarProfesor(ProfesorDto profesor);
	public void eliminarProfesor(int i);
}
