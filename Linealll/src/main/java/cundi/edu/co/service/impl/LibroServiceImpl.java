package cundi.edu.co.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cundi.edu.co.entity.Libro;
import cundi.edu.co.exception.ArgumentRequiredException;
import cundi.edu.co.exception.ConflicException;
import cundi.edu.co.exception.ModelNotFoundException;
import cundi.edu.co.repository.ILibroRepository;
import cundi.edu.co.service.ILibroService;

@Service
public class LibroServiceImpl implements ILibroService{

	@Autowired
	private ILibroRepository repo;
	
	@Override
	public Page<Libro> retornarPaginado(int page, int size) {
		return repo.findAll(PageRequest.of(page,size));
	}

	@Override
	public Page<Libro> retornarPaginado(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro retonarPorId(Integer idEntity) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> obtener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crear(Libro entity) throws ConflicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Libro entity) throws ArgumentRequiredException, ModelNotFoundException, ConflicException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int idEntity) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
