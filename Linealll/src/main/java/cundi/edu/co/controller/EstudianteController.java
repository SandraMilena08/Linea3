package cundi.edu.co.controller;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
import cundi.edu.co.exception.ExceptionWrapper;
import cundi.edu.co.exception.ModelNotFoundException;
import cundi.edu.co.dto.ProfesorDto;
import cundi.edu.co.service.IEstudianteService;
import cundi.edu.co.service.IMaterias;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/estudiante")
@Validated
@Api(description="Servicios de Estudiante")
public class EstudianteController {
	
	@Autowired
	private IEstudianteService service;
	@Autowired
	@Qualifier("estudiante")
	private IMaterias serviceMaterias;
	
	@ApiOperation(value = "Obtener estudiantes"
            ,notes = "Este servicio traera los estudiantes que estan en el sistema")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = EstudianteDto.class ),
            @ApiResponse(code = 400, message = "Bad Request, sucedio un error"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@GetMapping(value = "/obtener/{id}", produces = "application/json")
	public EntityModel<EstudianteDto> retornarEstudiante(@PathVariable ("id") @NotNull @Min(1) int id){
			EstudianteDto estudiante;
			estudiante = service.retornarEstudiante(id);
			serviceMaterias.numeroMaterias();
			HttpHeaders header = new HttpHeaders();
	        header.add("materias", Integer.toString(serviceMaterias.numeroMaterias()) );
	        //Hateoas
	        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EstudianteController.class).retornarEstudiante(id)).withSelfRel();
	        EstudianteDto dto = service.retornarEstudiante(id);
	        dto.add(link);
	        
	        return EntityModel.of(dto);
		
	}
	
	@ApiOperation(value = "Crear estudiantes"
            ,notes = "Este servicio se encarga de crear a los estudiantes que se desean ingresar")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created(Creado)", response = EstudianteDto.class ),
            @ApiResponse(code = 400, message = "Bad Request(solicitud incorrecta), sucedio un error"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@PostMapping(value = "/crear", consumes = "application/json")
	public ResponseEntity<?> crearEstudiante(@Valid @RequestBody EstudianteDto estudiante) {
		service.crearEstudiante(estudiante);
		return new ResponseEntity<EstudianteDto>(estudiante, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Actualizar estudiantes"
            ,notes = "Este servicio se encarga de actualizar estudiantes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. El recurso se obtiene correctamente", response = EstudianteDto.class ),
            @ApiResponse(code = 400, message = "Bad Request(solicitud incorrecta), sucedio un error"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@PutMapping(value = "/actualizar", consumes="application/json")
	public ResponseEntity<?> actualizarEstudiante(@Valid @RequestBody EstudianteDto estudiante) {
		service.actualizarEstudiante(estudiante);
		return new ResponseEntity<EstudianteDto>(estudiante, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Eliminar estudiantes"
            ,notes = "Este servicio se encarga de eliminar estudiantes")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content", response = EstudianteDto.class ),
            @ApiResponse(code = 400, message = "Bad Request(solicitud incorrecta), sucedio un error"),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	@DeleteMapping(value = "/eliminar/{idUno}")
	public ResponseEntity<?> eliminarEstudiante(@PathVariable("id") @NotNull @Min(1) int id) {
		service.eliminarEstudiante(id);
		HttpHeaders header = new HttpHeaders();
		header.add("Sandris", "Prueba1");
		return new ResponseEntity<EstudianteDto>(header, HttpStatus.NO_CONTENT);
	}
}

