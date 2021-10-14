package cundi.edu.co.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cundi.edu.co.exception.ArgumentRequiredException;
import cundi.edu.co.exception.ConflicException;
import cundi.edu.co.exception.ModelNotFoundException;

public interface ICrud<T, Integer> {
	public T retornar(Integer i);
	public void crear(T estudiante) throws ConflicException;
	public void actualizar(T estudiante) throws ArgumentRequiredException, ModelNotFoundException, ConflicException;
	public void eliminar(int i) throws ModelNotFoundException;
	public Page<T> retornarPaginado(int page, int size);
	public Page<T> retornarPaginado(Pageable page);
}
