package cundi.edu.co.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cundi.edu.co.dto.EstudianteDto;
//import cundi.edu.co.exception.ModelNotFoundException;
import cundi.edu.co.dto.Materias;
import cundi.edu.co.service.IEstudianteService;
import cundi.edu.co.service.IMaterias;

@Service
@Qualifier("estudiante")
public class EstudianteServiceImpl implements IEstudianteService, IMaterias {
	
	List<Materias> materias = new ArrayList<Materias>();
	
	@Override
	public EstudianteDto retornarEstudiante(int i) {
		materias.add(new Materias ("Español"));
		EstudianteDto estudiante = new EstudianteDto("Sandra","Moreno" + i, materias);
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

	@Override
	public int numeroMaterias() {
		return materias.size();
	}
	
	/*public EstudianteDto retornarEstudiante(int i) throws ModelNotFoundException {
	try {
		if (i<= 10){
			EstudianteDto estudiante = new EstudianteDto("Sandra","Moreno" + i);
			return estudiante;
		}else {
			throw new ModelNotFoundException("Estudiante no encontrado");
		}
	} catch (ModelNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
		try {
			int x = 0;
			int a = 5/x;
			
		}catch(ArithmeticException e) {
			
			throw new ArithmeticException("No se puede dividar en 0");
		}
		
		return null;
		
	}*/

}
