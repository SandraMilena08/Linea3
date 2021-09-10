package cundi.edu.co.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class EstudianteDto {
	@NotBlank(message = "EL nombre no puede estar vacio")
	private String nombre;
	@NotBlank(message = "EL apellido no puede estar vacio")
	private String apellido;
	private List<Materias> materias;
	
	EstudianteDto(){
		
	}
	
	public EstudianteDto(@NotBlank(message = "EL nombre no puede estar vacio") String nombre,
			@NotBlank(message = "EL apellido no puede estar vacio") String apellido, List<Materias> materias) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.materias = materias;
	}

	public List<Materias> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materias> materias) {
		this.materias = materias;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}