package com.uca.capas.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.CategoriaDAO;
import com.uca.capas.dao.LibroDAO;
import com.uca.capas.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	LibroDAO libroDao;
	
	@Autowired
	CategoriaDAO categoriaDao;

	
	public List<Libro> findAll() throws DataAccessException {
		return libroDao.findAll();
	}

	@Transactional
	public void guardar(Libro l) throws DataAccessException {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
		LocalDateTime now = LocalDateTime.now();
		
		String fecha = dtf.format(now);
		
		try {
			l.setFechaIngreso(new SimpleDateFormat("dd/MM/yyyy hh:mm a").parse(fecha));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		try {
			l.setCategoria(categoriaDao.findOne(l.getCodCategoria()));
			libroDao.guardar(l);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
