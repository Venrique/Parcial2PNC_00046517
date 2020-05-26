package com.uca.capas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="cat_libro")
public class Libro {
	
	@Id
    @GeneratedValue(generator="cat_libro_c_libro_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "cat_libro_c_libro_seq", sequenceName = "public.cat_libro_c_libro_seq", allocationSize = 1)
    @Column(name = "c_libro")
	private Integer codLibro;
	
	@Size(message="El campo sobrepasa la cantidad de 500 caracteres", max=500)
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name = "s_titulo")
	private String titulo;
	
	@Size(message="El campo sobrepasa la cantidad de 150 caracteres", max=150)
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name = "s_autor")
	private String autor;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="c_categoria")
	private Categoria categoria;
	
	@Transient
	private Integer codCategoria;
	
	@Column(name = "f_ingreso")
	private Date fechaIngreso;
	
	@Column(name = "b_estado")
	private Boolean estado;
	
	@Size(message="El campo sobrepasa la cantidad de 10 caracteres", max=10)
	@NotEmpty(message="El campo no puede estar vacio")
	@Column(name = "s_isbn")
	private String isbn;
	
	
	public Libro() {
		
	}
	
	public Integer getCodLibro() {
		return codLibro;
	}
	public void setCodLibro(Integer codLibro) {
		this.codLibro = codLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Integer getCodCategoria() {
		return codCategoria;
	}
	public void setCodCategoria(Integer codCategoria) {
		this.codCategoria = codCategoria;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getIsbn() {
		return isbn;
	}
	
	
}
