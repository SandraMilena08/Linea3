package cundi.edu.co.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cundi.edu.co.entity.Autor;



@Repository
public interface IAutorRepository extends JpaRepository<Autor, Integer> {
	
	public Autor findByCedula(String cedula);
	
	public Autor findByCorreo(String correo);
	
	public Boolean existsByCedula(String cedula);
	
	public Boolean existsByCorreo(String correo);
}
	