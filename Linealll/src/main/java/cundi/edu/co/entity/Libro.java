package cundi.edu.co.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "EL nombre no puede estar vacio")
	@Size(min = 2, max = 15, message = "Ingrese un valor entre 2 y 15 caracteres")
	@Column(name="nombre", length=15, nullable = false)
	private String nombre;
	
	@NotNull(message = "La descripción no puede estar vacia")
	@Size(min = 2, max = 50, message = "Ingrese un valor entre 2 y 30 caracteres")
	@Column(name="descripcion", length=50, nullable = false)
	private String descripcion;
	
	@NotNull(message = "EL numero de paginas no puede estar vacio")
	@Min(1)
	@Column(name="numPaginas", length=50, nullable = false)
	private Integer numPaginas;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_autor", nullable = false)
	private Autor autor;
	
	public Libro() {
		super();
	}

	
	
	public Libro(Integer id,
			@NotNull(message = "EL nombre no puede estar vacio") @Size(min = 2, max = 15, message = "Ingrese un valor entre 2 y 15 caracteres") String nombre,
			@NotNull(message = "La descripción no puede estar vacia") @Size(min = 2, max = 50, message = "Ingrese un valor entre 2 y 30 caracteres") String descripcion,
			@NotNull(message = "EL numero de paginas no puede estar vacio") @Min(1) Integer numPaginas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.numPaginas = numPaginas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}



	public Autor getAutor() {
		return autor;
	}



	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
}
