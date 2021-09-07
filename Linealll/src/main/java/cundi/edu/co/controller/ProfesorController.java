//Paquetes
package cundi.edu.co.controller;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
//Librerias
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

import cundi.edu.co.dto.ProfesorDto;
import cundi.edu.co.service.IMaterias;
import cundi.edu.co.service.IProfesorService;


@RestController
@RequestMapping("/profesor")
@Validated
public class ProfesorController {
	
	@Autowired
	private IProfesorService service;
	@Autowired
	@Qualifier("profesor")
	private IMaterias serviceMaterias;
	
	
	@GetMapping(value = "/obtener/{number}/{emocion}/{email}", produces = "application/json")
	public ResponseEntity<ProfesorDto> retornarProfesor(@PathVariable ("number") @Min(2) @Max(4)int number,@PathVariable ("emocion") @Size(min=1, max=8) String emocion, @PathVariable ("email") @Size(min=8, max=20) @Email String email) {
		ProfesorDto profesor = service.retornarProfesor(number,emocion,email);
		serviceMaterias.numeroMaterias();
		HttpHeaders header = new HttpHeaders();
        header.add("materias", Integer.toString(serviceMaterias.numeroMaterias()) );
        return new ResponseEntity<ProfesorDto>( profesor, header, HttpStatus.OK);
	}
	
	@PostMapping(value = "/crear", consumes = "application/json")
	public ResponseEntity<?> crearProfesor(@Valid @RequestBody ProfesorDto profesor) {
		service.crearProfesor(profesor);
		return new ResponseEntity<ProfesorDto>(profesor, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes="application/json")
	public ResponseEntity<?> actualizarProfesor(@Valid @RequestBody ProfesorDto profesor) {
		service.actualizarProfesor(profesor);
		return new ResponseEntity<ProfesorDto>(profesor, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public ResponseEntity<?> eliminarProfesor(@PathVariable("id") @NotNull @Min(1) int id) {
		service.eliminarProfesor(id);
		return new ResponseEntity<ProfesorDto>(HttpStatus.NO_CONTENT);
	}
}
