package cundi.edu.co.dto;

import javax.validation.constraints.NotBlank;

public class EstudianteDto {
	@NotBlank(message = "EL nombre no puede estar vacio")
	private String nombre;
	@NotBlank(message = "EL apellido no puede estar vacio")
	private String apellido;
	
	EstudianteDto(){
		
	}
	
	public EstudianteDto (String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		
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