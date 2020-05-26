package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="cat_categoria")
public class Categoria {
	
	@Id
    @GeneratedValue(generator="cat_categoria_c_categoria_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "cat_categoria_c_categoria_seq", sequenceName = "public.cat_categoria_c_categoria_seq", allocationSize = 1)
    @Column(name = "c_categoria")
	private Integer codCategoria;
	
	@Size(message="El campo sobrepasa la cantidad de 50 caracteres", max=50)
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name="s_categoria")
	private String	categoria;
	
	@OneToMany(mappedBy="categoria",fetch = FetchType.EAGER)
	private List<Libro> libros;
	
	
	public Categoria() {
		
	}
	
	public Integer getCodCategoria() {
		return codCategoria;
	}
	public void setCodCategoria(Integer codCategoria) {
		this.codCategoria = codCategoria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	
}
