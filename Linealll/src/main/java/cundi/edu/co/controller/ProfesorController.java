//Paquetes
package cundi.edu.co.controller;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
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
import cundi.edu.co.service.IProfesorService;



@RestController
@RequestMapping("/profesor")
@Validated
public class ProfesorController {

	@Autowired
	private IProfesorService service;
	
	@GetMapping(value = "/obtener/{number}/{emocion}", produces = "application/json")
	public ResponseEntity<ProfesorDto> retornarProfesor(@PathVariable ("number") @Min(2) @Max(4)int number,@PathVariable ("emocion") @Size(min=1, max=3) String emocion) {
		ProfesorDto profesor = service.retornarProfesor(number,emocion);
		return new ResponseEntity<ProfesorDto>(profesor, HttpStatus.OK);
	}
	
	@PostMapping(value = "/crear", consumes = "application/json")
	public ResponseEntity<?> crearProfesor(@Valid @RequestBody ProfesorDto profesor) {
		service.crearProfesor(profesor);
		return new ResponseEntity<ProfesorDto>(profesor, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/actualizar", consumes="application/json")
	public ResponseEntity<?> actualizarProfesor(@Valid @RequestBody ProfesorDto profesor) {
		ProfesorDto pro = new ProfesorDto("Milena","461217245","3107553158", (short) 21,"sandra.duarte0806@gmail.com");
		return new ResponseEntity<ProfesorDto>(profesor, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{i}")
	public ResponseEntity<?> eliminarProfesor(@PathVariable int i) {
		ProfesorDto pro = new ProfesorDto("Milena","461217245","3107553158", (short) (21+i), "sandra.duarte0806@gmail.com");
		return new ResponseEntity<ProfesorDto>(pro, HttpStatus.NO_CONTENT);
	}
}
