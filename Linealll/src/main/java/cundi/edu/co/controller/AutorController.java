package cundi.edu.co.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import cundi.edu.co.dto.AutorDto;
import cundi.edu.co.entity.Autor;
import cundi.edu.co.exception.ArgumentRequiredException;
import cundi.edu.co.exception.ConflicException;
import cundi.edu.co.exception.ModelNotFoundException;
import cundi.edu.co.service.IAutorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/autor")
@Validated
@Api(description="Servicios de Autores")

public class AutorController {
	
	@Autowired
	private IAutorService service;
	
	
	@ApiOperation(value = "Obtener Autores"
            ,notes = "Este servicio traera los Autores que estan en el sistema")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = AutorDto.class ),
            @ApiResponse(code = 400, message = "Bad Request, sucedio un error"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	
	@GetMapping(value = "/obtener/{id}", produces = "application/json")
	public ResponseEntity<?> ObtenerAutoresId(@PathVariable Integer id) throws ModelNotFoundException{
		return ResponseEntity.ok(service.retonarPorId(id));
	}
	
	@GetMapping(value = "/obtenerPaginado/{page}/{size}" ,produces = "application/json")
	public ResponseEntity<?> retonarPaginado(@PathVariable int page, @PathVariable int size) {
		Page<Autor> listaAutor = service.retornarPaginado(page, size);
		return new ResponseEntity<Page<Autor>>(listaAutor, HttpStatus.OK);	
	}	
		
	@GetMapping(value = "/obtenerPaginado" ,produces = "application/json")
	public ResponseEntity<?> retonarPaginado(Pageable page) {
		Page<Autor> listaAutor = service.retornarPaginado(page);
		return new ResponseEntity<Page<Autor>>(listaAutor, HttpStatus.OK);	
	}
		
	
	@ApiOperation(value = "Crear Autores"
            ,notes = "Este servicio se encarga de crear a los autores que se desean ingresar")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created(Creado)", response = AutorDto.class),
            @ApiResponse(code = 400, message = "Bad Request(solicitud incorrecta), sucedio un error"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@PostMapping(value = "/crear", consumes = "application/json")
	public ResponseEntity<?> crearAutor(@Valid @RequestBody Autor autor) throws ConflicException {
		service.crear(autor);
		return new ResponseEntity<Autor>(autor, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Actualizar autores"
            ,notes = "Este servicio se encarga de actualizar autores")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = AutorDto.class ),
            @ApiResponse(code = 400, message = "Bad Request(solicitud incorrecta), sucedio un error"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	
	@PutMapping(value = "/actualizar", consumes="application/json")
	public ResponseEntity<?> actualizarAutor(@Valid @RequestBody Autor autor) throws ArgumentRequiredException, ModelNotFoundException, ConflicException{
		service.editar(autor);
		return new ResponseEntity<Autor>(autor, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Eliminar autor"
            ,notes = "Este servicio se encarga de eliminar autores")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content", response = AutorDto.class ),
            @ApiResponse(code = 400, message = "Bad Request(solicitud incorrecta), sucedio un error"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@DeleteMapping(value = "/eliminar/{id}")
	public ResponseEntity<?> eliminarAutor(@PathVariable("id") @NotNull @Min(1) int id) throws ModelNotFoundException {
		service.eliminar(id);
		return new ResponseEntity<AutorDto>(HttpStatus.NO_CONTENT);
	}
}

