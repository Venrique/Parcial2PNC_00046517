package com.uca.capas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.CategoriaDAO;
import com.uca.capas.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	CategoriaDAO categoriaDao;

	
	public List<Categoria> findAll() throws DataAccessException {
		return categoriaDao.findAll();
	}

	
	public Categoria findOne(Integer codigo) throws DataAccessException {
		return categoriaDao.findOne(codigo);
	}

	@Transactional
	public void guardar(Categoria categoria) throws DataAccessException {
		categoriaDao.guardar(categoria);
	}

}
