package cundi.edu.co.service.impl;

import org.springframework.stereotype.Service;

import cundi.edu.co.dto.ProfesorDto;
import cundi.edu.co.service.IProfesorService;

@Service
public class ProfesorServiceImpl implements IProfesorService {
	
	
	@Override
	public ProfesorDto retornarProfesor(int number, String emocion, String email) {
		ProfesorDto profesor = new ProfesorDto("Sandra","461217245","3107553158", (short) (21 + number), "sandra.duarte0806@gmail.com" + emocion + email);
		return profesor;
	}

	@Override
	public void crearProfesor(ProfesorDto profesor) {
		System.out.println("Entre metodo crear");
	}

	@Override
	public void actualizarProfesor(ProfesorDto profesor) {
		System.out.println("Entre metodo actualizar");
		
	}

	@Override
	public void eliminarProfesor(int i) {
		System.out.println("Entre metodo eliminar");
	}

}
