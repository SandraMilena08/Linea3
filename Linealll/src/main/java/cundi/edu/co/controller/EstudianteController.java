package cundi.edu.co.controller;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cundi.edu.co.dto.EstudianteDto;
import cundi.edu.co.exception.ModelNotFoundException;
import cundi.edu.co.dto.ProfesorDto;
import cundi.edu.co.service.IEstudianteService;
import cundi.edu.co.service.IMaterias;

@RestController
@RequestMapping("/estudiante")
@Validated
public class EstudianteController {
	
	@Autowired
	private IEstudianteService service;
	@Autowired
	@Qualifier("estudiante")
	private IMaterias serviceMaterias;
	
	@GetMapping(value = "/obtener/{id}", produces = "application/json")
	public ResponseEntity<EstudianteDto> retornarEstudiante(@PathVariable int id) throws ModelNotFoundException {
		EstudianteDto estudiante = service.retornarEstudiante(id);
		serviceMaterias.numeroMaterias();
		HttpHeaders header = new HttpHeaders();
        header.add("materias", Integer.toString(serviceMaterias.numeroMaterias()) );
        return new ResponseEntity<EstudianteDto>( estudiante, header, HttpStatus.OK);
	}
	
	@PostMapping(value = "/crear", consumes = "application/json")
	public ResponseEntity<?> crearEstudiante(@Valid @RequestBody EstudianteDto estudiante) {
		service.crearEstudiante(estudiante);
		return new ResponseEntity<EstudianteDto>(estudiante, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes="application/json")
	public ResponseEntity<?> actualizarEstudiante(@Valid @RequestBody EstudianteDto estudiante) {
		service.actualizarEstudiante(estudiante);
		return new ResponseEntity<EstudianteDto>(estudiante, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{i}")
	public ResponseEntity<?> eliminarEstudiante(@PathVariable int i) {
		service.eliminarEstudiante(i);
		HttpHeaders header = new HttpHeaders();
		header.add("Sandris", "Prueba1");
		return new ResponseEntity<EstudianteDto>(header, HttpStatus.NO_CONTENT);
	}
}

