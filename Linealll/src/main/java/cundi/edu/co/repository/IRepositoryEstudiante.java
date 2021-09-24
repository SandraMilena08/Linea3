package cundi.edu.co.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cundi.edu.co.entity.Estudiante;

@Repository
public interface IRepositoryEstudiante extends JpaRepository<Estudiante, Integer> {

}
