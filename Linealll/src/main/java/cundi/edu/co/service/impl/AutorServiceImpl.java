package cundi.edu.co.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cundi.edu.co.entity.Autor;
import cundi.edu.co.exception.ArgumentRequiredException;
import cundi.edu.co.exception.ConflicException;
import cundi.edu.co.exception.ModelNotFoundException;
import cundi.edu.co.repository.IAutorRepo;
import cundi.edu.co.service.IAutor;

public class AutorServiceImpl implements IAutor {

	@Autowired
	private IAutorRepo repo;
	
	@Override
	public Autor retornar(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crear(Autor estudiante) throws ConflicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Autor estudiante)
			throws ArgumentRequiredException, ModelNotFoundException, ConflicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int i) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Autor> retornarPaginado(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Autor> retornarPaginado(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
