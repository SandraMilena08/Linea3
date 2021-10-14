package cundi.edu.co.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cundi.edu.co.entity.Autor;



@Repository
public interface IAutorRepo extends JpaRepository<Autor, Integer> {

}
