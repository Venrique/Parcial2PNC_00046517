package com.uca.capas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;


@Controller
public class MainController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	LibroService libroService;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		
		ModelAndView mav = new ModelAndView();
		
	
		mav.setViewName("index");
		
		return mav;
	}
	
	@RequestMapping("/categoria")
	public ModelAndView formCategoria() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("categoria", new Categoria());
		mav.setViewName("categoria");
		
		return mav;
	}
	
	@RequestMapping("/formCategoria")
	public ModelAndView guardarCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("categoria");
		}else {
			
			try {
				categoriaService.guardar(categoria);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("exito","Categoría guardada con éxito");
			mav.setViewName("index");
		}
			
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView verLibros() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("libros", libroService.findAll());
		mav.setViewName("listadoLibros");
		
		return mav;
	}
	
	@RequestMapping("/libro")
	public ModelAndView formLibro() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("libro", new Libro());
		mav.addObject("categorias", categoriaService.findAll());
		mav.setViewName("libro");
		
		return mav;
	}
	
	@RequestMapping("/formLibro")
	public ModelAndView guardarLibro(@Valid @ModelAttribute Libro libro, BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.addObject("categorias", categoriaService.findAll());
			mav.setViewName("libro");
		}else {
			try {
				libroService.guardar(libro);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("exito","Libro guardado con éxito");
			mav.setViewName("index");
		}
		
		
		
		return mav;
	}
	
}
