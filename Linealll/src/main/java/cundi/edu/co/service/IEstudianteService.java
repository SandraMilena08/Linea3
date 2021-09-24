package cundi.edu.co.service;

import cundi.edu.co.dto.EstudianteDto;
import cundi.edu.co.exception.ModelNotFoundException;

public interface IEstudianteService {
	public EstudianteDto retornarEstudiante(int i);
	public void crearEstudiante(EstudianteDto estudiante);
	public void actualizarEstudiante(EstudianteDto estudiante);
	public void eliminarEstudiante(int i);
}
