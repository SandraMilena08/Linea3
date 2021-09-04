package cundi.edu.co.service.impl;

import org.springframework.stereotype.Service;

import cundi.edu.co.dto.EstudianteDto;
import cundi.edu.co.service.IEstudianteService;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Override
	public EstudianteDto retornarEstudiante(int i) {
		EstudianteDto estudiante = new EstudianteDto("Sandra","Moreno" + i);
		return estudiante;
		
	}

	@Override
	public void crearEstudiante(EstudianteDto estudiante) {
		System.out.println("Entre metodo crear");
		
	}

	@Override
	public void actualizarEstudiante(EstudianteDto estudiante) {
		System.out.println("Entre metodo actualizar");
		
	}

	@Override
	public void eliminarEstudiante(int i) {
		System.out.println("Entre metodo eliminar");
	}

}
