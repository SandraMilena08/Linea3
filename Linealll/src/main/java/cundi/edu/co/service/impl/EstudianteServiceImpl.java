package cundi.edu.co.service.impl;

import org.springframework.stereotype.Service;

import cundi.edu.co.dto.EstudianteDto;
import cundi.edu.co.exception.ModelNotFoundException;
import cundi.edu.co.service.IEstudianteService;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Override
	public EstudianteDto retornarEstudiante(int i) throws ModelNotFoundException {
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
		
		/*	try {
				int x = 0;
				int a = 5/x;
				
			}catch(ArithmeticException e) {
				
				throw new ArithmeticException("No se puede dividar en 0");
			}
			
			return null;
			
		}*/

		
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
