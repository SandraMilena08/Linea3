package cundi.edu.co.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cundi.edu.co.entity.Autor;
import cundi.edu.co.exception.ArgumentRequiredException;
import cundi.edu.co.exception.ConflicException;
import cundi.edu.co.exception.ModelNotFoundException;
import cundi.edu.co.repository.IAutorRepository;
import cundi.edu.co.service.IAutorService;

public class AutorServiceImpl implements IAutorService {

	@Autowired
	private IAutorRepository repo;

	@Override
	public Page<Autor> retornarPaginado(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Autor> retornarPaginado(Pageable page) {
		return repo.findAll(page);
	}

	@Override
	public Autor retonarPorId(Integer idEntity) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Autor entity) throws ConflicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Autor entity) throws ArgumentRequiredException, ModelNotFoundException, ConflicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int idEntity) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crear(Autor entity) throws ConflicException {
		// TODO Auto-generated method stub
		
	}

}