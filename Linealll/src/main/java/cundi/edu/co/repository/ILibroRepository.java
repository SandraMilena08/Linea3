package cundi.edu.co.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cundi.edu.co.entity.Autor;
import cundi.edu.co.entity.Libro;

public interface ILibroRepository extends JpaRepository<Libro, Integer>{
	
	public Boolean existsByNombre(String nombre);

	@Query(value = "SELECT l FROM Libro l INNER JOIN Autor a ON l.autor = a.id WHERE a.id = ?1")
	public List<Libro> buscarAutor(int id);
}
