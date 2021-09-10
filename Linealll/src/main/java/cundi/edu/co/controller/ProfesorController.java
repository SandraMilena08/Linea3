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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/profesor")
@Validated
@Api(description="Servicios de Profesor")
public class ProfesorController {
	
	@Autowired
	private IProfesorService service;
	@Autowired
	@Qualifier("profesor")
	private IMaterias serviceMaterias;
	
	@ApiOperation(value = "Obtener profesores"
            ,notes = "Este servicio traera los profesores que estan en el sistema")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = ProfesorDto.class ),
            @ApiResponse(code = 400, message = "Bad Request, sucedio un error", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@GetMapping(value = "/obtener/{number}/{emocion}/{email}", produces = "application/json")
	public ResponseEntity<ProfesorDto> retornarProfesor(@PathVariable ("number") @Min(2) @Max(4)int number,@PathVariable ("emocion") @Size(min=1, max=8) String emocion, @PathVariable ("email") @Size(min=8, max=20) @Email String email) {
		ProfesorDto profesor = service.retornarProfesor(number,emocion,email);
		serviceMaterias.numeroMaterias();
		HttpHeaders header = new HttpHeaders();
        header.add("materias", Integer.toString(serviceMaterias.numeroMaterias()) );
        return new ResponseEntity<ProfesorDto>( profesor, header, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Crear profesores"
            ,notes = "Este servicio se encarga de crear a los profesores que se desean ingresar")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Creado", response = ProfesorDto.class ),
            @ApiResponse(code = 400, message = "Bad Request, sucedio un error", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@PostMapping(value = "/crear", consumes = "application/json")
	public ResponseEntity<?> crearProfesor(@Valid @RequestBody ProfesorDto profesor) {
		service.crearProfesor(profesor);
		return new ResponseEntity<ProfesorDto>(profesor, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Actualizar profesores"
            ,notes = "Este servicio se encarga de actualizar profesores")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = ProfesorDto.class ),
            @ApiResponse(code = 400, message = "Bad Request, sucedio un error", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@PutMapping(value = "/actualizar", consumes="application/json")
	public ResponseEntity<?> actualizarProfesor(@Valid @RequestBody ProfesorDto profesor) {
		service.actualizarProfesor(profesor);
		return new ResponseEntity<ProfesorDto>(profesor, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Eliminar profesores"
            ,notes = "Este servicio se encarga de eliminar profesores")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No_Content", response = ProfesorDto.class ),
            @ApiResponse(code = 400, message = "Bad Request, sucedio un error", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@DeleteMapping(value = "/eliminar/{id}")
	public ResponseEntity<?> eliminarProfesor(@PathVariable("id") @NotNull @Min(1) int id) {
		service.eliminarProfesor(id);
		return new ResponseEntity<ProfesorDto>(HttpStatus.NO_CONTENT);
	}
}
