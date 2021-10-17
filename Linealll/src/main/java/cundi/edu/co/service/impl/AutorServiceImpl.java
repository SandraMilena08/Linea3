package cundi.edu.co.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cundi.edu.co.entity.Autor;
import cundi.edu.co.exception.ArgumentRequiredException;
import cundi.edu.co.exception.ConflicException;
import cundi.edu.co.exception.ModelNotFoundException;
import cundi.edu.co.repository.IAutorRepository;
import cundi.edu.co.service.IAutorService;

@Service
public class AutorServiceImpl implements IAutorService {

	@Autowired
	private IAutorRepository repo;

	@Override
	public Page<Autor> retornarPaginado(int page, int size) {
		return repo.findAll(PageRequest.of(page,size));
	}

	@Override
	public Page<Autor> retornarPaginado(Pageable page) {
		return repo.findAll(page);
	}

	@Override
	public Autor retonarPorId(Integer idEntity) throws ModelNotFoundException {
		return repo.findById(idEntity).orElseThrow(() -> new ModelNotFoundException("Autor no encontrado"));
	}

	@Override
	public void editar(Autor entity) throws ArgumentRequiredException, ModelNotFoundException, ConflicException {
		repo.save(entity);
	}

	@Override
	public void eliminar(int idEntity) throws ModelNotFoundException {
	//	if(validarExistenciaPorId(idEntity))
			this.repo.deleteById(idEntity);
	//	else
	//		throw new ModelNotFoundException("Estudiante no encontrado");
	}
	

	@Override
	public void crear(Autor entity) throws ConflicException {
		 this.repo.save(entity);
	}

	@Override
	public List<Autor> obtener(){
		List<Autor> autores = repo.findAll();
		 return autores;
	}
	
	private Boolean validarExistenciaPorId(int idAutor) {
		return repo.existsById(idAutor);
	}

}